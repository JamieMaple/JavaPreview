package entry;

import java.util.Iterator;
import java.util.Random;

class Shap {
	protected void print(String s) {
		System.out.println(s);
	}
	public void draw() {
		print("Shap draw");
	}
}
class Circle extends Shap {
	public void draw() {
		print("Circle draw");
	}
}
class Square extends Shap {
	public void draw() {
		print("Square draw");
	}
}
class Triangle extends Shap {
	public void draw() {
		print("Triangle draw");
	}
}

class RandomShapGenerator implements Iterable<Shap> {
	private Random rand = new Random();
	private Shap[] shaps;
	public RandomShapGenerator(int n) {
		shaps = new Shap[n];
		for (int i = 0; i < n; i++) {
			switch (rand.nextInt(4)) {
				case 0:
					shaps[i] = new Shap();
					break;
				case 1:
					shaps[i] = new Circle();
					break;
				case 2:
					shaps[i] = new Square();
					break;
				default:
					shaps[i] = new Triangle();
			}
		}
	}
	public Iterator<Shap> iterator() {
		return new Iterator<Shap>() {
			private int index = 0;
			public Shap next() {
				return shaps[index++];
			}
			public boolean hasNext() {
				return index < shaps.length;
			}
		};
	}
}

class Main {
	public static void main(String[] args) {
		RandomShapGenerator randGen = new RandomShapGenerator(10);
		for (Shap shap : randGen) {
			shap.draw();
		}
	}
}
