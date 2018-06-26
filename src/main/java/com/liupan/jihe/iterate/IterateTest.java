package com.liupan.jihe.iterate;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IterateTest {
	public static void main(String[] args) {
		List list = new ArrayList();
		//集合
		list.add(1);
		list.add(2);
		list.add(3);
		//Iterator迭代器            //1、获取迭代器
		ListIterator iter = list.listIterator();
		//2、通过循环迭代            //hasNext():判断是否存在下一个元素
		while(iter.hasNext()){
			//如果存在，则调用next实现迭代                //Object-->Integer-->int
			int j=(int)iter.next();  //把Object型强转成int型
			System.out.println(j);
//					iter.remove();
			iter.add("54");
//					list.add("4ou");
		}
//				iter.remove();
		System.out.println(iter.toString());
		System.out.println(list.toString());
	}
}



