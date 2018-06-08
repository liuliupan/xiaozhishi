package com.liupan.duoxiancheng.wait_notify;
public class MyThreadPrinter3 implements Runnable {   
	  
    private String name;   
    private Object prev;   
    private Object self;   
  
    private MyThreadPrinter3(String name, Object prev, Object self) {   
        this.name = name;   
        this.prev = prev;   
        this.self = self;   
    }   
  
    @Override  
    public void run() {   //1.a进来了    2，b进来了，3c进来了
        int count = 10;   
        while (count > 0) {   
            synchronized (prev) {  //c被锁了，   2.a锁了 ，3.b锁了
                synchronized (self) {  //a被锁了，   2，b锁了，c被锁
                    System.out.print(name);   //打印a,2.打印b
                    count--;  
                    
                    self.notify();//休眠池，里面所有的被a锁的东西都被唤醒，a锁被释放了，2，b释放，，c释放
                }   //a已经释放，
                try {   
                    prev.wait();   //c在这里执行不下去了，被wait了，c wait，a线程处于等待，2.b线程等待,a wait.，bwait
                } catch (InterruptedException e) {   
                    e.printStackTrace();   
                }   
            }   
  //一进来，就是prev c同步块，a同步块，a被打印了，a被释放掉了，c要锁上了
  //接着a要进来，结果c被锁了，a只能在第一个同步块外等待，那么c进来了呢？c自身也被锁在第二个同步代码块之外，
            //那么就只有b线程能执行了，那么a就被锁了,现在就只能运行c线程，c运行，那么c就被释放了，
            //b就锁了，就是这种环环相扣的，一个释放了一个就被锁住了 。就是这样的。
        }   
    }   
  
    public static void main(String[] args) throws Exception {   
        Object a = new Object();   
        Object b = new Object();   
        Object c = new Object();   
        MyThreadPrinter3 pa = new MyThreadPrinter3("A", c, a);   
        MyThreadPrinter3 pb = new MyThreadPrinter3("B", a, b);   
        MyThreadPrinter3 pc = new MyThreadPrinter3("C", b, c);   
           
           
        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);  
        new Thread(pc).start();   
        Thread.sleep(100);  
        }   
}  

