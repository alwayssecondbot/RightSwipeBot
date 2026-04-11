package ru.yanes.dataStructures;

public class BST {
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.insert(5);
		tree.insert(7);
		tree.insert(3);
		tree.insert(2);
		tree.insert(4);
		tree.insert(6);
		tree.insert(8);

		System.out.println(tree.root.right.right.data);
		System.out.println(tree.find(7));
		System.out.println(tree.find(8));
		System.out.println(tree.find(3));

		System.out.println(tree);
	}

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}

		public boolean hasLeft() {
			return left != null;
		}
		public boolean hasRight() {
			return right != null;
		}
	}

	static class BinaryTree {
		Node root;

		public void insert(int data) {
			if (this.root == null) {
				this.root = new Node(data);
			} else {
				this.insert(this.root, data);
			}
		}
		public void insert(Node current, int data) {
			if (current.data < data) {
				if (current.hasRight()) {
					insert(current.right, data);
				} else {
					current.right = new Node(data);
				}
			}

			if (current.data > data) {
				if  (current.hasLeft()) {
					insert(current.left, data);
				} else  {
					current.left = new Node(data);
				}
			}
		}

		public boolean find(int data) {
			return this.find(this.root, data);
		}

		private boolean find(Node current, int value) {
			if (current == null) {
				return false;
			}
			if (current.data == value) {
				return true;
			}

			return value <  current.data
					? find(current.left, value)
					: find(current.right, value);
		}

		public String toString() {
			Node current = this.root;

			return toString(current);
		}

		private String toString(Node node) {
			if (node == null) return "null";
			return node.data + " -> [" + toString(node.left) + ", " + toString(node.right) + "]";
		}

//		private String toString(Node current, String result) {
//
//			if (current.hasLeft()) {
//				result = toString(current.left, result);
//			}
//			if (current.hasRight()) {
//				result = toString(current.left, result);
//			}
//			return  current.data + result +;
//		}
	}
}
