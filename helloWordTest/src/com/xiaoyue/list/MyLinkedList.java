package com.xiaoyue.list;

public class MyLinkedList<T> {
	
	private Node<T> first;//第一个节点
	private Node<T> last;//最会一个节点
	private int size;//节点个数
	
	/**添加元素
	 * @param element
	 * [first,b,c,d,e,last,newNode]
	 */
	public void add(T element) {
		Node<T> newNode = new Node<T>(element); 
		//第一个节点为空
		if(first == null) { 
			first = newNode;
			last = newNode;
//			size++;
		}else {
			last.next = newNode;
			newNode.prev=last;
			last = newNode;
		}
		size++;
	}
	
	/**
	 * @param index 指定的索引。
	 * @return 返回元素
	 */
	public T get(int index){
		Node<T> getNode = getIndex(index);
		return getNode.element;
	}
	

	/**
	 * @param index 
	 * @return 指定索引的元素。
	 * 遍历链表中的元素。
	 * 链表长度为size,
	 * 如果index小于size/2,那么从前往后找。
	 * 如果index大于size/2,那么就从后往前找。
	 */
	public Node getIndex(int index){
		//定义取得的元素；
		Node getNode = null;
		if(index == 0) {
			getNode=first;
			return getNode;
		}else if(index == size-1) {
			getNode=last;
			return getNode;
		}else if(index < 0 || index > size-1) {	//判断指定索引。
			throw new IndexOutOfBoundsException("index="+index+",size="+size);
		}
		
		//以上判断说明索引合法。
		if(index < size>>1) {//如果index小于size/2,那么从前往后找。
			getNode = first;
			for (int i = 0; i <= index; i++) {
				getNode=getNode.next;
			}
		}else {
			getNode = last;// 如果index大于size/2,那么就从后往前找。
			for (int i = size-1; i > index; i--) {
				getNode=getNode.prev;
			}
		}
		return getNode;//返回元素
	}
	
	
	public boolean remove(int index) {
		boolean remove = false;
		if(index < 0 || index > size-1) {	//判断指定索引是否合法。
			throw new IndexOutOfBoundsException("index="+index+",size="+size);
		}else {
			Node<T> removeNode = getIndex(index);
			if(removeNode != null) {
//				Node<T> upNode = removeNode.prev;
//				Node<T> downNode = removeNode.next;
				
//			System.out.println(removeNode.element);
			Node<T> removeNodePrev = removeNode.prev;//要删除元素的上一个
			Node<T> removeNodeNext = removeNode.next;//要删除元素的下一个
			removeNodeNext = removeNodePrev.next;//removeNodePrev的下一个指向removeNodeNext
			removeNodePrev = removeNodeNext.prev;//removeNodeNext的上一个指向removeNodePrev
//			removeNode = null;
			remove = true;
			size--;
			}
			
		}
		return remove;
		
	}

	public static void main(String[] args) {
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.add("d");
		myLinkedList.add("e");
		myLinkedList.add("f");
		myLinkedList.add("g");
//		System.out.println("size:"+myLinkedList.size);
//		System.out.println(myLinkedList.get(0));
//		System.out.println(myLinkedList.get(3));
//		System.out.println(myLinkedList.remove(3));
//		System.out.println(myLinkedList.get(3));
//		System.out.println("size:"+myLinkedList.size);
		System.out.println(myLinkedList.remove(0));
		System.out.println("size:"+myLinkedList.size);
		
	}

}
class Node<T>{
	Node<T> prev;
	Node<T> next;
	T element;
	public Node(T element) {
		this.element = element;
	}
	
	
	
	
}