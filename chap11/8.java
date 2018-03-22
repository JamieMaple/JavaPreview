package entry;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

class Main {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		Collections.addAll(list1, 1, 2, 3, 4, 5);
		Collections.addAll(list2, 9, 8, 7, 6);
		
		ListIterator<Integer> it = list1.listIterator();
		while (it.hasNext()) it.next();
		while (it.hasPrevious()) {
			list2.add(it.previous());
		}
		System.out.println(list2);
	}
}
