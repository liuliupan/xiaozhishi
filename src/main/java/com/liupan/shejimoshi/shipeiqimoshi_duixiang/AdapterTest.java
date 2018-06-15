package com.liupan.shejimoshi.shipeiqimoshi_duixiang;

import com.liupan.shejimoshi.shipeiqimoshi_lei.Source;
import com.liupan.shejimoshi.shipeiqimoshi_lei.Targetable;

public class AdapterTest {

	public static void main(String[] args) {
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}