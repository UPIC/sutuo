package com.upic.lucene.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.FieldInfos;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.SortedDocValues;
import org.apache.lucene.index.Terms;
import org.apache.lucene.queries.CustomScoreProvider;
import org.apache.lucene.util.BytesRef;

import com.upic.common.core.enums.SearchTypeEnum;
import com.upic.common.entity.CenterSearch;
import com.upic.lucene.emuns.SearchSimilarityEnum;

public class DateScoreProvider extends CustomScoreProvider {

	private List<SortedDocValues> values;
	// 查询字段
	private String[] searchColum;
	private CenterSearch centerSearch;

	private List<String> storeNumbers = new ArrayList<String>();

	public DateScoreProvider(LeafReaderContext context, CenterSearch centerSearch, String[] searchColum) {
		super(context);
		try {
			this.searchColum = searchColum;
			this.centerSearch = centerSearch;
			values = getList(context, searchColum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<SortedDocValues> getList(LeafReaderContext context, String[] searchColum) throws IOException {
		List<SortedDocValues> list = new ArrayList<SortedDocValues>();
		for (String s : searchColum) {
			SortedDocValues sortDoc = context.reader().getSortedDocValues(s);
			if (sortDoc == null) {
				continue;
			}
			list.add(sortDoc);
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	public float customScore(int doc, float subQueryScore, float valSrcScore) throws IOException {
		if (values == null) {
			return subQueryScore * valSrcScore;
		}
		if (centerSearch == null) {
			return subQueryScore * valSrcScore;
		}
		// 控制相似度，如果地域这个数值，直接OUT
		if (subQueryScore < SearchSimilarityEnum.LIMITSCORE.getDesc()) {
			return -1;
		}
		if (centerSearch.getReturnType().equals(SearchTypeEnum.FARME.getDesc())) {
			IndexReader r = context.reader();
			Document document = r.document(doc);
			// Terms tv = r.getTermVector(doc, "storeNumber");
			if (document != null) {
				String storeNumber = document.get("storeNumber");
				if (storeNumbers.contains(storeNumber)) {
					return -1f;
				}
				storeNumbers.add(storeNumber);
			}
		}
		switch (centerSearch.getMethod()) {
		// 智能排序
		case 1:

			break;
		// 距离最近
		case 2:

			break;
		// 最新上线
		case 3:

			break;
		// 人气
		case 4:

			break;
		// 价格最低
		case 5:

			break;
		// 价格最高
		case 6:

			break;
		default:
			break;
		}
		// String filename = values.get(doc).utf8ToString();
		// // String filename="";
		// if (filename.endsWith(".java")) {
		// return subQueryScore * 1.5f;
		// }
		return subQueryScore / 1.5f;
	}
}