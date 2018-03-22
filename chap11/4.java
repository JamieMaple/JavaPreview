package entry;

import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

class Main {
	public static void display(Iterator<String> it) {
		while (it.hasNext()) {
			String s = it.next();
			System.out.println("String : " + s);
		}
	}
	public static void main(String[] args) {
		List<String> arr = Arrays.asList("str1", "str2", "str3");
		display(arr.iterator());
	}
}
