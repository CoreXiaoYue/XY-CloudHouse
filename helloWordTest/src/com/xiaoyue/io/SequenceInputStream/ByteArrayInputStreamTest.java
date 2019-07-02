package com.xiaoyue.io.SequenceInputStream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 小岳
 *使用内存流将文件中的数据读到内存中。使用：ByteArrayInputStream
 *
 */
public class ByteArrayInputStreamTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		ByteArrayOutputStreamRAM();
		randomAccessFile1();
//		randomAccessFile2();
	}

	/**随机读取文件中类容
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void randomAccessFile1() throws FileNotFoundException, IOException {
		RandomAccessFile raf=new RandomAccessFile("ccc.txt", "r");
		FileOutputStream fos = new FileOutputStream("zzz.txt");
		raf.seek(3);
		int b;
		while((b = raf.read()) !=-1) {
			fos.write(b);
		}
		raf.close();
		fos.close();
	}
	
	/**随机读取文件中类容
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void randomAccessFile2() throws FileNotFoundException, IOException {
		RandomAccessFile raf=new RandomAccessFile("ccc.txt", "r");
		FileOutputStream fos = new FileOutputStream("zzz.txt");
		raf.seek(12);
		int b;
		while((b = raf.read()) !=-1) {
			fos.write(b);
		}
		raf.close();
		fos.close();
	}

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void ByteArrayOutputStreamRAM() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("ccc.txt");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int b;
		while((b = fis.read()) != -1) {
			bos.write(b);
		}
		fis.close();
		String str = bos.toString();
		FileWriter fw= new FileWriter("hhh.txt");
		fw.write(str);
		fw.close();
	}

}
