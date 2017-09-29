//package com.upic.lucene.utils;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.index.CorruptIndexException;
//import org.apache.lucene.index.DirectoryReader;
//import org.apache.lucene.index.IndexReader;
//import org.apache.lucene.queries.function.FunctionQuery;
//import org.apache.lucene.queries.function.valuesource.DoubleFieldSource;
//import org.apache.lucene.queries.function.valuesource.FieldCacheSource;
//import org.apache.lucene.queryparser.classic.ParseException;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.ScoreDoc;
//import org.apache.lucene.search.TopDocs;
//
//import com.upic.lucene.index.FileIndexUtils;
//import com.upic.page.LuceneUtils;
//import com.upic.trade.facade.test.TestWork;
///**
// * 自定义评分
// * @author DTZ
// *
// */
//public class MyScoreQuery {
//	
//	public void searchByScoreQuery(String value,Analyzer a) {
//		try {
////			FileIndexUtils f=new FileIndexUtils();
//			IndexReader  open = DirectoryReader.open(LuceneUtils.openFSDirectory("f:\\test\\lucene_index"));
////			IndexReader  open = DirectoryReader.open(TestWork.f);
//			IndexSearcher searcher = new IndexSearcher(open);
////			Query q = new TermQuery(new Term("filename",value));
////			System.out.println(open.getSumDocFreq("filename"));
////			System.out.println(open.getSumDocFreq("path"));
////			System.out.println(open.getSumDocFreq("date"));
//			CustomParser c=new CustomParser("filename", a);
//			Query q=c.parse(value);
//			//1、创建一个评分域
////			FieldScoreQuery fd = new FieldScoreQuery("score",Type.INT);
//			FieldCacheSource fieldCacheSource = new DoubleFieldSource("score");
//			FunctionQuery fd=new FunctionQuery(fieldCacheSource);
//			//2、根据评分域和原有的Query创建自定义的Query对象
//			RecencyBoostCustomScoreQuery query = new RecencyBoostCustomScoreQuery(q,fd);
//			TopDocs tds = null;
//			tds = searcher.search(query, 100);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			for(ScoreDoc sd:tds.scoreDocs) {
//				Document d = searcher.doc(sd.doc);
//				System.out.println(sd.doc+":("+sd.score+")" +
//						"["+d.get("filename")+"【"+d.get("path")+"】--->"+
//						d.get("size")+"-----"+sdf.format(new Date(Long.valueOf(d.get("date"))))+"]");
//			}
//		} catch (CorruptIndexException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}