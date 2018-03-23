package entry;

import java.util.Iterator;

class IterableClass implements Iterable<String> {
	protected String[] words = "hello world maple jamie".split(" ");
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			public boolean hasNext() {
				return index < words.length;
			}
			public String next() {
				return words[index++];
			}
		};
	}
}

class Main {
	public static void main(String[] args) {
		IterableClass iterables = new IterableClass();
		for (String s : iterables) {
			System.out.print(s + " ");
		}
	}
}
