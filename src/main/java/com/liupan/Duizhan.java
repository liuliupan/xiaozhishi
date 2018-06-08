package com.liupan;

import java.util.HashMap;

public class Duizhan {
	public static void main(String[] args) {
		
		HashMap a=null;
		HashMap b=new HashMap<>();
		System.out.println(a);
//		System.out.println(a.toString());
		System.out.println(b);
		System.out.println(b.toString());
		a=b;
		System.out.println(a);
		System.out.println(a.toString());
	
	}
}
