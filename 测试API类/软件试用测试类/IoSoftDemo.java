package com.xiaoyue.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 小岳 
 * 		需求：.使用Io流模拟试用版软件原理
  * 分析：1.将试用次数写到文件当中，如10次 
 * 		2.1使用字节流会使用码表将字节转换
 *      2.字符缓冲输入流BufferderReader输入流读取文件类容，使用readerline()读取一行
 *      3.然后将读取到的字符转换诚int值，保存在临时变量b,在关闭输入流 4.在进行判断次数是否大于0.
 *      5.如果大于0，在控制台输出次数并次数减1，在使用输出流Filewrite将次数输出到文件中。 6.如果小于0，就提示你的试用次数剩几次。
 */

public class IoSoftDemo {

	public static void main(String[] args) throws IOException {
		sofuIo();
	}

	private static void sofuIo() throws FileNotFoundException, IOException {
		//1.字符缓冲输入流BufferderReader输入流读取文件类容。
		BufferedReader bfr = new BufferedReader(new FileReader("config.txt"));
		String b =null;						//保存读取一行内容。
		int count = 0 ;						//保存试用次数
		if(( b = bfr.readLine())!= null) {	//使用readerline()读取一行
			count = Integer.parseInt(b);//将读到的字符转成数字
			bfr.close();					//关闭输入流
			//判断试用次数是否大于0.
			if (count > 0) {				//如果大于0，
				System.out.println("您的试用次数仅剩"+(count--)+"次");	//输出到控制台，并次数减1
				FileWriter fw=new FileWriter("config.txt");				//使用输出流绑定抽象文件路径
				fw.write(count+"");			//将次数写到文件中。
				fw.close();					//关闭输出流。
			}else {
				System.out.println("抱歉，您的试用次数已用尽，请购买正版软件。");//次数小于0提示。
			}
		}else {//如果文件被用户删除，则每次启动软件创建文件，写入试用次数10次。
			System.out.println("软件加载失败，请重新启动。");
			FileWriter fw=new FileWriter("config.txt");		//创建配置文件。
			fw.write(10+"");		//默认设置试用次数10次
			fw.close();		//关闭输出流。
		}
	}

}
