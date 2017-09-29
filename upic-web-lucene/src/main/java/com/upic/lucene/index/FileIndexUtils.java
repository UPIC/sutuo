package com.upic.lucene.index;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;

import com.upic.lucene.utils.MySameAnalyzer;
import com.upic.lucene.utils.SimpleSamewordContext;

public class FileIndexUtils {
	private static Directory directory = null;
	static {
		try {
			directory = FSDirectory.open(Paths.get("d:\\test\\lucene_index"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Directory getDirectory() {
		return directory;
	}

	public static void index(boolean hasNew) {
		IndexWriter writer = null;
		try {
			writer = new IndexWriter(directory,
					new IndexWriterConfig(new MySameAnalyzer(new SimpleSamewordContext(), "data/")));
			if (hasNew) {
				writer.deleteAll();
			}
			File file = new File("f:\\java\\Java tools");
			Document doc = null;
			for (File f : file.listFiles()) {
				doc = new Document();
				doc.add(new StringField("filename", f.getName(), Field.Store.YES));
				doc.add(new StringField("path", f.getAbsolutePath(), Field.Store.YES));
				doc.add(new LongPoint("date", f.lastModified()));
				doc.add(new IntPoint("size", ((int) (f.length() / 1024))));
				writer.addDocument(doc);
			}
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Directory RAMDirectory() {
		Directory dir = new RAMDirectory();
		/*
		 * public IndexWriterConfig(Analyzer analyzer) analyzer：分词器对象
		 */
		IndexWriterConfig writerConfig = new IndexWriterConfig(
				new MySameAnalyzer(new SimpleSamewordContext(), "data/"));
		/*
		 * 创建索引写入对象，该对象既可以把索引写入到磁盘中也可以写入到内存中。 参数说明： public IndexWriter(Directory
		 * directory, IndexWriterConfig conf) directory:目录对象,也可以是FSDirectory
		 * 磁盘目录对象 conf:写入对象的控制
		 */

		try {
			IndexWriter writer = new IndexWriter(dir, writerConfig);
			Document doc = null;
			File file = new File("f:\\java\\JavaWrite");
			for (File f : file.listFiles()) {
				doc = new Document();
				doc.add(new StoredField("filename", f.getName(), TextField.TYPE_STORED));
				doc.add(new SortedDocValuesField("filename", new BytesRef(f.getName())));
				doc.add(new Field("path", f.getAbsolutePath(), TextField.TYPE_STORED));
				doc.add(new StoredField("date", f.lastModified()));
				doc.add(new StoredField("size", ((int) (f.length() / 1024))));
				writer.addDocument(doc);
			}
			writer.forceMerge(1);
			writer.commit();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dir;
	}

	public static void main(String[] args) {
		FileIndexUtils.index(true);
	}

}
