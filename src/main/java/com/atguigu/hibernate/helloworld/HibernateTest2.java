package com.atguigu.hibernate.helloworld;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest2 {
	@After
	public void destory() {
		System.out.println("destory...");
	}
	@Before
	public void init() {
		System.out.println("init...");
	}
	
	@Test
	public void test() {
		System.out.println("test...");
	}
	
}
