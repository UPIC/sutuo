//package com.upic.trade.facade.test;
//
//import java.io.IOException;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.document.TextField;
//import org.apache.lucene.index.CorruptIndexException;
//import org.apache.lucene.index.DirectoryReader;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.index.Term;
//import org.apache.lucene.queryparser.classic.ParseException;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.TermQuery;
//import org.apache.lucene.search.TopDocs;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.LockObtainFailedException;
//import org.apache.lucene.store.RAMDirectory;
//
//import com.upic.lucene.utils.AnalyzerUtils;
//import com.upic.lucene.utils.CustomParser;
//import com.upic.lucene.utils.MySameAnalyzer;
//import com.upic.lucene.utils.MyScoreQuery;
//import com.upic.lucene.utils.SimpleSamewordContext;
//
//public class Test {
//
//	public static void main(String[] args) {
////		test02("天朝");
//		MyScoreQuery m =new MyScoreQuery();
////		FileIndexUtils.index(true);
//		Analyzer a2 = new MySameAnalyzer(new SimpleSamewordContext(),"data/");
//		m.searchByScoreQuery("hello", a2 );
//	}
//	public static void test01(){
//		try {
//			Analyzer a2 = new MySameAnalyzer(new SimpleSamewordContext(),"data/");
//			String txt = "我来自中国云南昭通昭阳区昭通师专";
//			Directory dir = new RAMDirectory();
//			IndexWriter writer = new IndexWriter(dir,new IndexWriterConfig( a2));
//			Document doc = new Document();
//			doc.add(new Field("content",txt,TextField.TYPE_STORED));
//			writer.addDocument(doc);
//			writer.close();
//			DirectoryReader  reader=DirectoryReader.open(dir);
//			IndexSearcher searcher = new IndexSearcher(reader);
//			TopDocs tds = searcher.search(new TermQuery(new Term("content","天朝")),10);
//			Document d = searcher.doc(tds.scoreDocs[0].doc);
//			System.out.println(d.get("content"));
////			AnalyzerUtils.displayAllTokenInfo(txt, a2);
//		} catch (CorruptIndexException e) {
//			e.printStackTrace();
//		} catch (LockObtainFailedException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public static void test02(String value){
//		try {
//			Analyzer a2 = new MySameAnalyzer(new SimpleSamewordContext(),"data/");
//			String txt = "我来自中国云南昭通昭阳区昭通师专";
//			Directory dir = new RAMDirectory();
//			IndexWriter writer = new IndexWriter(dir,new IndexWriterConfig( a2));
//			Document doc = new Document();
//			doc.add(new Field("content",txt,TextField.TYPE_STORED));
//			writer.addDocument(doc);
//			writer.close();
//			DirectoryReader  reader=DirectoryReader.open(dir);
//			IndexSearcher searcher = new IndexSearcher(reader);
//			TopDocs tds = null;
//			CustomParser parser = new CustomParser("content", a2);
//			Query queryStr = parser.parse(value);
//			System.out.println(queryStr);
//			tds = searcher.search(queryStr, 50);
//			
//			Document d = searcher.doc(tds.scoreDocs[0].doc);
//			System.out.println(d.get("content"));
//			AnalyzerUtils.displayAllTokenInfo(txt, a2);
//		} catch (CorruptIndexException e) {
//			System.err.println("错误信息："+e.getMessage());
//		} catch (LockObtainFailedException e) {
//			System.out.println("错误信息："+e.getMessage());
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			System.err.println("错误信息："+e.getMessage());
//		}
//	}
//	
//	public static void test03(String value){
//		try {
//			Analyzer a2 = new MySameAnalyzer(new SimpleSamewordContext(),"data/");
//			String txt = "我来自中国云南昭通昭阳区昭通师专";
//			Directory dir = new RAMDirectory();
//			IndexWriter writer = new IndexWriter(dir,new IndexWriterConfig( a2));
//			Document doc = new Document();
//			doc.add(new Field("content",txt,TextField.TYPE_STORED));
//			writer.addDocument(doc);
//			writer.close();
//			DirectoryReader  reader=DirectoryReader.open(dir);
//			IndexSearcher searcher = new IndexSearcher(reader);
//			TopDocs tds = null;
//			CustomParser parser = new CustomParser("content", a2);
//			Query queryStr = parser.parse(value);
//			System.out.println(queryStr);
//			tds = searcher.search(queryStr, 50);
//			
//			Document d = searcher.doc(tds.scoreDocs[0].doc);
//			System.out.println(d.get("content"));
////			AnalyzerUtils.displayAllTokenInfo(txt, a2);
//		} catch (CorruptIndexException e) {
//			System.err.println("错误信息："+e.getMessage());
//		} catch (LockObtainFailedException e) {
//			System.out.println("错误信息："+e.getMessage());
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			System.err.println("错误信息："+e.getMessage());
//		}
//	}
//}
