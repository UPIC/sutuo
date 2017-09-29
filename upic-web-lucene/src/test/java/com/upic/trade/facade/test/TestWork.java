//package com.upic.trade.facade.test;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.activation.MimetypesFileTypeMap;
//
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.document.SortedDocValuesField;
//import org.apache.lucene.document.StoredField;
//import org.apache.lucene.document.TextField;
//import org.apache.lucene.index.CorruptIndexException;
//import org.apache.lucene.index.IndexReader;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.queries.function.FunctionQuery;
//import org.apache.lucene.queries.function.valuesource.DoubleFieldSource;
//import org.apache.lucene.queries.function.valuesource.FieldCacheSource;
//import org.apache.lucene.queryparser.classic.ParseException;
//import org.apache.lucene.search.BooleanClause;
//import org.apache.lucene.search.BooleanClause.Occur;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.LockObtainFailedException;
//import org.apache.lucene.store.RAMDirectory;
//import org.apache.lucene.util.BytesRef;
//
//import com.upi.lucene.queryparser.UpicMutilsQueryParser;
//import com.upic.common.entity.CenterSearch;
//import com.upic.common.entity.SearchPo;
//import com.upic.lucene.utils.CustomParser;
//import com.upic.lucene.utils.RecencyBoostCustomScoreQuery;
//import com.upic.page.LuceneUtils;
//import com.upic.utils.ParseDataManger;
//
//import net.sf.json.JSONObject;
//
//public class TestWork {
//	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//	static Directory f = LuceneUtils.openFSDirectory("f:\\test\\lucene_index");
//
//	/**
//	 * 测试查询（单个数据）
//	 * 
//	 * @param value
//	 * @throws ParseException
//	 */
//	public static void test01(String value) throws ParseException {
//		IndexReader indexReader = LuceneUtils.getIndexReader(f, true);
//		IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher(indexReader);
//		CustomParser c = new CustomParser("filename", LuceneUtils.analyzer);
//		Query q = c.parse(value);
//		// 1、创建一个评分域
//		FieldCacheSource fieldCacheSource = new DoubleFieldSource("score");
//		FunctionQuery fd = new FunctionQuery(fieldCacheSource);
//		// 2、根据评分域和原有的Query创建自定义的Query对象
//		RecencyBoostCustomScoreQuery query = new RecencyBoostCustomScoreQuery(q, fd);
//		List<Document> docList = LuceneUtils.query(indexSearcher, query);
//		for (Document d : docList) {
//			System.out.println("[" + d.get("filename") + "【" + d.get("path") + "】--->" + d.get("size") + "-----"
//					+ sdf.format(new Date(Long.valueOf(d.get("date")))) + "]");
//		}
//	}
//
//	/**
//	 * 建立索引
//	 */
//	public static void index() {
//		IndexWriter indexWrtier = LuceneUtils.getIndexWrtier(f, new IndexWriterConfig(LuceneUtils.analyzer));
//		try {
//			if (true) {
//				indexWrtier.deleteAll();
//			}
//			File file = new File("f:\\java\\JavaWrite");
//			Document doc = null;
//			for (File f : file.listFiles()) {
//				doc = new Document();
//				doc.add(new StoredField("filename", f.getName(), TextField.TYPE_STORED));
//				doc.add(new SortedDocValuesField("filename", new BytesRef(f.getName())));
//				doc.add(new StoredField("type", new MimetypesFileTypeMap().getContentType(f), TextField.TYPE_STORED));
//				doc.add(new Field("path", f.getAbsolutePath(), TextField.TYPE_STORED));
//				doc.add(new StoredField("date", f.lastModified()));
//				doc.add(new StoredField("size", ((int) (f.length() / 1024))));
//
//				indexWrtier.addDocument(doc);
//			}
//		} catch (CorruptIndexException e) {
//			e.printStackTrace();
//		} catch (LockObtainFailedException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (indexWrtier != null)
//					indexWrtier.close();
//			} catch (CorruptIndexException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static void MutilSearch(String filename, String type) throws ParseException {
//		IndexReader indexReader = LuceneUtils.getIndexReader(f, true);
//		IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher(indexReader);
//		// CustomParser c = new CustomParser("filename", LuceneUtils.analyzer);
//		String filed[] = { "filename", "type" };
//		String content[] = { filename, type };
//
//		BooleanClause.Occur booleanSearch[] = { BooleanClause.Occur.MUST, BooleanClause.Occur.SHOULD };
//		// Query q =
//		// MultiFieldQueryParser.parse(content,filed,booleanSearch,LuceneUtils.analyzer);
//		Query q = UpicMutilsQueryParser.parse(content, filed, booleanSearch, LuceneUtils.analyzer);
//		// 1、创建一个评分域
//		FieldCacheSource fieldCacheSource = new DoubleFieldSource("score");
//		FunctionQuery fd = new FunctionQuery(fieldCacheSource);
//		// 2、根据评分域和原有的Query创建自定义的Query对象
//		RecencyBoostCustomScoreQuery query = new RecencyBoostCustomScoreQuery(q, fd);
//		List<Document> docList = LuceneUtils.query(indexSearcher, query);
//		for (Document d : docList) {
//			System.out.println("[" + d.get("filename") + "【" + d.get("path") + "】--->" + d.get("size") + "-----"
//					+ sdf.format(new Date(Long.valueOf(d.get("date")))) + "]");
//		}
//	}
//
//	// public void change(int i) {
//	// Builder b = new Builder();
//	// b.setMinimumNumberShouldMatch(i);
//	// }
//
//	public static void test() {
//		Directory dir = new RAMDirectory();
//		simulation(dir);
//		SearchPo po = new SearchPo();
////		po.setSearchType("shop");
////		po.setPlayType("project");
////		po.setFirstTypeName("教育");
////		po.setBiosphere("鄞州区");
////		po.setSecondTypeName("打飞机");
//		List<Object> string = ParseDataManger.getSearchArrays(JSONObject.fromObject(po).toString(), po.getClass());
//		for (Object o : string) {
//			System.out.println(o.toString());
//		}
//		try {
//			IndexReader indexReader = LuceneUtils.getIndexReader(dir, true);
//			IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher(indexReader);
//			// CustomParser c = new CustomParser("filename", LuceneUtils.analyzer);
//			Query q = UpicMutilsQueryParser.parse((String[]) string.get(1), (String[]) string.get(0),
//					(Occur[]) string.get(2), LuceneUtils.analyzer);
//			// 1、创建一个评分域
//			FieldCacheSource fieldCacheSource = new DoubleFieldSource("score");
//			FunctionQuery fd = new FunctionQuery(fieldCacheSource);
//			// 2、根据评分域和原有的Query创建自定义的Query对象
//			RecencyBoostCustomScoreQuery query = new RecencyBoostCustomScoreQuery(q, fd);
//			List<Document> docList = LuceneUtils.query(indexSearcher, query);
//			for (Document d : docList) {
//				System.out.println("[" + d.get("secondTypeName") + "【" + d.get("biosphere") + "】--->]");
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static String getPo(){
//		CenterSearch<SearchPo> c=new CenterSearch<SearchPo>();
//		c.setPageNumStr("1");
//		c.setNumPerPageStr("5");
//		c.setReturnType("shop");
//		c.setMethod(1);
//		c.setSearchClass("SearchPo");
//		c.setSearchClass(SearchPo.class.getSimpleName());
//		c.setKeyWord("跑步");
//		SearchPo s=new SearchPo();
////		s.setThemeName("吃");
////		s.setShopTheme("红烧肉");
//		s.setCity("宁波");
////		s.setProjectShop("aa");
//		c.setT(s);
//		return JSONObject.fromObject(c).toString();
//	}
//	public static void main(String[] args) throws ParseException {
//		// index();
//		// TestWork.test01("hello");
//		// test01("*");
//		// MutilSearch("hello", "text");
//		System.out.println(getPo());
////		test();
//	}
//
//	/**
//	 * 模拟数据
//	 */
//	public static void simulation(Directory dir) {
//		String secondTypeName[] = { "亲子活动", "约炮", "打飞机", "香香", "cs真人", "打飞机", "亲子活动" };
//		String biosphere[] = { "鄞州区", "海曙区", "江干区", "慈溪", "北仑区", "杭州湾", "余姚" };
//		
//		IndexWriter indexWrtier = LuceneUtils.getIndexWrtier(dir, new IndexWriterConfig(LuceneUtils.analyzer));
//		Document doc = null;
//		try {
//			for (int i = 0; i < secondTypeName.length; i++) {
//				doc = new Document();
//				// doc.add(new StoredField("filename",, TextField.TYPE_STORED));
//				// doc.add(new SortedDocValuesField("filename", new
//				// BytesRef(f.getName())));
//				doc.add(new SortedDocValuesField("secondTypeName", new
//						 BytesRef(secondTypeName[i])));
//				doc.add(new StoredField("secondTypeName", secondTypeName[i],TextField.TYPE_STORED));
//				doc.add(new StoredField("biosphere", biosphere[i],TextField.TYPE_STORED));
//				doc.add(new SortedDocValuesField("biosphere", new
//						 BytesRef(biosphere[i])));
//				indexWrtier.addDocument(doc);
//			}
//			indexWrtier.forceMerge(1);
//			indexWrtier.commit();
//			indexWrtier.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
