package com.liupan.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jichu {
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		String a="米好，世界";
		 List<Map<String,String>> asList2 = Arrays.asList(map);
		List<Object> asList = Arrays.asList(map,a);
		System.out.println(map);
		System.out.println(asList);
		System.out.println(asList2);
	}
}
