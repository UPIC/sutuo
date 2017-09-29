package com.upic.lucene.utils;

import java.io.IOException;

import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.queries.CustomScoreProvider;
import org.apache.lucene.queries.CustomScoreQuery;
import org.apache.lucene.queries.function.FunctionQuery;
import org.apache.lucene.search.Query;

import com.upic.common.entity.CenterSearch;

public class RecencyBoostCustomScoreQuery extends CustomScoreQuery {  
	
	private CenterSearch centerSearch;
	private String[] searchColum;
    public RecencyBoostCustomScoreQuery(Query subQuery, FunctionQuery fd,CenterSearch centerSearch,String[] searchColum) {  
        super(subQuery,fd);  
        this.centerSearch=centerSearch;
        this.searchColum=searchColum;
    }
    
    @Override  
    protected CustomScoreProvider getCustomScoreProvider(  
            LeafReaderContext context) throws IOException {  
        return new DateScoreProvider(context,centerSearch,searchColum);  
    }  
} 
