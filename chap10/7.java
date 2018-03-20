package Entry;

class Outer {
    public void testField() {
        Inner i = new Inner();
        System.out.println(i.count);
    }
    public class Inner {
        private int count = 1;
    }
}

class Main {
    public static void main(String[] args) {
        new Outer().testField();
    }
}
