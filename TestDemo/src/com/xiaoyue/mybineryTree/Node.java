package com.xiaoyue.mybineryTree;

public class Node {
	//节点的值
	Object value;
	//节点的左子树引用
	Node leftChild;
	//节点的右子树引用
	Node rightChild;
	
	public Node() {
		super();
	}

	public Node(Object value) {
		super();
		this.value = value;
	}

	public Node(Object value, Node leftChild, Node rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	
}
