abstract class Base {
    public abstract void print();
}

class A extends Base {
    public void print() {
        System.out.println("Hello A");
    }
}

class Main {
    public static void show(Base base) {
        base.print();
    }
    public static void main(String[] args) {
        Base base = new A();
        show(base);
    }
}

