package com.xiaoyue.io.inputStream;

import java.io.File;
import java.io.IOException;
import java.nio.channels.NonReadableChannelException;

public class testMain {
	public static void main(String[] args) {
//		try {
//			FileEncryption.EncryptionFile("Test3.txt", "enTest3.txt");
//		} catch (IOException e) {
//			System.out.println("加密失败");
//			e.printStackTrace();
//		}
//		try {
//			FileEncryptionUtils.DecryptionFile("enTest3.txt", "解密Test3.txt");
//		} catch (IOException e) {
//			System.out.println("文件解密失败");
//			e.printStackTrace();
//		}
		
		CopyFileUtils copyFileUtils=new CopyFileUtils();
		File filepath = CopyFileUtils.getFile();//获取上传路径
		File fileTargetpath = CopyFileUtils.getFileTarget(filepath.getName());//获取下载路径
		try {
			copyFileUtils.writeFile(filepath, fileTargetpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
		
//		String s="dfd.jpg";
//		String string="sdsd\\sd\\sd\\sddfdr\\fg.jpg";
//		int lastIndexOf = string.lastIndexOf(".");//获取文件最后一次出现‘.’的索引。
//		String fileEnd = string.substring(lastIndexOf);//指定开始索引截取文件名后半部分
//		boolean contains = s.contains(fileEnd);
//		System.out.println(contains);
//		String nextLine="E:\\百度网盘Dwnloand\\2000张背景图片素材\\5.精美各种图片\\背景文理\\sd.jpg";
//		int endIndex = nextLine.lastIndexOf("\\");//获取文件最后一次出现‘\’的索引。
//		String directoryPath = nextLine.substring(0,endIndex);//指定开始索引截取文件名后半部分
//		System.out.println(directoryPath);
//		File directoryPathFile=new File(directoryPath);//获取文件夹抽象路径
//		if(!directoryPathFile.exists()) {
//			System.out.println("你输入的路径不存在，请重新输入。");
//		}
	
		
	}
}
