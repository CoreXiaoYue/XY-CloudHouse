package com.xiaoyue.ssm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

/**找出文件中每个字符出现的次数并在另一个文件中输出
 * @author 岳俊江
 *
 */
public class FindCharNumberInFileUtils {

	
	/**找出文件中每个字符出现的次数并在另一个文件中输出。
	 * @param findFilePath 要查找的文件抽象路径。
	 * @param outFilePath 要将查找结果保存到指定文件的抽象路径。
	 * @throws FileNotFoundException 文件找不到异常。
	 * @throws IOException 文件流异常。
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

}
