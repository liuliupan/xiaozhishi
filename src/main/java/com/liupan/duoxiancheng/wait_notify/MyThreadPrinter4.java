package com.liupan.duoxiancheng.wait_notify;
public class MyThreadPrinter4 implements Runnable {   
	  
    private String name;   
    private Object prev;   
    private Object self;   
  
    private MyThreadPrinter4(String name, Object prev, Object self) {   
        this.name = name;   
        this.prev = prev;   
        this.self = self;   
    }   
  
    @Override  
    public void run() {   
//            synchronized (prev) {   
//                synchronized (self) {   
//                    System.out.print(name);   
//                    self.notify();//本来a进入同步块就已经被锁了，这里是释放了
//                }   
//                try {   
//                    prev.wait();   //c本来就被锁了，这里是在锁一次，其实已经没意义了，因为已经被锁了。
//                } catch (InterruptedException e) {   
//                    e.printStackTrace();   
//                }   
//		  //一进来，就是prev c同步块，a同步块，a被打印了，a被释放掉了，c要锁上了
//		  //接着a要进来，结果c被锁了，a只能在第一个同步块外等待，那么c进来了呢？c自身也被锁在第二个同步代码块之外，
//            //那么就只有b线程能执行了，那么a就被锁了,现在就只能运行c线程，c运行，那么c就被释放了，
//            //b就锁了，就是这种环环相扣的，一个释放了一个就被锁住了 。就是这样的。
//            }  
            synchronized (prev) {   
            	System.out.println(prev+"------1没有被锁了");
            }
            synchronized (prev) {   
            	System.out.println(prev+"------2没有被锁了-----------");
            	try {
					Thread.currentThread().sleep(1000);;
					 synchronized (prev) { 
						 System.out.println("释放了吗----------");
//						 prev.wait();
					 }
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            synchronized (prev) {   
            	System.out.println(prev+"------2没有被锁了");
            	try {
					prev.wait(3000);
					 synchronized (prev) { 
						 System.out.println("释放了吗");
//						 prev.wait();
					 }
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            synchronized (prev) {   
            	System.out.println(prev+"------wait释放了锁");
            }
           
            
    }
    public static void main(String[] args) throws Exception {   
        Object a = new Object();   
        Object b = new Object();   
        Object c = new Object();   
        MyThreadPrinter4 pa = new MyThreadPrinter4("A", c, a);   
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

