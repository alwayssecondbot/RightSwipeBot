package ru.yanes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Generics {
	public static void main(String[] args) {
		Box<String> box = new Box<>("Hello");

		System.out.println(box.getContent());

		Box rawBox = box;
		System.out.println(rawBox.getContent());

		rawBox.setContent(123);
		System.out.println(rawBox.getContent());

//		System.out.println(box.getContent()); // ClassCastException

		Box newBox = new Box(123);
		Box<String> box2 = newBox;

		System.out.println(box2.getContent()); // ClassCastException

		Box<String> newGenerationBox = new Box<>("Box3");
//		Box<Object> objectBox = newGenerationBox; // compiling error

		ListedBox<List<String>> stringBox = new ListedBox<>(List.of("1", "2", "3", "4"));

//		ListedBox<List<Integer>> integerBox = stringBox;

	}

	static class Box<T> {
		private T content;

		public Box(T content) {
			setContent(content);
		}

		public T getContent() {
			return content;
		}

		public void setContent(T content) {
			this.content = content;
		}
	}

	static class ListedBox<T extends List<?>> {
		private T content;

		public ListedBox(T content) {
			setContent(content);
		}

		public T getContent() {
			return content;
		}

		public void setContent(T content) {
			this.content = content;
		}
	}

	static class Generator<G> {
//		public G create(){
//			return new G(); // compiling error
//		}
	}
}
