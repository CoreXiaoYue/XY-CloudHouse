package com.xiaoyue.test;

import java.util.function.Consumer;

public class LambdaTest {
	
	public void test1(Anmail a) {
		a.eat();
	}
	public void test2(String name,Products p) {
		
		p.name(name);
	}
	public int test3(Computer c) {
		int a = 20;
		int b = 2;
		return c.show(a,b);
	}

	public static void main(String[] args) {
		LambdaTest lam;
		String name;
		try {
			lam = new LambdaTest();
			lam.test1(() -> System.out.println("���ﶼ����ʳ��"));
			name = "����";
			lam.test2(name,(pname) -> {
				System.out.println(pname);
			});
		}finally {
			
		}
		System.out.println(lam.test3((a,b) -> a+b));
		User u = new User("С��",25);
		Consumer<User> c =(u1) ->{
			u1.setAge(50); 
		};
		c.accept(u);
		
		System.out.println(u);
		
		Converter c1 = (str1) -> Integer.valueOf(str1);
		Converter c2 = Integer::valueOf;
		System.out.println(c1.converter("20"));
		System.out.println(c2.converter("20"));
		
		Converter1 c3 = String::indexOf;
		System.out.println(c3.converter1("asdfgh","d"));
		
		Converter2 c4 = "sdfsdf"::contains;
		Converter2 c5 = str1 -> "sdfsdf".contains(str1);
		System.out.println(c4.converter2("sd1"));
		System.out.println(c5.converter2("sd1"));
		
		Products p = ttt ->{
			System.out.println(ttt);
			System.out.println("fwsedtgwr"+ttt);
		};
		p.name("fff");
		
		User u1 = new User("С��",25);
		User u2 = new User("С��",25);
		Converter3 converter =  User::equals;
		System.out.println(converter.converter2(u1, u2));
	}

}
interface Anmail{
	void eat();
}
interface Products{
	void name(String name);
}
interface Computer{
	int show(int a,int b);
}
interface Converter{
	Integer converter(String str);
}
interface Converter1{
	int converter1(String target,String arg);
}
interface Converter2{
	boolean converter2(String str);
}

interface Converter3{
	boolean converter2(User tsrget,User arg);
}
