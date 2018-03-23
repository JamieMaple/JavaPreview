package entry;

import java.util.*;

class Main {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		List<String> words = new ArrayList<String>();
		
		Collections.addAll(words,
			"Hello", "World", "I", "am", "Maple",
			"Hello", "World", "You", "say", "love"
		);
		Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
		
		for (String s : words) {
			Integer count = m.get(s);
			m.put(s, count == null ? 1 : count + 1);
		}
		
		System.out.println(m);
	}
}
