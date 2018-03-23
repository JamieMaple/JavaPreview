package entry;

import java.util.HashMap;
import java.util.Map;

class Gerbil {
	private int gerbilNumber;
	private static int id = 0;
	public Gerbil() {
		gerbilNumber = ++id;
	}
	public void hop() {
		System.out.println("Gerbil " + gerbilNumber + " is hoping");
	}
}

class Main {
	public static void main(String[] args) {
		Map<String, Gerbil> m = new HashMap<String, Gerbil>();
		m.put("Fuzzy", new Gerbil());
		m.put("Spot", new Gerbil());
		
		m.get("Fuzzy").hop();
	}
}
