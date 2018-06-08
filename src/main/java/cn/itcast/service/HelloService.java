package cn.itcast.service;
/**
 * HelloService
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-6-7 上午9:55:43
 * @version 1.0
 */
public class HelloService {
	
	private HelloService(){
		System.out.println("=====构造器======");
	}
	
	public void hello(){
		System.out.println("Spring我来了！");
	}
}
