package com.xiaoyue.binarySoerch;

public class Test01 {
	public static void main(String[] args) {
		int[] array = {1,8,6,3,245,68,56,2,4};
		for (int i = 0; i < array.length; i++) {
			if(array[i] == 68) {
				System.out.println("index:"+i);
			}
		}
	}
}
