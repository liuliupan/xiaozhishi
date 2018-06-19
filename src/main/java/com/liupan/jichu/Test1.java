package com.liupan.jichu;
public class Test1 extends Base{
 
    static{
        System.out.println("test static");
    }
     
    public Test1(){
        System.out.println("test constructor");
    }
     
    public static void main(String[] args) {
        new Test1();
    }
}
 
class Base{
     
    static{
        System.out.println("base static");
    }
     
    public Base(){
        System.out.println("base constructor");
    }
}