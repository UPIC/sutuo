package com.upic.controller.emun;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		List list = WordsEnum.toList();
		for(int i =0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
