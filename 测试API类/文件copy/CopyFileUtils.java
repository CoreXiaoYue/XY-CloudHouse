package com.xiaoyue.io.inputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author 小岳
 *
 */
/**
 * @author Administrator
 *
 */
public class CopyFileUtils {
//	public File inFile; // 要读取的文件。
//	private File outFile; // 要写出的文件。
//
//	/**
//	 * @param infile 要读取的文件抽象路径。
//	 * @param outfile  要写出的文件抽象路径。
//	 */
//	public WriteFileUtils(File infile, File outfile) {
//		this.inFile = infile;
//		this.outFile = outfile;
//	}
	FileInputStream inputStream = null;		//文件输入流
	FileOutputStream outputStream =null;	//文件输出流
	
	/**
	 * @param inFile 要读取的文件抽象路径。
	 * @param outFile 要写出的文件抽象路径。
	 * @throws IOException 文件读取异常
	 */
	public  void writeFile(File inFile,File outfile) throws IOException  {
		 try {
			inputStream = new FileInputStream(inFile); 	//读取文件流
			 outputStream = new FileOutputStream(outfile);  // 输出流
			byte[] by = new byte[1024]; 	// 创建一个字节数组，用于存放读取到的字节
			int len; 	// 声明一个变量来保存读到的字节个数
			while ((len = inputStream.read(by)) != -1) {//每单次读取by字节数组大小的数据，len单次读到的数据，如果len=-1,则说明没有读到数据。停止读取
				outputStream.write(by, 0, len);//将by字节数组中的数据写入到输出流中去。
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeStream();
		}
	}
	
	/**释放资源：关闭输入输出流
	 * @throws IOException
	 */
	public void closeStream() throws IOException {
		try {
			if(inputStream!=null) {
				inputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(outputStream!=null) {
				outputStream.close();
			}
		}
	}

	/**
	 * @return
	 * 1.读取用户输入的路径
	 * 2.判断路径是否存在。
	 * 3.判断历经是否是一个文件。
	 * 4.是文件就就返回文件对象
	 */
	public static File getFile() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个要上传文件路径");
		while(true) {
			String nextLine = scanner.nextLine();
			File filepath=new File(nextLine);
			if(!filepath.exists()) {
				System.out.println("你输入的路径不存在，请重新输入。");
			}else if(filepath.isDirectory()){
				System.out.println("你输入的路径是文件夹，请重新输入。");
			}else {
				return filepath;
			}
		}
	}
	
	/**
	 * @return文件保存的路径
	 * 1.获取上传文件的文件名。
	 * 2。将文件名后缀提取出来与用户输入的保存文件名后缀比较，
	 * 3.判断要上传的文件的后缀是否与保存文件的后缀相同。
	 * 1.解析输入的路径文件夹是否存在。
	 * 2.解析路径名是否是
	 * 
	 * 
	 */
	public static File getFileTarget(String fileNmae) {
		Scanner scanner=new Scanner(System.in);
		int lastIndexOf = fileNmae.lastIndexOf(".");//获取文件最后一次出现‘.’的索引。
		String fileEnd = fileNmae.substring(lastIndexOf);//指定开始索引截取文件名后半部分
		System.out.println("请输入要保存文件的路径及文件名");
		
		while(true) {
			String nextLine = scanner.nextLine();
			if(!nextLine.contains(fileEnd)) {//输入的路径是否包含上传文件的后缀名
				System.out.println("你输入保存文件的类型不一致，请重新输入。");
			}else {
				int endIndex = nextLine.lastIndexOf("\\");//获取文件最后一次出现‘\’的索引。
				String directoryPath = nextLine.substring(0,endIndex);//指定开始索引截取文件名后半部分
				File directoryPathFile=new File(directoryPath);//获取文件夹抽象路径
				File fileTargetpath=new File(nextLine);
				if(!directoryPathFile.exists()) {
					System.out.println("你输入的路径不存在，无法保存，请重新输入。");
				}else if(!directoryPathFile.isDirectory()){
					System.out.println("你输入的路径是文件夹不存在，请重新输入。");
				}else {
					return fileTargetpath;
				}
				
			}
			
		}
	}
	
}
