package com.xaioyue.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �Զ����ļ�ϵͳ�������
 * 
 * @author С��
 *
 */
public class FileSystemClassLoader extends ClassLoader {

//com.bjsxt.test.User   --> d:/myjava/  com/bjsxt/test/User.class      
	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	
	/* (non-Javadoc)Ҫ�������ȫ·����
	 * @see java.lang.ClassLoader#findClass(java.lang.String)
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//����ȫ·���������ࡣ
		Class<?> c = findLoadedClass(name);

		//Ӧ��Ҫ�Ȳ�ѯ��û�м��ع�����ࡣ����Ѿ����أ���ֱ�ӷ��ؼ��غõ��ࡣ���û�У�������µ��ࡣ
		if (c != null) {//���ص��˲�Ϊ�վͷ���
			return c;
		} else {
//			//����ʹ��˫��ί��ģ���ø�����ء�
//			//���ڼ��ص���һ���������Լ�д���࣬�����ǲ�����صġ�
//			ClassLoader parent = this.getParent();
//			try {
//				c = parent.loadClass(name); // ί�ɸ��������
//			} catch (Exception e) {
//				//    e.printStackTrace();
//			}

//			if (c != null) {//���������ص����ͷ���
//				return c;
//			} else {//û�м��ص���ʹ���Զ��������
				byte[] classData = getClassData(name);//��дһ������������ֵ����һ�����ȫ·������-----62��
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
	 * @param classname Ҫ�������ȫ·����
	 * @return ����class�ֽ����ļ����ֽ�����
	 */
	private byte[] getClassData(String classname) { // com.bjsxt.test.User d:/myjava/ com/bjsxt/test/User.class
		String path = rootDir + "/" + classname.replace('.', '/') + ".class";//�����ȫ·������ʽ�����ļ�·�������������滻�ɡ�/����
		
//  IOUtils,����ʹ���������е�����ת���ֽ�����
		InputStream is = null;//������������ȡ�ֽ����ļ�
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//�����ֽ����������
		try {
			is = new FileInputStream(path);//�����ļ�����������ȡ�ļ�

			byte[] buffer = new byte[1024];//����һ����ʱ�ֽ�����������
			int temp = 0;
			while ((temp = is.read(buffer)) != -1) {//�������ֽ���������-1��һֱ��
				baos.write(buffer, 0, temp);//���ֽ������������д�뵽�������ȥ
			}

			return baos.toByteArray();//���ֽ������ת�����ֽ����顣
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {//�ر���
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
