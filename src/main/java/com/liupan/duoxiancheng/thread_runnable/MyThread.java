package com.liupan.duoxiancheng.thread_runnable;

public class MyThread {
	public static void main(String[] args) {
		MmmThread thread1=new MmmThread("1111");
		MmmThread thread2=new MmmThread("2222");
		MmmThread thread3=new MmmThread("3333");
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	

}

//用thread来写出买票的代码
class MmmThread extends Thread{
	private String name;
	
	
	public MmmThread(String name) {
		super(name);
		this.name = name;
	}
	public static int num=100;
	@Override
	public void run() {
		while(num>0){
			System.out.println("第"+Thread.currentThread().getName()+"窗口卖了第"+num+"张票");
			num--;
		}
	}
}