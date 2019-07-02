package com.xiaoyue.io.inputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;



public class InputStreamMain implements InputStreamInterface{
//
//	public  void spentTime() {
//		Long startTime=System.currentTimeMillis();
//		Long endTime=System.currentTimeMillis();
//	}

//计算出程序运行所花费胡时间。
	@Override
	public void copeFile2() throws Exception {
		InputStream inputStream=new FileInputStream("bootstrap-master.zip");	//创建输入流，读取文件
		OutputStream outputStream=new FileOutputStream("bootstrap-mastercope.zip");//创建输出流，写到目标文件
		int len;		//定义变量存放读到的字节。
		byte[] by=new byte[1024*2];
		while((len=inputStream.read(by))!=-1) {//连续读输入流中的字节，当读到的字节数等于-1，则停止读取
			outputStream.write(by,0,len);			//连续将读到的字节写到输出流中去。
		}
	
		inputStream.close();
		outputStream.close();
	}
	
	
	  
	//	 此种方法一次只能读取一个字节，效率慢。
	@Override
	public  void copeFile1() throws Exception {
		InputStream inputStream=new FileInputStream("bootstrap-master.zip");	//创建输入流，读取文件
		OutputStream outputStream=new FileOutputStream("bootstrap-mastercope.zip");//创建输出流，写到目标文件
		int b;		//定义变量存放读到的字节。
		byte[] by=new byte[1024];
		while((b=inputStream.read(by))!=-1) {//连续读输入流中的字节，当读到的字节数等于-1，则停止读取
			outputStream.write(by,0,b);			//连续将读到的字节写到输出流中去。
		}
		inputStream.close();
		outputStream.close();
	}
	public  long startTime() {
		Long startTime=System.currentTimeMillis();
		return startTime;
	}
	public long endTime() {
		Long endTime=System.currentTimeMillis();
		return endTime;
	}
	
}
