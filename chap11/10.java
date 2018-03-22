package entry;

import java.util.LinkedList;
import java.util.ListIterator;

class Main {
	public static void main(String[] args) {
		Integer[] insertNums = new Integer[]{1, 2, 3, 4, 5};
		LinkedList<Integer> nums = new LinkedList<Integer>();
		ListIterator<Integer> it = nums.listIterator();
		for(int i = 0; i < insertNums.length; i++) {
			it.add(insertNums[i]);
		}
		System.out.println(nums);
	}
}
