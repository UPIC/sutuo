package com.upic.lucene.service;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

public interface ILuceneService {

	public void addField(Document doc);
	public void deleteFiled(String id,String content);
	public void updateField(Document doc, String fieldName,String fieldValue);
}
