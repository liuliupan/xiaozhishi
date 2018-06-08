package com.liupan.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class IOtest {
	public static void main(String[] args) throws Exception { 
		  
		  // 创建一个以当前工程目录下的名为“helloworld.txt”的文本文件 
		  
		  File file = new File("hellowolrd.txt"); 
		  
		  OutputStream outputStream = null; 
		  
		  // 通过FileOutPutStream的子类实例化OutputStream对象 
		  
		  outputStream = new FileOutputStream(file); 
		  
		  // 声明一个字符串 
		  
		  String str = "hello,world"; 
		  
		  // 将字符串转换成字节数组 
		  
		  byte[] b = str.getBytes(); 
		  
		  // 写入数据 
		  
		  outputStream.write(b); 
		  
		  // 关闭输出流 
		  
		  outputStream.close(); 
		  
		  outputStream.flush(); 
		  
		} 

}
