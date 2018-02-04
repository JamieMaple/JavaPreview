abstract class Base {
    public abstract void print();
}

class A extends Base {
    private int data = 20;
    public void print() {
        System.out.println("data: " + data);
    }
}

class Main {
    public static void main(String[] args) {
        new A().print();
    }
}

