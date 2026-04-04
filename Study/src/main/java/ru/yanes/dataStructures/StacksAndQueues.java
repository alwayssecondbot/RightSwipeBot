package ru.yanes.dataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StacksAndQueues {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();


		stack.push("a");
		stack.push("b");
		stack.push("c");

		String last = stack.pop();

		Queue<String> queue = new LinkedList<>();
		queue.add("a");
		queue.add("b");
		queue.offer("c");
		String first = queue.poll();

		System.out.println(first);
		System.out.println(last);

	}
}
