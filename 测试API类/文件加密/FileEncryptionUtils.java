package com.xiaoyue.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Administrator
 *文件加密与解密
 */
public class FileEncryptionUtils {
	

	/**文件加密：对一个字节异或相同的数字两次，还是本来的字节数
	 * @param intpath 输入流抽象路径：加密前文件的抽象路径
	 * @param outpath 输出流抽象路径：加密后文件的抽象路径
	 * @throws IOException
	 */
	public static void EncryptionFile(String intpath,String outpath) throws IOException {
		try(BufferedInputStream bufi=new BufferedInputStream(new FileInputStream(intpath));
			BufferedOutputStream bufo=new BufferedOutputStream(new FileOutputStream(outpath));)
		{
			int b;
			while((b=bufi.read())!=-1) {
				bufo.write(b ^ 123);//一个字节异或一个数，对字节改变，进行加密
			}
		}
		
		
	
	}
	/**文件解密
	 * @param intpath 输入流抽象路径：解密前文件的抽象路径
	 * @param outpath 输出流抽象路径：解密后文件的抽象路径
	 * @throws IOException
	 */
	public static void DecryptionFile(String intpath,String outpath) throws IOException {
		try(	BufferedInputStream bufi=new BufferedInputStream(new FileInputStream(intpath));
				BufferedOutputStream bufo=new BufferedOutputStream(new FileOutputStream(outpath));
		  ){
			int b;
			while((b=bufi.read())!=-1) {
				bufo.write(b ^ 123);//异或相同的一个数，对字节还原，进行解密。
			}
		}
	}

}
