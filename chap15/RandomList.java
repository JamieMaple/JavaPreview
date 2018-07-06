package entry;

import java.util.ArrayList;
import java.util.Random;

class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random(47);
	public void add(T item) {
		storage.add(item);
	}
	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}
}

class Main {
	public static void main(String[] args) {
		RandomList<String> strList = new RandomList<String>();
		for (String str: ("hello world ni hao").split(" ")) {
			strList.add(str);
		}
		
		RandomList<Integer> numList = new RandomList<Integer>();
		for (Integer i: new Integer[] {1, 2, 3, 4, 5, 6}) {
			numList.add(i);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(strList.select() + " " + numList.select());
		}
	}
}

