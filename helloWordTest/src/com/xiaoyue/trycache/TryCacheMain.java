package com.xiaoyue.trycache;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class TryCacheMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个整数：");
		boolean flog=false;
		while(!flog) {
			
			String line = scanner.nextLine();
			try {
				int parseInt = Integer.parseInt(line);
				String binaryString = Integer.toBinaryString(parseInt);
				System.out.println(parseInt+"转成二进制数："+binaryString);
				flog=true;
				continue;
			} catch (NumberFormatException e) {
				try {
					new BigInteger(line);
					System.out.println("你输入的数字太大。");
					
				} catch (Exception e1) {
					try {
						new BigDecimal(line);
						System.out.println("你输入胡是小数。");
					} catch (Exception e2) {
						System.out.println("你输入的是非法字符。");
					}
				}
				
			}
		}
		
	
		
	}

}
