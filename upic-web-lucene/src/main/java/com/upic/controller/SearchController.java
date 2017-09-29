package com.upic.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queries.function.FunctionQuery;
import org.apache.lucene.queries.function.valuesource.DoubleFieldSource;
import org.apache.lucene.queries.function.valuesource.FieldCacheSource;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upi.lucene.queryparser.UpicMutilsQueryParser;
import com.upic.common.entity.CenterSearch;
import com.upic.common.page.PageBean;
import com.upic.lucene.emuns.SearchTypeEnum;
import com.upic.lucene.utils.RecencyBoostCustomScoreQuery;
import com.upic.lucne.po.KeyWord;
import com.upic.lucne.po.NeedSearchFields;
import com.upic.page.LuceneUtils;
import com.upic.utils.ParseDataManger;
import com.upic.utils.ParseUtils;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/search")
public class SearchController {
	private static final String STARTTAG = "<font color='red'>";
	private static final String ENDTAG = "</font>";
	private static Log log = LogFactory.getLog(SearchController.class);
	// private IndexWriter indexWrtier =
	// LuceneUtils.getIndexWrtier(LuceneUtils.f,
	// new IndexWriterConfig(LuceneUtils.analyzer));
	@Autowired
	private IndexWriter indexWrtier;

	/**
	 * 二级页面多条件查询时候
	 * 
	 * @param json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchBySecond")
	public PageBean searchBeanByCondi(@RequestParam("data") String json,HttpSession session) {
		try {
			json=URLDecoder.decode(json, "utf-8");
			json=ParseDataManger.dealJson(json);
			CenterSearch<Object> searchBean = ParseDataManger.getSearchBean(json, CenterSearch.class);
			searchBean.setT(ParseDataManger.getSearchInnerBean(searchBean.getT(),
					Class.forName(SearchTypeEnum.CLASSHOME.getDesc() + searchBean.getSearchClass())));
			int pageNumStr = Integer.parseInt(searchBean.getPageNumStr());
			int numPerPageStr = Integer.parseInt(searchBean.getNumPerPageStr());
			// 分装数组
			List<Object> string = ParseDataManger.getSearchArrays(JSONObject.fromObject(searchBean.getT()).toString(),
					searchBean.getT().getClass());
			// 查询关键字
			string = ParseDataManger.jugeHaveKeyWord(searchBean, string);
			IndexSearcher indexSearcher = getSearcher();
			Query q = UpicMutilsQueryParser.parse((String[]) string.get(1), (String[]) string.get(0),
					(Occur[]) string.get(2), LuceneUtils.analyzer);
			// 1、创建一个评分域
			FieldCacheSource fieldCacheSource = new DoubleFieldSource("score");
			FunctionQuery fd = new FunctionQuery(fieldCacheSource);
			// 2、根据评分域和原有的Query创建自定义的Query对象
			RecencyBoostCustomScoreQuery query = new RecencyBoostCustomScoreQuery(q, fd, searchBean,
					ParseUtils.getAllSearchType(new NeedSearchFields()));
			List<Document> docList = LuceneUtils.getLastScoreDoc(pageNumStr, numPerPageStr, query, indexSearcher,session);

			PageBean pageBeanByDocument = ParseUtils.getPageBeanByDocument(pageNumStr,numPerPageStr,docList, searchBean,session);
			pageBeanByDocument.setCurrentPage(pageNumStr);
			pageBeanByDocument.setNumPerPage(numPerPageStr);
			return pageBeanByDocument;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * keyWord查询
	 * 
	 * @param json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchBySecondkeyWord")
	public List<KeyWord> searchBeanBykeyWord(@RequestParam("keyWord") String keyWord,
			@RequestParam("city") String city) {
		try {
			int pageNumStr = 1;
			int numPerPageStr = 10;
			city=city.substring(0, city.length()-1);
			Term prefixTerm = new Term(SearchTypeEnum.SHOPTITLE.getDesc(), keyWord);
			PrefixQuery query = new PrefixQuery(prefixTerm);
			IndexSearcher indexSearcher = getSearcher();
			Query q = UpicMutilsQueryParser.parse(new String[] { city,city }, new String[] { "city","biosphere" },
					new Occur[] { Occur.SHOULD,Occur.SHOULD }, LuceneUtils.analyzer);
			BooleanQuery.Builder bQuery = new BooleanQuery.Builder();
			bQuery.add(query, Occur.MUST);
			bQuery.add(q, Occur.MUST);
			// 1、创建一个评分域
			// 2、根据评分域和原有的Query创建自定义的Query对象
			List<Document> docList = LuceneUtils.getLastScoreDoc(pageNumStr, numPerPageStr, bQuery.build(),
					indexSearcher);
			List<KeyWord> keyList = new ArrayList<KeyWord>();
			for (Document doc : docList) {
				KeyWord k = new KeyWord(doc.get(SearchTypeEnum.SHOPTITLE.getDesc()));
				keyList.add(k);
			}
			return keyList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private IndexSearcher getSearcher() throws IOException {
		return new IndexSearcher(DirectoryReader.open(indexWrtier.getDirectory()));
	}

	@SuppressWarnings("unused")
	private ScoreDoc getLastScoreDoc(int pageIndex, int pageSize, Query query, IndexSearcher searcher)
			throws IOException {
		if (pageIndex == 1)
			return null;// 如果是第一页就返回空
		int num = pageSize * (pageIndex - 1);// 获取上一页的最后数量
		TopDocs tds = searcher.search(query, num);
		return tds.scoreDocs[num - 1];
	}
}
