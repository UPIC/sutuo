package com.upic.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class GetPath {

	private static String path;
	public GetPath(String path){
		this.path=path;
	}
	public  Path getPath(){
		return Paths.get(path);
	}
}
