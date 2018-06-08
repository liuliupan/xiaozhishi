package com.liupan.duoxiancheng;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFuture {
	
    public static void main(String[] args) {
    	
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
            	Thread.sleep(3000);// 可能做一些事情
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
        	Integer integer = future.get();
        	System.out.println(integer);
        	System.out.println("主线程开始了");
//            Thread.sleep(2000);// 可能做一些事情
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}