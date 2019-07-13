package com.xiaoyue.mybineryTree;


public class BinaryTreeTest {
	public static void main(String[] args) {
//		Node node4 = new Node(4,null,null);
//		Node node5 = new Node(5,null,null);
//		Node node3 = new Node(3,null,null);
//		Node node6 = new Node(6,null,node3);
//		Node node7 = new Node(7,node4,node5);
//		Node node8 = new Node(8,null,null);
//		Node node2 = new Node(2,node8,node6);
//		Node node1 = new Node(1,node7,node2);
		
		
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, node5);
		
		Node node3 = new Node(3, null, null);
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, null, node7);
		
		Node node2 = new Node(2, node3, node6);
		
		Node node1 = new Node(1,node4,node2);
		LinkedBineryTree bineryTree = new LinkedBineryTree(node1);
//		LinkedBineryTree bineryTree = new LinkedBineryTree();
//		System.out.println(bineryTree.isEmpty());
//		bineryTree.preOrderTraverses();
//		
//		//中序输出
//		bineryTree.inOrderTraverse();
//		//后序输出
//		bineryTree.postOrderTraverse();
		bineryTree.levelOrderByStack();
		bineryTree.inOrderByStack();
	}
}
