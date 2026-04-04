package ru.yanes.dataStructures;

public class BST {
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		tree.insert(11);
		tree.insert(1);

		System.out.println(tree.find(tree.root,6));
		System.out.println(tree.find(tree.root,7));
		System.out.println(tree.find(tree.root,8));
		System.out.println(tree.find(tree.root,1));

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
				Node temp = this.root;
				while (temp != null) {
					if (temp.data < data) {
						if (temp.hasRight()) {
							temp = temp.right;
						} else {
							temp.right = new Node(data);
						}
					} else if (temp.data > data) {
						if  (temp.hasLeft()) {
							temp = temp.left;
						} else  {
							temp.left = new Node(data);
						}
					} else {
						return;
					}
				}
			}
		}

		public boolean find(Node current, int value) {
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
			String result = "";
			Node current = this.root;

			return toString(current, result);
		}

		private String toString(Node current, String result) {
			while (current.hasLeft()) {
				current = current.left;
			}
			return result;
		}
	}
}
