package entry;

import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class A {
	private String name;
	public A(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}

class Main {
	public static void display(Collection collection) {
		Iterator it = collection.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Set<A> aSet = new HashSet<A>(Arrays.asList(new A("Jamie"), new A("Maple"), new A("Maple")));
		List<A> aList = new LinkedList<A>(Arrays.asList(new A("Maple"), new A("Maple"), new A("Jamie")));
		display(aSet);
		display(aList);
	}
}
