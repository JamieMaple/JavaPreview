package entry;

import java.util.HashSet;
import java.util.Set;

class Main {
	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < 3; i++) {
			s.add(i);
		}
		for (Integer i : s) {
			System.out.println(i);
		}
	}
}
