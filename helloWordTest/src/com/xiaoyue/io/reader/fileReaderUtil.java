package com.xiaoyue.io.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class fileReaderUtil {

	public static void main(String[] args) throws IOException {
//		fileReader1();
//		fileWrite1();
//		fileWriteAndFileReader();
//		bufferedReaderFile();
//		bufferedWriterFile();
//		bufferedRAndBufferedWFile();
//		sortBufferedFile();
		lineNumberReaderTest();
	}

	/**在文件每一行输出编号
	 * 底层实现，定义了一个成员变量LineNumber，默认为0
	 * getLineNumber()//获取当前编号。默认从0开始，每readLine()读取一次，LineNumber加1.
	 * setLineNumber(int start)//也可以设置行号从几开始
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void lineNumberReaderTest() throws FileNotFoundException, IOException {
		LineNumberReader inr=new LineNumberReader(new FileReader("test3.txt"));
		BufferedWriter bfWriter=new BufferedWriter(new FileWriter("numberTest3.txt"));
		String line;
		while((line = inr.readLine()) !=null) {
			bfWriter.write(inr.getLineNumber()+":"+line);
			bfWriter.newLine();
		}
		inr.close();
		bfWriter.close();
	}

	/**倒序文件内容：读取文件内容并倒序输出到新文件中去，
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void sortBufferedFile() throws FileNotFoundException, IOException {
		BufferedReader bfReader=new BufferedReader(new FileReader("test3.txt"));//创建缓冲输入字符流对象。包装文件输入字符流关联抽象文件路径
		ArrayList<String> list=new ArrayList<String>();
		String line;//创建字符串对象保存读到的每一行数据。
		while((line = bfReader.readLine()) !=null) {//将数据保存到line中
			list.add(line);
		}
		bfReader.close();//数据已经保存到ArrayList集合中，可关闭输入流，早关晚写原则
		
		BufferedWriter bfWriter=new BufferedWriter(new FileWriter("copytest3.txt"));//创建缓冲输出字符流对象。包装文件输出字符流关联抽象文件路径
		for(int i=list.size()-1;i>=0;i--) {//遍历list集合，从后面往前遍历
			bfWriter.write(list.get(i));//通过索引取出每一个元素，在用字符缓冲输出流写到文件中去
			bfWriter.newLine();//没获取一行，就输出一个换行符。相当于\r\n。
		}
		bfWriter.close();//关闭流。
	}

	
	/**使用缓冲字符流读取文件，再用缓冲字符流写出到文件中
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void bufferedRAndBufferedWFile() throws FileNotFoundException, IOException {
		BufferedReader bfReader=new BufferedReader(new FileReader("test3.txt"));//创建缓冲输入字符流对象。包装文件输入字符流关联抽象文件路径
		BufferedWriter bfWriter=new BufferedWriter(new FileWriter("copytest3.txt"));//创建缓冲输出字符流对象。包装文件输出字符流关联抽象文件路径
		String line;//创建字符串对象保存读到的每一行数据。
		while((line = bfReader.readLine()) !=null) {//将数据保存到line中
			bfWriter.write(line);//将每行数据写到文件中去。
			bfWriter.newLine();//一行写完，创建一个换行符写到文件中
		}
		bfReader.close();//关闭流
		bfWriter.close();
	}

	public static void bufferedWriterFile() throws IOException {
		BufferedWriter bfWriter=new BufferedWriter(new FileWriter("yyy.txt"));
		bfWriter.write("橱西奈一");//可以直接写字符串。
		bfWriter.close();
	}

	/**缓冲区读文件
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void bufferedReaderFile() throws FileNotFoundException, IOException {
		BufferedReader bfReader=new BufferedReader(new FileReader("test3.txt"));
		String line;
		while((line = bfReader.readLine()) != null) {//一行一行读，
			System.out.println(line);
		}
		bfReader.close();
	}
	
	/**小数组方式
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void fileWriteAndFileReader() throws FileNotFoundException, IOException {
		FileReader fReader=new FileReader("test3.txt");
		FileWriter fwWriter=new FileWriter("ccc.txt");
		char[] ch=new char[1024];
		int b;
		while((b = fReader.read(ch)) != -1) {
			fwWriter.write(ch,0,b);
		}
		fReader.close();
		fwWriter.close();
	}
	
	/**读取文件内容
	 * @throws IOException
	 */
	public static void fileWrite1() throws IOException {
		FileWriter fWriter=new FileWriter("zzz.txt");
		fWriter.write("字符流写出字符串数据。");
		fWriter.close();
	}
	
	/**向文件写内容
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void fileReader1() throws FileNotFoundException, IOException {
		FileReader fReader=new FileReader("test3.txt");
		int b;
		while((b = fReader.read()) != -1) {
			System.out.print((char)b);
		}
		fReader.close();
	}

}
