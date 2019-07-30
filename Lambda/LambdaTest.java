package com.xiaoyue.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author 小岳
 * 		Lambda表达式：函数式接口，接口中只有一个抽象方法
 *
 */
public class LambdaTest {

	public static void main(String[] args) {
		int str = 121;
		IntFunction<String> consumer =String::valueOf;//将数字转成字符串
		System.out.println(consumer.apply(str)+1);//1211
		
		String str1 = "121";
		StrValOfFunction consumer1 =Integer::valueOf;//将字符串转成数字
		System.out.println(consumer1.apply(str1)+1);//122
		
		var list = new ArrayList<String>();
		list.add("8");
		list.add("3");
		list.add("4");
		list.add("1");
		list.forEach(strs-> System.out.println(strs));
		MyFunction myFunction = (list1,f) -> Collections.binarySearch(list1, f);//Lambda引用类方法方式
		MyFunction myFunction1 = Collections::binarySearch;//方法引用方式
		int apply = myFunction.apply(list, "4");
		System.out.println(apply);	//2
		
		int[] arr = {8,4,2,54,6,24};
		ArraySortFunction sort = (sor) -> Arrays.sort(sor);//Lambda引用类方法方式
		ArraySortFunction sort1 = Arrays::sort;//方法引用
		sort.apply(arr);
		System.out.println(Arrays.toString(arr));	//[2, 4, 6, 8, 24, 54]
		
		RefenceObjFunction roj = (a1,a2) ->a1.contains(a2);//Lambda引用实例方法
		RefenceObjFunction roj1 =String::contains;//方法引用
		boolean findresult = roj.apply("abcghhdhg", "cg");
		System.out.println(findresult);	//true
		
		
		NewFunction nf = (size) -> new ArrayList<String>(size);//Lambda引用构造器方式
		NewFunction nf1 =ArrayList::new ;//构造器方法引用代替lambda方式
		List<String> apply2 = nf.apply(10);//创建了一个初始为10大小的ArrayList
	}

}

@FunctionalInterface
interface StrValOfFunction{
	int apply(String str);
	
}

@FunctionalInterface
interface MyFunction{
	int apply(List<String> list,String obj);
	
}
@FunctionalInterface
interface ArraySortFunction{
	void apply(int[] arr);
}

@FunctionalInterface
interface RefenceObjFunction{
	boolean apply(String str,CharSequence ch);
}

@FunctionalInterface
interface NewFunction{
	List<String> apply(int size);
	
}