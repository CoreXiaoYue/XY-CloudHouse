package com.xiaoyue.io.reader;

import java.io.File;
import java.util.Scanner;

/**
 * @author 小岳
 *使用递归在控制台打印出指定文件夹中以.java结尾的文件
 *分析：
 *1.检测键盘输入的抽象文件路径
 *2.将路径包装成文件File数组对象。
 *3.判断输入的抽象是否存在，不存在给与提示。
 *4.判断输入的抽象路径是否是文件夹。不是文件夹给予提示。
 *5.否则将就返回file对象。
 *6.使用file对象返回一个抽象路径名数组listFiles，这些路径名表示此抽象路径名所表示目录中的文件。
 *7.对抽象名数组进行遍历fileName。
 *8.判断是否是文件并且是以.java结尾的文件。
 *9.如果是文件夹，则调用递归进入文件夹查找。
 */

public class RecursionFileName {
	public static void main(String[] args) {
		File file = isDirectory();
		printJavaFile(file);
	}
	
	/**
	 * @param file 需要递归查找的抽象路径名。
	 */
	public static void printJavaFile(File file) {
		//返回一个抽象路径名数组，这些路径名表示此抽象路径名所表示目录中的文件
		File[] listFiles = file.listFiles();
		int count=0;
		//对抽象名数组进行遍历。
		for (File fileName : listFiles) {
			//判断是否是文件并且是以.java结尾的文件
			if(fileName.isFile() && fileName.getName().endsWith(".java")){
				count++;
				System.out.println(fileName);
				//如果是文件夹，则调用递归
			}else if(fileName.isDirectory()) {
				printJavaFile(fileName);
			}
		}
		System.out.println("共"+count+"个java文件");
	}
	
	
	/**
	 * @return 文件夹抽象路径名
	 * 
	 * 判断路径是否存在
	 * 判断抽象路径名是否是文件夹
	 */
	public static File isDirectory() {
		//1.检测键盘输入的抽象文件路径。
		Scanner scanner=new Scanner(System.in);
		//提示输入。
		System.out.println("请输入一个文件抽象路径");
		//循环判断
		while(true) {
			//获取输入的内容。
			String nextLine = scanner.nextLine();
			File file = new File(nextLine);
			//3.判断输入的抽象是否存在，不存在给与提示。
			if(!file.exists()) {
				System.out.println("输入的文件抽象路径不存在，请重新输入。");
				//4.判断输入的抽象路径是否是文件夹。不是文件夹给予提示。
			}else if(!file.isDirectory()) {
				System.out.println("你输入的抽象文件路径不是文件夹。");
			}else {
				return file;
			}
		}
		
	}

}
