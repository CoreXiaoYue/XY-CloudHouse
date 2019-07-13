package com.xiaoyue.hashMap;

/**理解hashMap存储原理。
 * @author 小岳
 * 自己实现hashMap。
 *
 */
public class MyHashMap {
	Node[] table;//用于存放数据的数组
	int size;//map大小
	
	/**
	 * @param size 初始化数组大小
	 */
	public MyHashMap(int size){
		table = new Node[size];
	}
	
	/** 
	 * @return 返回容器大小
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @param key 要存放的键
	 * @param value 要存放的值
	 */
	private void put(Integer key,String value) {
		Node newNode = new Node();
		newNode.hash = hash(key.hashCode(), table.length);//将计算出的hash值赋给当前元素。算出hash值目的是找出数组里的元素。
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;//下一个为空
		Node temp = table[newNode.hash];//通过要添加对象的hash值来获取数组里的元素
		Node LastNode = null;//保存最后一个元素
		boolean flag = false;//默认不重复。
		if(temp == null) {//等于空
			table[newNode.hash] = newNode;//直接将此对象放到数组里
			size++;
		}else {
			while(temp != null) {//不等于空,考虑key相等
				if(temp.key.equals(key)) {
					temp.value = value;
					flag = true;
					break;//停止循环
				//考虑key不相等。
				}else {
					LastNode = temp;//临时存放最后一个元素
					temp = temp.next;//当为空时。temp就被赋值为空了，就没放记录最后一个元素。
				}
			}
			
			if(!flag) {
				LastNode.next = newNode;//如果不重复。就将新元素赋给最后一个元素。
				size++;//容器长度加1
			}
		}
	}
	
	
	/**
	 * @param key 通过键获取对应的值。
	 * @return 返回获取的值。
	 */
	public Object get(int key) {
		int hash = hash(key, table.length);//算出key的hash值，
		Object value = null;				//定义返回的value值
		Node node = table[hash];			//通过hash值找到对应数组的链表元素
		if(node != null) {					//如果hash值所对应的数组为空。就对key值与数组元素的key比较。
			while(node != null) {			//循环判断key值
				if(node.key.equals(key)) {	//如果key相等，那么就将此元素的value值返回
					value = node.value;
					break;					//停止循环
				}else {						//如果key不相等。就获取链表的下一个元素，进行比较
					node = node.next;		//指向链表下一个元素
				}
			}
		}
		return value;						//返回value值
		
	}
	
	 /**
	 * @param key 要存放的键
	 * @param length 数组的长度
	 * @return 通过算法计算返回元素的hash值，此hash值不会超过数组索引
	 * 存放的方式就是根据此hash值充当数组的索引存放到指定位置。
	 * 
	 */
	public static int hash(int key,int length){
//		 System.out.println("hash值："+ (key&(length-1)));//2的N次幂。
//		 System.out.println("hash值："+ (key/length));
		 int hash =  key&(length-1);
		return hash;
		
	};
	/* (non-Javadoc)
	 * @see java.lang.Object#toString() 重写toString方法，打印对象
	 */
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();	//创建可变字符串
		sBuilder.append("{");
		for(int i=0; i<table.length;i++) {				//循环遍历数组
			Node node = table[i];						//获取每一个数组元素。
			while(node != null) {						//如果不等于空，
				sBuilder.append("key:"+node.key+",value:"+node.value+",");//就将元素的键和值按格式拼接。
				node = node.next;						//循环获取链表下一个元素。
			}
		}
		sBuilder.setCharAt(sBuilder.length()-1, '}');	//将可变字符串最后一个字符变成‘}’。
		return sBuilder.toString();						//可变字符串转成字符串。
		
	}

	public static void main(String[] args) {
//		HashMap<String, String> hashMap=new HashMap<String, String>();
		
		MyHashMap myHashMap = new MyHashMap(16);
		myHashMap.put(10, "aa");
//		myHashMap.put(26, "tt");
		myHashMap.put(88, "bb");
		myHashMap.put(4, "cc");
		myHashMap.put(20, "dd");
		myHashMap.put(36, "ee");
		myHashMap.put(68, "ff");
		myHashMap.put(10, "ssss");
		System.out.println(myHashMap);
		System.out.println(myHashMap.size());
		System.out.println(myHashMap.get(10));
		System.out.println(myHashMap.get(88));
//		for (int i = 0; i < 100; i++) {
//			System.out.println(i+"--"+hash(i, 16));//81,85,93
//		}
		
	}

}
class Node{
	int hash;//对象的hash值
	Object key;//对象的键
	Object value;//对象的值
	Node next;//下一个元素。
	
	public Node() {
	}
	
	
}