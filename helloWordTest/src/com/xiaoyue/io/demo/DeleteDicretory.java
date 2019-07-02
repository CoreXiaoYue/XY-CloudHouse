package com.xiaoyue.io.demo;

import java.io.File;
import java.util.Scanner;

/**
 * @author 小岳
 *使用递归删除文件夹。
 */
public class DeleteDicretory {

	public static void main(String[] args) {
		File directory = isDirectory();
		deleteDiretory(directory);
	}
	
	/**
	 * @param file 要删除的文件夹
	 * 1.将文件夹
	 */
	public static void deleteDiretory(File file) {
		//将文件夹中的文件夹和文件存入文件数组中。filelist()
		File[] listFiles = file.listFiles();
		//3.遍历文件数组。
		for (File file2 : listFiles) {
			//4.如果当前元素是文件就删除。
			if(file2.isFile()) {
				file2.delete();
				//如果当前元素是文件夹就使用递归循环执行以上操作。
			}else if(file2.isDirectory()) {
				//递归进入文件夹删除文件
				deleteDiretory(file2);
				//删除目标文件夹下的文件夹
				file2.delete();
			}
		}
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
