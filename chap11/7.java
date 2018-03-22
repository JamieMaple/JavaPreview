package entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Rodent {
	protected void print(String s) {
		System.out.println(s);
	}
	protected void run() {
		print("Rodent.run");
	}
	protected void eat() {
		print("Rodent.eat");
	}
	protected void sleep() {
		print("Rodent.sleep");
	}
}

class Mouse extends Rodent {
	protected void run() {
		print("Mouse.run");
	}
	protected void eat() {
		print("Mouse.eat");
	}
	protected void sleep() {
		print("Mouse.sleep");
	}
}

class Gerbil extends Rodent {
	protected void run() {
		print("Gerbil.run");
	}
	protected void eat() {
		print("Gerbil.eat");
	}
	protected void sleep() {
		print("Gerbil.sleep");
	}
}

class Hamster extends Rodent {
	protected void run() {
		print("Hamster.run");
	}
	protected void eat() {
		print("Hamster.eat");
	}
	protected void sleep() {
		print("Hamster.sleep");
	}}

class Main {
	public static void main(String[] args) {
		ArrayList<Rodent> rodents = new ArrayList<Rodent>(
			Arrays.asList(new Rodent(), new Mouse(), new Gerbil(), new Hamster())
		);
		Iterator<Rodent> it = rodents.iterator();
		while (it.hasNext()) {
			Rodent rodent = it.next();
			rodent.eat();
			rodent.run();
			rodent.sleep();
		}
	}
}
