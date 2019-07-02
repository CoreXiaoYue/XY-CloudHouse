package com.xiaoyue.emun;

public class EnumMain {

	public static void main(String[] args) {
			code();
			
			code2();
	}

	public static void code2() {
		Week week1=Week.TUE;
		Week week2=Week.MON;
		System.out.println(week1.ordinal());
		System.out.println(week2.compareTo(week1));
		System.out.println(week1.name());
		System.out.println(week1.toString());
		System.out.println(Week.valueOf(Week.class, "TUR"));
		System.out.println("-------------------------------");
		Week[] weeks = Week.values();
		for (Week week : weeks) {
			System.out.println(week);
		}
	}

	public static void code() {
		Week week1=Week.TUE;
		System.out.println(week1.getName());
		switch (week1) {
		case MON:
			System.out.println("匹配成功MON");
			break;
		
		case TUE:
			System.out.println("匹配成功TUE");
			break;
		default:
			break;
		}
	}

}
