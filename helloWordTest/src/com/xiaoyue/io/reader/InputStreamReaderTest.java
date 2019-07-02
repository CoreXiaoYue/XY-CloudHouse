package com.xiaoyue.io.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.TreeMap;

public class InputStreamReaderTest {

	public static void main(String[] args) throws IOException {
//		InputStreamReaderUtf();
//		bufferedReaderInputStreamReaderTest();
		findCharNumberInFileUtils("zzz.txt","ttt.txt");

	}

	/**找出文件中每个字符出现的次数并在另一个文件中输出
	 * @param findFilePath 要查找的文件抽象路径
	 * @param outFilePath 要将查找结果保存到指定文件的抽象路径
	 * @throws FileNotFoundException 文件找不到异常
	 * @throws IOException 文件流异常
	 */
	public static void findCharNumberInFileUtils(String findFilePath,String outFilePath) throws FileNotFoundException, IOException {
		BufferedReader bfr=new BufferedReader(new FileReader(findFilePath));
		TreeMap<Character, Integer> treeMap=new TreeMap<Character, Integer>();
		int ch;
		while((ch = bfr.read()) != -1) {
			char c=(char)ch;
//			if(!treeMap.containsKey(c)) {//可使用三元运算符表示
//				treeMap.put(c, 1);
//			}else {
//				treeMap.put(c, treeMap.get(c)+1);
//			}
			treeMap.put(c, !treeMap.containsKey(c) ? 1 : treeMap.get(c)+1);//三元运算符表示
			
		}
		bfr.close();
		BufferedWriter bfw =new BufferedWriter(new FileWriter(outFilePath));
		Set<Character> keySet = treeMap.keySet();
		for (Character key : keySet) {
		switch (key) {
		case '\r':
			bfw.write("\\r"+"="+treeMap.get(key));
			break;

		case '\n':
			bfw.write("\\n"+"="+treeMap.get(key));
			break;
		case '\t':
			bfw.write("\\t"+"="+treeMap.get(key));
			break;
		default:
			bfw.write(key+"="+treeMap.get(key));
			break;
		}
			bfw.newLine();
		}
		bfw.close();
	}

	/**使用指定的码表读写字符：缓冲流字节流转换成字符流
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void bufferedReaderInputStreamReaderTest()
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		BufferedReader bur = new BufferedReader(new InputStreamReader(new FileInputStream("gbk.txt"), "utf-8"));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("utf-8.txt"), "utf-8"));
		String line;
		while ((line = bur.readLine()) != null) {
			bfw.write(line);
			bfw.newLine();
		}
		bur.close();
		System.out.println("sdafasdf");
		bfw.close();
	}

	/**使用指定的码表读写字符：字节流转换成字符流
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void InputStreamReaderUtf() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("yyy.txt"), "utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("zzz.txt"), "utf-8");
		int b;
		while ((b = isr.read()) != -1) {
			osw.write(b);

		}
		isr.close();
		osw.close();
	}

}
