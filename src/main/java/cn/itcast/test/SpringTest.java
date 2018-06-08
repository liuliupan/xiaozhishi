package cn.itcast.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.service.HelloService;

/**
 * SpringTest
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2016-6-7 上午9:59:25
 * @version 1.0
 */
public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 加载spring-context.xml文件，产生Spring容器. classes
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");
		System.out.println("==========Spring容器初始化完成===========");
		
		//ApplicationContext ac = new ClassPathXmlApplicationContext("file:F:\\workspace\\myeclipse\\Spring_01\\src\\spring-context.xml");
		// 根据id获取Bean
		HelloService hs = (HelloService)ac.getBean("helloService");
		hs.hello();
		
		
	}

}
