package Entry;

class Outer {
    static class Inner1 {
        static class Inner2 {

        }
    }
}

class Main {
    public static void main(String[] args) {
        Outer.Inner1.Inner2 inner2 = new Outer.Inner1.Inner2();
        Outer.Inner1 inner1 = new Outer.Inner1();
        System.out.println(inner1);
    }
}

