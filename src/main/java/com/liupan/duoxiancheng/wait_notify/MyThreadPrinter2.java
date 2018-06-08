package com.liupan.duoxiancheng.wait_notify;
public class MyThreadPrinter2 implements Runnable {   
	  
    private String name;   
    private Object prev;   
    private Object self;   
  
    private MyThreadPrinter2(String name, Object prev, Object self) {   
        this.name = name;   
        this.prev = prev;   
        this.self = self;   
    }   
  
    @Override  
    public void run() {   
            synchronized (prev) {   
            	System.out.println(prev+"------2没有被锁了");
            	try {
					prev.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            
    }
    public static void main(String[] args) throws Exception {   
        Object a = new Object();   
        Object b = new Object();   
        Object c = new Object();   
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);   
//        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);   
//        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);   
           
           
        new Thread(pa).start();
//        Thread.sleep(100);  //确保按顺序A、B、C执行
//        new Thread(pb).start();
//        Thread.sleep(100);  
//        new Thread(pc).start();   
//        Thread.sleep(100);  
        }   
}  

