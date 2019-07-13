package com.xiaoyue.linkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MyLinkedList<T> {

	public MyLinkedList() {

	}

	Node<T> first;// 第一个元素
	Node<T> last;// 第二个元素
	int size;// 元素的个数。
	// 添加元素

	/**
	 * @param elments 要添加的元素 判断第一个元素是否为空， 如果为空，那么添加的这个元素就是第一个元素，也是最后一个元素。
	 *                如果不为空，那么last的next就是新添加的元素，新添加元素的上一个prev就是last,新添加的元素就是last.
	 */
	public void add(T elments) {
		Node<T> node = new Node<T>(elments);// 创建节点对象，封装要添加的元素。进行赋值。
		// 判断第一个元素是否为空，
		if (first == null) {// 为空
			first = node;// 这个元素就是第一个元素
			last = node;// 也是最后一个元素
			// first.next= node;
			// last.prev = node;
		} else {
			last.next = node;// 最后一个的下一个就是node.
			node.prev = last;// node的上一个就是last
			node.next = null;// 最后一个的下一个是node
			last=node;
		}
		size++;// 元素加1.
	}
	public T get(int index) {
		return getIndex(index).elments;
		
	}
	public Node<T> getIndex(int index) {// 获取指定索引元素。
		if (index == 0) {//获取第一个
			return first;
		} else if (index == size - 1) {//获取最后一个。
			return last;
		}else if (index > size - 1) {//获取最后一个。
			throw new IndexOutOfBoundsException("index"+index+" size"+size());
		}else {
			if (index < (size() >> 1)) {// 索引小于元素个数的一般，从前面往后找。
				Node<T> node = first;
				for (int i = 0; i < index; i++) {
					node = node.next;
				}
				return node;
			} else  {// 索引大于元素个数的一般，从后面往前找。
				Node<T> node2 = last;
				for (int i = size - 1; i > index; i--) {
					node2 = node2.prev;
				}
				return node2;
			}
		}

	}
	
	/**
	 * @param index 删除元素的索引
	 * @return 删除成功或失败。
	 */
	public boolean remove(int index) {
		if(index == 0) {
			Node<T> node = getIndex(0);
			first = node.next;
			node.prev = null;
		}else if(index > 0 && index <size()-1) {
			Node<T> node = getIndex(index);//获取要删除的元素，
			Node<T> prev = node.prev;//获取要删除元素的上一个元素
			Node<T> node2 = node.next;//获取要删除元素的下一个元素。
			prev.next=node2.prev;//将要删除元素的上一个元素的next节点指向要删除元素的下一个元素。
			node2.prev=prev.next;//将要删除元素的下一个元素的prev头节点指向要删除元素的上一个元素。
//			node=null;//删除的元素为null;
		}else {
			return false;
		}
		size--;//size-1；
		return true;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		MyLinkedList<String> linkedList = new MyLinkedList<String>();
//		linkedList.add("0");
//		linkedList.add("1");
//		linkedList.add("2");
//		linkedList.add("3");
//		linkedList.add("4");
//		linkedList.add("5");
//		linkedList.add("6");
//		linkedList.add("7");
//		linkedList.add("8");
//		linkedList.add("9");
//		System.out.println("size:"+linkedList.size());
//		System.out.println(linkedList.get(9));
//		System.out.println(linkedList.remove(8));
//		System.out.println(linkedList.remove(0));
//		System.out.println("size:"+linkedList.size());
//		List<String> vector= new Vector<String>();
//		Map<String, String> map = new HashMap<String, String>();
		Node node = new Node();
		int hash = Node.hash(linkedList);
		System.out.println(hash);
		
		
//		System.out.println(linkedList.get(7));

	}

}

class Node<T> {
	Node<T> prev;//上一个节点的引用
	Node<T> next;//下一个节点的引用
	T elments;//节点的值

	public Node(){
		
	}
	public Node(T elments) {//创建一个节点
		this.elments = elments;
	}
	 static final int hash(Object key) {
	        int h;
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }

}