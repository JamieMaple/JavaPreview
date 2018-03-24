package entry;

class TestType {
	public String name;
	public TestType(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}

class Holder<T> {
	public T t1;
	public T t2;
	public T t3;
	public Holder(T t1, T t2, T t3) {
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
	}
	public String toString() {
		return t1.toString() + " " + t2.toString() + " " + t3.toString();
	}
}

class Main {
	public static void main(String[] args) {
		Holder<TestType> holder = new Holder<TestType>(
			new TestType("t1"), new TestType("t2"), new TestType("t3")
		);
		
		System.out.println(holder);
	}
}
