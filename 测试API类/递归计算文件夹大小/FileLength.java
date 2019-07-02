package com.xiaoyue.io.demo;

import java.io.File;
import java.util.Scanner;

/**
 * @author 小岳
 *需求：在控制台录入文件夹抽象路径，计算文件夹大小
 *分析：
 *1.获取控制台文件夹抽象路径
 *     封装File对象
 *2.使用无限循环判断
 *3.判断抽象路径是否存在，file.exsist()
 *4.判断抽象路径是否是文件夹。file.isd..()
 *5.否则返回文件路径return file
 */
public class FileLength {

	public static void main(String[] args) {
		File directory = isDirectory();
		Long filelength = filelength(directory);
		System.out.println(filelength);
		
		
	}
	
	/**
	 * @param file 要计算大小的文件夹抽象路径对象。
	 * @return 文件夹大小。
	 * 1.定义文件夹初始大小为0.
	 * 2.将文件夹中的文件夹和文件存入文件数组中。filelist()
	 * 3.遍历文件数组。
	 * 4.如果当前元素是文件夹还是文件，如果是文件，算出文件大小。file.length();加上初始文件大小。
	 * 5.如果当前元素是文件夹，则使用递归进入下一级目录，再次执行相同操作
	 * 6.执行n次后，每次遍历计算一个文件夹后返回文件加大小加上上一级文件大小。最终获得文件实际大小。
	 */
	public static Long filelength(File file) {
		//1.定义文件夹初始大小为0.
		long fileLength = 0;
		//将文件夹中的文件夹和文件存入文件数组中。filelist()
		File[] listFiles = file.listFiles();
		//3.遍历文件数组。
		for (File file2 : listFiles) {
			//4.如果当前元素是文件夹还是文件，如果是文件，算出文件大小。file.length();加上初始文件大小。
//			if(file2.isFile()) {
//				fileLength+=file2.length();
//			}else if(file2.isDirectory()) {
//				fileLength+=filelength(file2);
//			}
			//使用三目运算符。
			fileLength=	file2.isFile() ? (fileLength+=file2.length()) : (fileLength+=filelength(file2));
		}
		return fileLength;
		
	}

	/**
	 * @return F封装文件夹抽象路径路径的File对象。
	 */
	public static File isDirectory() {
		//创建控制台键盘录入对象。scanner
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入文件夹抽象路径。");
		//2.使用无限循环判断
		while(true) {
			//获取控制台输入内容。
			String nextLine = scanner.nextLine();
			  // 封装File对象
			File file = new File(nextLine);
			//3.判断抽象路径是否存在，file.exists()
			if(!file.exists()) {
				System.out.println("您输入的抽象路径不存在，请重新输入。");
				//4.判断抽象路径是否是文件夹。file.isDirectory()
			}else if(!file.isDirectory()) {
				System.out.println("您输入的不是文件夹，请重新输入。");
			}else {
				return file;
			}
			
		}
	}
	

}
