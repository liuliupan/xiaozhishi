package com.liupan.shuzu;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Person person_01 = new Person("chenssy_01");
        
        Person[] persons1 = new Person[]{person_01};
        Person[] persons2 = Arrays.copyOf(persons1,persons1.length);
        
        System.out.println("数组persons1:");
        display(persons1);
        System.out.println("---------------------");
        System.out.println("数组persons2:");
        display(persons2);
        //改变其值
        persons2[0].setName("chessy_02");
        System.out.println("------------改变其值后------------");
        System.out.println("数组persons1:");
        display(persons1);
        System.out.println("---------------------");
        System.out.println("数组persons2:");
        display(persons2);
    }
    public static void display(Person[] persons){
        for(Person person : persons){
            System.out.println(person.toString());
        }
    }
}
//-------------Output:
//数组persons1:
//姓名是：chenssy_01
//---------------------
//数组persons2:
//姓名是：chenssy_01
//------------改变其值后------------
//数组persons1:
//姓名是：chessy_02
//---------------------
//数组persons2:
//姓名是：chessy_02