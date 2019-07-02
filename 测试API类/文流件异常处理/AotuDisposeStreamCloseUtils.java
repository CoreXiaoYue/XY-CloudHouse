package com.xiaoyue.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AotuDisposeStreamCloseUtils {


	
	/**jdk1.7标准流关闭
	 * @param intpath 输入流抽象路径
	 * @param outpath 输出流抽象路径
	 * @throws IOException
	 */
	public static void autoTryStream(String intpath,String outpath) throws IOException {
		try (FileInputStream inputStream=new FileInputStream(intpath);//输入流关联抽象路径
			FileOutputStream outputStream=new FileOutputStream(outpath);)//输出流关联抽象路劲
		{
			byte[] by=new byte[3];//创建字节数组存放字节
			int b;//用于记录单次读到的字节数
			while((b=inputStream.read(by))!=-1) {//如果本次读到的字节数不等于-1，那么继续读
					outputStream.write(by,0,b);//将本次读到字节数组里的字节写到输出流中
			}
		}
	}

	/**流异常异常处理
	 * @param intpath 输入流抽象路径
	 * @param outpath 输出流抽象路径
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void disposeTryStream(String intpath,String outpath) throws FileNotFoundException, IOException {
		FileInputStream inputStream=null;//输入流对象
		FileOutputStream outputStream=null;//输出流对象
		try {
			inputStream=new FileInputStream(intpath);//输入流关联抽象路径
			outputStream=new FileOutputStream(outpath);//输出流关联抽象路劲
			byte[] by=new byte[3];//创建字节数组存放字节
			int b;//用于记录单次读到的字节数
			while((b=inputStream.read(by))!=-1) {//如果本次读到的字节数不等于-1，那么继续读
					outputStream.write(by);//将本次读到字节数组里的字节写到输出流中
			}
		}finally {
			try {
				if(inputStream!=null) {//如果输入流不为空关闭输入流
					inputStream.close();
				}
			} finally {
				if(outputStream!=null) {//如果输出流不等于空，关闭输出流
					outputStream.close();				}
			}
			
		}
	}

}
