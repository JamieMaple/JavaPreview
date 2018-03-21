package entry;

import java.util.ArrayList;
class Gerbil {
	private int gerbilNumber;
	Gerbil(int id) {
		gerbilNumber = id;
	}
	public void hop() {
		System.out.println("Gerbil " + gerbilNumber + " is hoping!");
	}
}

class Main {
	public static void main(String[] args) {
		ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
		for (int i = 0; i < 10; i++) {
			gerbils.add(new Gerbil(i));
		}
		for (int i = 0; i < gerbils.size(); i++) {
			gerbils.get(i).hop();
		}
	}
}
