package entry;

import java.util.PriorityQueue;
import java.util.Random;

class Main {
	public static void main(String[] args) {
		Random rand = new Random(30);
		PriorityQueue<Double> queue = new PriorityQueue<Double>();
		
		for (int i = 0; i < 10; i++) {
			queue.offer(rand.nextDouble());
		}
		System.out.println(queue);
		
		for (int i = 0; i < 10; i++) {
			System.out.print(queue.remove() + " ");
		}
	}
}
