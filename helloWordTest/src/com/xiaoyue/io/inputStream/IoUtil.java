package com.xiaoyue.io.inputStream;

import java.awt.color.ICC_Profile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

public class IoUtil {
	public static void reader(String path) {
		File file =new File(path);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		int i=0;
		try {
			 inputStream = new FileInputStream(file);
			  outputStream = new FileOutputStream("D:\\test1.txt");
			byte[] by=new byte[1024];
			while((i=inputStream.read(by))!=-1) {
				outputStream.write(by);
				int available = inputStream.available();
				
				System.out.println(available);
			}
		} catch (Exception e) {
			System.out.println("没有找到资源");
			e.printStackTrace();
		}finally {
			if(inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(outputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void read(String path) {
		
		File file =new File(path);
//		OutputStream outputStream=null;
		boolean exists = file.exists();
		System.out.println(exists);
		if(!exists) {
			boolean mkdirs = file.mkdirs();
			System.out.println(mkdirs);
		}
		try {
		File createTempFile = File.createTempFile("TestIo",".txt",file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
//		InputStream inputStream = null;
//		OutputStream outputStream = null;
//		String name="asdasdasd";
//		 try {
//			 inputStream = new FileInputStream(file);
//			 byte[] by=new byte[1024];
//			 int read = inputStream.read(by);
//			 String string =new String(by,0,read,"utf-8");
//			 System.out.println(string);
//			outputStream = new FileOutputStream(file);
//			outputStream.write(name.getBytes("utf-8"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			
//			if(outputStream!=null) {
//				try {
//					outputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if(inputStream!=null) {
//				try {
//					inputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
	public static void main(String[] args) {
		read("c:/Test");
	}
}
