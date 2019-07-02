package com.xiaoyue.io.SequenceInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 小岳
 *将两个文件中的内容写到一个文件中去
 *1.先将两个文件使用文件输入流FileInputStream关联文件抽象路径。SequenceInputStream(InputStream in,InputStream in)
 *2.在使用序列流包装2个InputStream对象。弊端：只能将2个文件的内容写到一个文件。不能同时操作多个文件。
 */
public class SequenceInputStreamTest {

	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		singletonSequenceInPutStream();
		enumerationSequenceInputStream();
		
		
	}

	/**将两个文件中的内容写到一个文件中去
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void singletonSequenceInPutStream() throws FileNotFoundException, IOException {
		SequenceInputStream sis = new SequenceInputStream(new FileInputStream("ccc.txt"), new FileInputStream("zzz.txt"));
		FileOutputStream fos = new FileOutputStream("ggg.txt");
		int b;
		while((b = sis.read())!=-1) {
			fos.write(b);
		}
		fos.close();
	}
	
	
	/**
	 * 将多个文件中的内容写到一个文件中去，
	 * 1.使用序列流SequenceInputStream(Enumeration<? extends InputStream> e)
	 * 2.Enumeration可以使用vector集合将输入流InputStream添加到集合中，使用elements() 返回Enumeration对象
	 * 3.创建输出流ouputStream流对象关联输出目标文件抽象路径。
	 * 使用序列流：底层通过遍历Enumeration分别读取每个文件中的内容。
	 * 5.然后在使用输出流写入到文件中去。
	 * @throws IOException 
	 * 
	 */
	public static void enumerationSequenceInputStream() throws IOException {
		//关联文件抽象路径
		InputStream in1 = new FileInputStream("ccc.txt");
		InputStream in2 = new FileInputStream("zzz.txt");
		InputStream in3 = new FileInputStream("ttt.txt");
		//创建Vector集合
		Vector<InputStream> vector=new Vector<InputStream>();
		vector.addElement(in1);
		vector.addElement(in2);
		vector.addElement(in3);
		Enumeration<InputStream> elements = vector.elements();
		SequenceInputStream sis = new SequenceInputStream(elements);
		OutputStream out = new FileOutputStream("mmm.txt");
		int b;
		while((b = sis.read())!= -1) {
			out.write(b);
		}
		out.close();
		
	}

}
