package com.upic.lucene.service;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuceneService implements ILuceneService {
	@Autowired(required = false)
	IndexWriter writer;

	/**
	 * 添加索引
	 */
	@Override
	public void addField(Document doc) {
		try {
			writer.addDocument(doc);
			writer.commit();
		} catch (IOException e) {
			e.printStackTrace();
//		} finally {
//			try {
//				writer.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}

	/**
	 * 删除索引
	 */
	@Override
	public void deleteFiled(String id, String content) {
		try {
			writer.deleteDocuments(new Term(id, content));
			writer.commit();
		} catch (IOException e) {
			e.printStackTrace();
//		} finally {
//			try {
//				writer.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}

	/**
	 * 更新索引
	 */
	@Override
	public void updateField(Document doc, String fieldName, String fieldValue) {
		Term term = new Term(fieldName, fieldValue);
		try {
			writer.updateDocument(term, doc);
			writer.commit();
		} catch (IOException e) {
			e.printStackTrace();
//		} finally {
//			try {
//				writer.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}

}
