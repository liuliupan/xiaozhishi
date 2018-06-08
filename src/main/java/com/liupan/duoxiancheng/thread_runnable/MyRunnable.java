package com.liupan.duoxiancheng.thread_runnable;

public class MyRunnable {
	public static void main(String[] args) {
		MmmRunnable target=new MmmRunnable();
		Thread thread1=new Thread(target,"窗口1");
		Thread thread2=new Thread(target,"窗口2");
		Thread thread3=new Thread(target,"窗口3");
		thread1.start();
		thread2.start();
		thread3.start();
		
	}



	
}
















class MmmRunnable implements Runnable{

	
	
	public static int num=100;
	@Override
	public void run() {
		while(num>0){
			System.out.println("第"+Thread.currentThread().getName()+"窗口卖了第"+num+"张票");
			num--;
		}
	}
}