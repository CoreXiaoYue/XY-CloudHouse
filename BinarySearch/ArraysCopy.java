package com.xiaoyue.test;

import java.util.ArrayList;

/**
 * @author 小岳
 *
 */
public class ArraysCopy {

	public static void main(String[] args) {
		int[] arrays = {1,5,2,45,6};
		int[] newArrays = new int[arrays.length*2];
		for(int i =2;i<arrays.length;i++) {
			newArrays[i] = arrays[i];//数组拷贝
		}
		for (int i : newArrays) {
			System.out.println(i);
		}
		ArrayList<String> list = new ArrayList();
	}

}
