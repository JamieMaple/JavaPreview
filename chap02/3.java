class StaticTest {
    static int i = 0;
}

class Incrementable {
    static void increment() {
        StaticTest.i++;
    }
}

class HelloWorld {
    public static void main(String[] args) {
        System.out.print(StaticTest.i);
        Incrementable.increment();
        System.out.print(StaticTest.i);
    }
}
