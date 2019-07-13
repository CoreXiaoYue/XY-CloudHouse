package com.xaioyue.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义文件系统类加载器
 * 
 * @author 小岳
 *
 */
public class FileSystemClassLoader extends ClassLoader {

//com.bjsxt.test.User   --> d:/myjava/  com/bjsxt/test/User.class      
	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	
	/* (non-Javadoc)要加载类的全路径名
	 * @see java.lang.ClassLoader#findClass(java.lang.String)
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//根据全路径名加载类。
		Class<?> c = findLoadedClass(name);

		//应该要先查询有没有加载过这个类。如果已经加载，则直接返回加载好的类。如果没有，则加载新的类。
		if (c != null) {//加载到了不为空就返回
			return c;
		} else {
//			//否则使用双亲委派模型让父类加载。
//			//由于加载的类一般是我们自己写的类，父类是不会加载的。
//			ClassLoader parent = this.getParent();
//			try {
//				c = parent.loadClass(name); // 委派给父类加载
//			} catch (Exception e) {
//				//    e.printStackTrace();
//			}

//			if (c != null) {//如果父类加载到，就返回
//				return c;
//			} else {//没有加载到就使用自定义类加载
				byte[] classData = getClassData(name);//自写一个方法，参数值的是一个类的全路径名，-----62行
				if (classData == null) {
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
				}
//			}

		}

		return c;

	}
	
	/**
	 * @param classname 要加载类的全路径名
	 * @return 返回class字节码文件的字节数组
	 */
	private byte[] getClassData(String classname) { // com.bjsxt.test.User d:/myjava/ com/bjsxt/test/User.class
		String path = rootDir + "/" + classname.replace('.', '/') + ".class";//将类的全路径名格式化成文件路径名，‘。’替换成‘/’。
		
//  IOUtils,可以使用它将流中的数据转成字节数组
		InputStream is = null;//声明输入流读取字节码文件
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//创建字节输出流对象。
		try {
			is = new FileInputStream(path);//创建文件输入流，读取文件

			byte[] buffer = new byte[1024];//声明一个临时字节数组存放数据
			int temp = 0;
			while ((temp = is.read(buffer)) != -1) {//读到的字节数不等于-1，一直读
				baos.write(buffer, 0, temp);//将字节数组里的数据写入到输出流中去
			}

			return baos.toByteArray();//将字节输出流转换成字节数组。
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {//关闭流
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (baos != null) {
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
