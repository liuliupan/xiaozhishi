package com.liupan.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class InputTest {
	public static void main(String[] args) throws Exception { 
		  
	    // 创建一个以当前工程目录下的名为“helloworld.txt”的文本文件 
	  
	    // 这个文件在上一个例子里已经创建，并且里面已有数据 
	  
	    File file = new File("hellowolrd.txt"); 
	  
	    // 声明InputStream对象 
	  
	    InputStream inputStream = null; 
	  
	    // 通过FileInputStream子类实例化InputStream对象 
	  
	    inputStream = new FileInputStream(file); 
	  
	    OutputStream fos = null; 
		  
	    // 通过FileInputStream子类实例化InputStream对象 
	  
	    fos = new FileOutputStream(new File("hellowolrd_copy11.txt")); 
	    // 声明一个字节数组用以接收读入的数据 
	  
	    byte[] bytes = new byte[9]; 
	  
	    // 开始读入数据，将数据内容读到此数组中 
	    
//	    inputStream.read(bytes); 
//	    System.out.println(new String(bytes));
	    int len=inputStream.read(bytes);
	    
	    while(len!=-1){ 
	    	fos.write(bytes, 0, len); //从偏移量0开始到len（95）写入字符，可以保证源文件和复制后的文件大小一致。 
	    	fos.flush(); 
	    	len=inputStream.read(bytes); //我读出来的就是996，每个汉字是3个字节
	    }
	    // 关闭输入流 
	  
	    inputStream.close(); 
	  
	    // 在控制台打印 
	  
//	    System.out.println(new String(b)); 
	  
	  } 

}
