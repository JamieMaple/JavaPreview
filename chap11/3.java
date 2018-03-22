package entry;

import java.util.*;

class Generator {
	private ArrayList<String> movies;
	private int current = 0;
	public Generator(ArrayList<String> movies) {
		this.movies = movies;
	}
	public String next() {
		if (current >= movies.size()) {
			current = 0;
		}
		return movies.get(current++);
	}
}

class Main {
	public static void print(Object o) {
		System.out.println(o);
	}
	public  static void main(String[] args) {
		ArrayList<String> collection = new ArrayList<String>();
		Collections.addAll(collection, "Snow White", "Star Wars", "Great War");
		Generator moviesGen = new Generator(collection);
		String[] arr = new String[10];
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		HashSet<String> hashSet = new HashSet<String>();
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		TreeSet<String> treeSet = new TreeSet<String>();
		
		for (int i = 0; i < 10; i++) {
			String next = moviesGen.next();
			arr[i] = next;
			arrayList.add(next);
			linkedList.add(next);
			hashSet.add(next);
			linkedHashSet.add(next);
			treeSet.add(next);
		}
		print(arr);
		print(arrayList);
		print(linkedList);
		print(hashSet);
		print(linkedHashSet);
		print(treeSet);
	}
}
