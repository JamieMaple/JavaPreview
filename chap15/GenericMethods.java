package entry;

class Main {
	public static <T, U, I>void getName(T t, U u, I i) {
		System.out.println(t.getClass().getName());
		System.out.println(u.getClass().getName());
		System.out.println(i.getClass().getName());
	}
	public static void main(String[] args) {
		getName("string", 12, false);
	}
}

