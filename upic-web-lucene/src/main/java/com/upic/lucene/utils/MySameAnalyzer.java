package com.upic.lucene.utils;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;

import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MaxWordSeg;
import com.chenlb.mmseg4j.Seg;

public class MySameAnalyzer extends Analyzer {
	private SamewordContext samewordContext;
	private Dictionary dic;

	public MySameAnalyzer(SamewordContext swc, String path) {
		samewordContext = swc;
		dic = Dictionary.getInstance(path);
	}
	protected Seg newSeg() {
		return new MaxWordSeg(dic);
	}
	@Override
	protected TokenStreamComponents createComponents(String fieldName) {
		final MMySegTokenizer src=new MMySegTokenizer(newSeg());
		TokenStream tok = new MySameTokenFilter(src,samewordContext);
		return new TokenStreamComponents(src, tok) {
		      @Override
		      protected void setReader(final Reader reader) {
		        super.setReader(reader);
		        src.setInputs(reader);
		      }
		    };
	}

	@Override
	protected TokenStream normalize(String fieldName, TokenStream in) {
		return new MySameTokenFilter(
				new MMySegTokenizer(new MaxWordSeg(dic)),samewordContext);
	}

}
