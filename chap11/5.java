package entry;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Gerbil {
	int gerbilNumber;
	public Gerbil(int gerbilNumber) {
		this.gerbilNumber = gerbilNumber;
	}
	public void hop() {
		System.out.println("gerbil " + gerbilNumber + " hop!");
	}
}

class Main {
	public static void display(Iterator<Gerbil> it) {
		while (it.hasNext()) {
			Gerbil gerbil = it.next();
			gerbil.hop();
		}
	}
	public static void main(String[] args) {
		List<Gerbil> gerbilList = new ArrayList<Gerbil>();
		Collections.addAll(gerbilList, new Gerbil(1), new Gerbil(10), new Gerbil(100));
		display(gerbilList.iterator());
	}
}
