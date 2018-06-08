package com.liupan.spring.datasource;

import java.util.concurrent.SynchronousQueue;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
@Configuration
@ComponentScan("com.liupan")
public class DataSourceTest {
	
	@Bean
	public DataSource dataSource() {
	    BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://localhost:3306/g_10001_ods?useUnicode=true&characterEncoding=UTF-8");
	    ds.setUsername("root");
	    ds.setPassword("root");
	    return ds;
	}
	public static void main(String[] args) {
		
		
	}
	
}
