package com.xiaoyue.test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 小岳
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
//		Collections.binarySearch(list, key);
		int[] arrays1 = {6,5,4,3,2,1,7};
		sortArrays(arrays1);
		System.out.println(Arrays.toString(arrays1));
		int serch = binarySearch(arrays1,4);
		System.out.println(serch);
		
	}

	private static int binarySearch(int[] arrays1, int f) {
		// 二分查找法
		// 定义两个变量(low)表示第一个元素的索引，（higth）表示最后一个元素。
		// 找出数组中间元素，（第一个元素+第二个元素）/2
		int low = 0;// 第一个元素索引
		int higth = arrays1.length - 1;// 表示最后一个元素
		while (low < higth) {
			int midle = (low + higth) / 2;// 中间元素的索引
			if (f > arrays1[midle]) {// 去除前半截元素
				low = midle + 1;// 将比较起始元素索引换成midle+1;
			} else if (f < arrays1[midle]) {
				higth = midle - 1;// 将最后元素索引换成midle-1;
			} else {
				System.out.println(midle);
				return midle;// 否则返回当前索引
			}
		}
		return -1;
	}

	/**
	 * @param arrays1 要排序的数组
	 *                排序：使用循环遍历，将前一个元素于后一个元素比较大小，将大的元素保存到一个变量当中，三个变量分别调换位置，这样大的与小的就调换位置了，大的放后面。循环比较数组长度-1次。
	 *                遍历一次数组就将数组中最大的元素放入最后边（升序）。
	 *                每遍历一次，就有一个元素被排好序，后面就不用排了，所以没排一次下一趟就少比较一次。将比较次数减去趟数。排好序的元素个数=趟数
	 * 
	 */
	private static void sortArrays(int[] arrays1) {
		for (int j = 0; j < arrays1.length - 1; j++) {// 要循环的趟数。数组长度 —1
			System.out.println("第"+(j + 1) + "趟");
			int temp = 0;
			for (int i = 0; i < arrays1.length - 1 - j; i++) {// 每次要比较的次数。排好序的元素个数 = 趟数
				if (arrays1[i] > arrays1[i + 1]) {// 将前一个与后一个元素比较大小
					temp = arrays1[i];// 先将大的元素保存起来
					arrays1[i] = arrays1[i + 1];// 将小的赋值给大的。
					arrays1[i + 1] = temp;// 再将刚才小元素的引用指向大的元素所指向的地址，这项经过一轮循环之后，最大的元素就放到了最后。
				}
				System.out.print("第"+(i + 1) + "次:");
				System.out.println(Arrays.toString(arrays1));
			}
		}
	}

}
