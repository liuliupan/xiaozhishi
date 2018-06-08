package com.liupan.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysTest {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("444");
		
		Map<String,String> map=new HashMap<>();
		map.put("333", "333");
				
		List<Object> asList = Arrays.asList("222",map,list);
		
		long[] a ={1,2,3};
		String string = Arrays.toString(a);
		System.out.println(asList);
		System.out.println(string);
		
		
	}
}
