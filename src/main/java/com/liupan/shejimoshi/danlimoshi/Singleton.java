package com.liupan.shejimoshi.danlimoshi;
public class Singleton {
     private static final Singleton singleton = new Singleton();
     //限制产生多个对象
     private Singleton(){
     }
     //通过该方法获得实例对象
     public static Singleton getSingleton(){
             return singleton;
     }  
     //类中其他方法，尽量是static
     public static void doSomething(){
    	 System.out.println("单例模式开始做事情了。。。");
     }
     
     public static void main(String[] args) {
		Singleton.getSingleton().doSomething();
	}
}