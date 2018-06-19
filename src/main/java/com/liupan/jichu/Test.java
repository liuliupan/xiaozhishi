package com.liupan.jichu;
public class Test {
    Person person = new Person("Test");
    static{
        System.out.println("-8==test static");
    }
     
    public Test() {
        System.out.println("test constructor");
    }
     
    public static void main(String[] args) {
        new MyClass();
    }
}
 
class Person{
    static{
        System.out.println("1==person static");
    }
    public Person(String str) {
        System.out.println("2==person "+str);
    }
}
 
 
class MyClass extends Test {
    Person person = new Person("MyClass");
    static{
        System.out.println("-2==myclass static");
    }
     
    public MyClass() {
        System.out.println("-1==myclass constructor");
    }
}