package com.xiaoyue.io.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author 小岳
 *在控制台输入两个文件夹路径，进行文件拷贝
 */
public class copyDicretory {

	public static void main(String[] args) throws IOException {
		File dist = isDirectory();
		File src = isDirectory();
		copyDicretoryAndFiles(dist, src);
	}
	
	
	/**
	 * @param dist 要拷贝的文件夹
	 * @param src 拷贝到的文件夹
	 * @throws IOException 
	 */
	public static void copyDicretoryAndFiles(File dist,File src) throws IOException {
		//提取要拷贝文件夹的名字。
		String name = dist.getName();
		//创建目标文件夹抽象路径。
		File file=new File(src, name);
		//在目标文件夹下创建要拷贝的文件夹目录。
		file.mkdirs();
		//获取要拷贝文件夹的集合数组
		File[] listFiles = dist.listFiles();
		//遍历文件数组。
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		for (File file2 : listFiles) {
			//如果当前元素是文件，就创建输入流读取文件类容并拷贝。
			if(file2.isFile()) {
				//获取要拷贝的文件名字
				String name2 = file2.getName();
				//创建输入流关联要读取的抽象文件路径
				bis = new BufferedInputStream(new FileInputStream(file2));
				//创建输出流关联目标文件夹路径加上文件名
				bos = new BufferedOutputStream(new FileOutputStream(file+name2));
				int b;//存储字节
				while((b = bis.read()) !=-1) {//如果读到的字节数不等于-1
					bos.write(b);//将字节写到文件中
				}
			}else {
				//如果当前元素是文件夹，则使用递归执行以上操作，直到拷贝完最底层的文件夹里的文件，就跳回上一级文件夹进行判断拷贝。
				copyDicretoryAndFiles(file2,file);
			}
			
		}
		bis.close();//关闭输入流
		bos.close();//关闭输出流
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
