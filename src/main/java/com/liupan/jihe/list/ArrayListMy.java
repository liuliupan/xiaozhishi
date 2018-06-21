package com.liupan.jihe.list;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArrayListMy {
	public static void main(String[] args) {
		List list=new ArrayList<>();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		System.out.println(list);
		list.set(1, "222222");
		System.out.println(list);
		list.add(2, "22222222222");
		System.out.println(list);
		
		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID.toString());
	}
}
