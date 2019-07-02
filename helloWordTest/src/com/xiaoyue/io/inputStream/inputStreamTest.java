package com.xiaoyue.io.inputStream;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;

import com.xiaoyue.io.invocationHandler.MyInvocationHandler;

public class inputStreamTest {
	public static void main(String[] args) throws Exception{
//		copeFile1();
//		copeFile2();
//		spentTime();
		poxyUtil();
//		InputStreamInterface inputStreamMain=new InputStreamMain();
//		inputStreamMain.copeFile1();
//		inputStreamMain.copeFile2();
//		File infile = new File("test3.txt");
//		File outfile = new File("copetest3.txt");
//		CopyFileUtils writeFileUtils=new CopyFileUtils();
//		try {
//			writeFileUtils.writeFile(infile, outfile);
//		} catch (IOException e) {
//			System.out.println("文件读写失败");
//			e.printStackTrace();
//		}finally{
//			writeFileUtils.closeIo();
//		}

	}
		//只用输入输出流cope文件
		//通过动态代理技术算出程序运行的时间
	public static void poxyUtil() throws Exception {
		InputStreamInterface inputStreamMain=new InputStreamMain();//目标对象
		MyInvocationHandler m=new MyInvocationHandler(inputStreamMain);//InvocationHandler对象
		InputStreamInterface inputStreamInterface=(InputStreamInterface) Proxy.newProxyInstance(m.getClassLoader(),m.getInterface(), m);//代理对象
		inputStreamInterface.copeFile1();
	
		
	}
	
	
}