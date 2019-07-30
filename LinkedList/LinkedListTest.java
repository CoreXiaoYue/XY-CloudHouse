package com.xiaoyue.test;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author 小岳
 * 		简单写个LinkedList,不完整
 *
 * @param <E>
 */
public class LinkedListTest<E>  {
	E obj;//添加的元素。
	private  Node<E> frist;//第一个节点
	Node<E> last;//最后一个节点
	private int size;//元素个数
	int cours;//记录链表操作次数
 


	public static void main(String[] args) {
		LinkedListTest<String> linkedListTest = new LinkedListTest<String>();
		String name = "小岳";
		linkedListTest.add("123");
		linkedListTest.addfrist(name);
		linkedListTest.add("1234");
		linkedListTest.add("12346");
		linkedListTest.add("1235");
		linkedListTest.add(2,"1235666");
		linkedListTest.addfrist("sdsd");
		linkedListTest.addLast("sdsdcv");
		linkedListTest.addLast("sdsdcv12");
		linkedListTest.add("12346888");
		System.out.println(linkedListTest.size());
		System.out.println(linkedListTest.getFrist());
		System.out.println(linkedListTest.getLast());
		System.out.println(linkedListTest.remove(5));
		System.out.println(linkedListTest.size());
		System.out.println(linkedListTest.getFrist());
		System.out.println(linkedListTest.get(5));
		Iterator<String> iterator = linkedListTest.iterator();
		while(iterator.hasNext()) {
			System.out.println(	iterator.next());
			
		}
		

		
		
	}
	
	/**
	 * @param index 获取元素的位置
	 * @return
	 */
	public E get(int index) {
		
		return getByIndex(index).item;
		
	}
	
	/**
	 * @return 第一个元素
	 */
	public E getFrist() {
		Node<E> f = frist;
		if(f != null) {
			return f.item;
		}
		return null;
		
	}
	
	/**
	 * @return 随后一个元素
	 */
	public E getLast() {
		Node<E> l = last;
		if(l != null) {
			return l.item;
		}
		return null;
	}
	
	/**
	 * @param obj 链表末尾添加元素
	 * @return 是否添加成功
	 */
	public Boolean add(E obj) {
		Node<E> l = last;
		Node<E> newNode = new Node(l,obj,null);
		last = newNode;
		if(l == null) {
			frist = newNode;
		}else {
			l.next = newNode;
		}
		size++;
		return true;
	}
	
	/**
	 * @param index  指定位置删除，
	 * @return
	 */
	public boolean remove(int index) {
		if(index<0||index>size()) {
			System.out.println("超出范围");
		}
		
		if(index == 1) {
			Node<E> f = frist;
			Node<E> next = f.next;
			frist = next;
			next.prev = null;
			next = frist;
		}else if(index == size()){
			Node<E> l = last;
			Node<E> prev = l.prev;
			prev.next = null;
			last = prev;
		}else {
			Node<E> byIndex = getByIndex(index);
			byIndex.next = byIndex.prev;
			byIndex.prev = byIndex.next;
		}
		size--;
		return true;
		
	}

	
	/**
	 * @param index 指定位置添加
	 * @param obj	添加的对象
	 * @return
	 */
	public Boolean add(int index,E obj) {
		if(index == size()) {
			add(obj);
		}else {
			Node<E> node = getNode(obj,index);//获取到要插入节点的元素。
			Node<E> prev = node.prev;
			Node<E> newNode = new Node<E>(prev,obj,node);
			if(prev == null) {
				frist = newNode;
			}else{
				node.prev = newNode;
			}
		}
		size++;
		return true;
	}
	
	
	
	/**
	 * @param obj  获取的对象
	 * @param index 指定位置
	 * @return
	 */
	private Node<E> getNode(E obj,int index) {
		Node<E> fNode = getByIndex(index);
		return fNode;//返回查找到的节点
		
		
	}

	/**
	 * @param index  指定的位置
	 * @return	返回节点
	 */
	private Node<E> getByIndex(int index) {
		Node<E> fNode = null;
		if(index<size()/2) {//查找的元素小于总长度的一半
			 fNode = frist;//从前往后遍历查找
			for (int i = 0; i < index; i++) {
				fNode = fNode.next;//获取下一个
			}
		}else {		//查找的元素大于总长度的一半
			fNode = last;//从后往前查找
			for (int i = size(); i > index; i--) {
				fNode = fNode.prev;//获取上一个
			}
		}
		return fNode;
	}

	/**
	 * @param obj 在链表头添加一个元素
	 */
	public void addfrist(E obj) {
		 Node<E> f = frist;//获取第一个元素。
		 Node<E> newNode = new Node<E>(null,obj,f);//新建一个节点，该节点指向的上一个节点为空。
		 frist = newNode;//将新节点设置为第一个节点。
		 if(f==null) {//如果获取的第一个节点为空。空链表
			 last = null;//那么最后一个节点就为空。
		 }else{
			 f.prev = newNode;//否则将第一个节点的上一个元素指向新节点。
		 }
		 size++;//长度加1
	}
	/**
	 * @return	链表的长度
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @param obj	链表尾部添加元素
	 */
	public void addLast(E obj) {
		Node<E> l = last;//获取最后一个节点。
		Node<E> newNode = new Node<E>(l,obj,null);//新建一个节点。
		last = newNode;//将新节点设为最后一个。
		if(l == null) {//如果获取的最后一个节点为空，
			frist = newNode;//就将新节点设为frist
		}else{
			l.next = newNode;//将获取的最后一个元素的下一个节点指向新节点。
		}
		size++;//长度加1
	}
	
	/**
	 * 
	 *		节点
	 * @param <E> 元素的类型
	 */
	private static	class Node<E> {
		E item;//节点的值
		Node<E> next;//指向当前节点上一个节点
		Node<E> prev;//指向当前节点下一个节点
		
		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterater<E>();
		
	}
	
	@SuppressWarnings("unchecked")
	private class LinkedListIterater<E> implements java.util.Iterator<E>{
		private Node<E> frist1 = (Node<E>) frist.next;
		private int modCount = 0;
		@Override
		public boolean hasNext() {
			return frist1!=last;
		}
		
		@Override
		public E next() {
			
			E item = frist1.item;
			frist1 = frist1.next;
			
			
			return item;
		}
		
	}
}
