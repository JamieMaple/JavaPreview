package entry;

import java.util.*;

class IterableInteger implements Iterable<Integer> {
	private Integer[] list;
	public IterableInteger(Integer[] list) {
		this.list = list;
	}
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			public boolean hasNext() {
				return index < list.length;
			}
			public Integer next() {
				return list[index++];
			}
		};
	}
	public Iterable<Integer> reversed() {
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					private int index = list.length - 1;
					public boolean hasNext() {
						return index > -1;
					}
					
					public Integer next() {
						return list[index--];
					}
				};
			}
		};
	}
	public Iterable<Integer> randomized() {
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				List<Integer> randomList = new ArrayList<Integer>(Arrays.asList(list));
				Collections.shuffle(randomList, new Random(47));
				
				return randomList.iterator();
			}
		};
	}
}

class Main {
	public static void main(String[] args) {
		Integer[] testData = new Integer[]{1,2,3,4,5,6};
		IterableInteger ints = new IterableInteger(testData);
		
		for (Integer i : ints.randomized()) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (Integer i : ints.reversed()) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (Integer i : ints) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
