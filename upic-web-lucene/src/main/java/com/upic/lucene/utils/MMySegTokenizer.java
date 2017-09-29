package com.upic.lucene.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.Word;

public class MMySegTokenizer extends Tokenizer {

	private MMSeg mmSeg;

	private CharTermAttribute termAtt;
	private OffsetAttribute offsetAtt;
	private TypeAttribute typeAtt;

	private Seg seg;
	private Reader inputs;
	
	public Seg getSeg() {
		return seg;
	}

	public void setSeg(Seg seg) {
		this.seg = seg;
	}

	public Reader getInputs() {
		return inputs;
	}

	public void setInputs(Reader inputs) {
		mmSeg = new MMSeg(inputs, getSeg());
		this.inputs = inputs;
		super.input=inputs;
	}

	public MMySegTokenizer(Seg seg) {
		this.seg=seg;
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
	}

	public void reset() throws IOException {
		mmSeg.reset(input);
	}

	@Override
	public final boolean incrementToken() throws IOException {
		clearAttributes();
		Word word = mmSeg.next();
		if(word != null) {
			//lucene 3.0
			//termAtt.setTermBuffer(word.getSen(), word.getWordOffset(), word.getLength());
			//lucene 3.1
			termAtt.copyBuffer(word.getSen(), word.getWordOffset(), word.getLength());
			offsetAtt.setOffset(word.getStartOffset(), word.getEndOffset());
			typeAtt.setType(word.getType());
			return true;
		} else {
			end();
			return false;
		}
	}
}