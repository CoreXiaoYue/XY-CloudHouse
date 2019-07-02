package com.xiaoyue.command;

public class CommandTest {


	public static void main(String[] args) {
		 String str1="3";
		int a = 2;
		int t = 4;
		System.out.println(str1+a+t);
		String str2="he"+ new String("llo");
		
		System.out.println("4&7="+(4&7));
		System.out.println("5|9="+(5|9));
		System.out.println("3^11="+(3^11));
		System.out.println(str1==str2);
//		static String nameString = "df";//
		System.out.println(args[0]);
		ProcessArray processArray = new ProcessArray();
		int[] arrays = { 5, 8, 6, 52, 3, 52, 6 };

		processArray.each(arrays, new Command() {

			@Override
			public void process(int[] target) {
				for (int array : target) {
					System.out.println(array);
				}
			}
		});

		processArray.each(arrays, new Command() {

			@Override
			public void process(int[] target) {
				System.out.println("==================");
				System.out.println(target.length);
			}
		});

		processArray.each(arrays, target -> {
			for (int i : target) {
				System.out.println(i);
			}
		});
		

//		final String strirfgng = "152";
		String ffString = "asd";
		 Integer dIntege = 12;
		Integer fgIntege = 12;
		System.out.println(dIntege == fgIntege);
		Integer dInteger = 128;
		Integer fgInteger = 128;
		System.out.println(dInteger == fgInteger);
		System.out.println(1 >>> 2);

		int i, sum = 0;
		for (i = 0; i < 10; ++i) {
			sum += i;
			
		}
		System.out.println(i);
	
		System.out.println(1>>>2);
			
	}
}
