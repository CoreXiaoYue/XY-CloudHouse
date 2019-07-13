package com.xiaoyue.mybineryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 二叉树接口
 * 可以有不同的实现类，每个类可以使用不同的存储结构，比如顺序结构、链式结构
 * @author 小岳
 *
 */
public class LinkedBineryTree implements BinaryTree{
	 Node root;
	
	public LinkedBineryTree(Node root) {
		super();
		this.root = root;
	}
	

	public LinkedBineryTree() {
		super();
	}



	@Override
	public boolean isEmpty() {
		
		return root == null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public int getHeight() {
		
		return 0;
	}

	@Override
	public Node findKey(int value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void preOrderTraverses(){
		System.out.println("前序输出");
		this.preOrderTraverse();
	}

	/*  前序输出二叉树
	 *
	 */
	@Override
	public void preOrderTraverse() {
		
		if(root != null) {
			//输出根节点的值
			System.out.print(root.value+" ");
			
			//将根节点的左子树当作根节点
			LinkedBineryTree leftTree = new LinkedBineryTree(root.leftChild);
			leftTree.preOrderTraverse();
			
			//将根节点的右子树当作跟根节点
			LinkedBineryTree rightTree = new LinkedBineryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}
		
	}



	@Override
	public void inOrderTraverse() {
		System.out.println();
		System.out.println("中序输出");
		this.inOrderTraverse(root);
	}
	public void inOrderTraverse(Node root) {
		if(root != null) {
			//输出左子树的值
			this.inOrderTraverse(root.leftChild);
			//输出根的值
			System.out.print(root.value+" ");
			//输出右子树的值
			this.inOrderTraverse(root.rightChild);
		}
		
	}
	//后序输出
	@Override
	public void postOrderTraverse() {
		System.out.println();
		System.out.println("后序输出");
		this.postOrderTraverse(root);
	}


	@Override
	public void postOrderTraverse(Node node) {
		if(node != null) {
			//输出左子树的值
			this.postOrderTraverse(node.leftChild);
			//输出右子树的值
			this.postOrderTraverse(node.rightChild);
			//输出根的值
			System.out.print(node.value+" ");
		}
		

		
	}

	@Override
	public void inOrderByStack() {
		System.out.println("非递归中序遍历");
		//创建栈。
		Deque<Node> deque = new LinkedList<Node>(); 
		//将root加入栈
		Node tem = root;
		while(tem != null || !deque.isEmpty()) {
			while(tem != null) {
				deque.push(tem);
				tem = tem.leftChild;
			}
			if(!deque.isEmpty()) {
				 tem = deque.pop();
				 System.out.print(tem.value+" ");
				 tem = tem.rightChild;
			}
		}

		
	}

	@Override
	public void preOrderByStack() {
		
	}

	@Override
	public void postOrderByStack() {

		
	}
	//层次遍历
	@Override
	public void levelOrderByStack() {
		int count = 0;
		System.out.println("队列层次遍历");
		//创建队列
		Queue<Node> queue = new LinkedList<Node>(); 
		queue.add(root);//将root节点加入队列；
		while(queue.size() != 0 ) {//如果queue节点不为空
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node poll = queue.poll();//将节点弹出队列，保存到变量poll
				System.out.print(poll.value+" ");//输出弹出节点的值
				//弹出后将poll的左右节点加入队列
				if(poll.leftChild != null) {queue.add(poll.leftChild);}
				if(poll.rightChild != null) {queue.add(poll.rightChild);}
				count++;
			}
		}
		System.out.println();
		System.out.println(count);
	}

}




