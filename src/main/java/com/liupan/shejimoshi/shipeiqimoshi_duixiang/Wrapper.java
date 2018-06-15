package com.liupan.shejimoshi.shipeiqimoshi_duixiang;

import com.liupan.shejimoshi.shipeiqimoshi_lei.Source;
import com.liupan.shejimoshi.shipeiqimoshi_lei.Targetable;

public class Wrapper implements Targetable {

	private Source source;
	
	public Wrapper(Source source){
		super();
		this.source = source;
	}
	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

	@Override
	public void method1() {
		source.method1();
	}
}