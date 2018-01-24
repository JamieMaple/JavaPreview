class TestClass {
    TestClass(String s) {
        System.out.println(s);
    }
}

class Main {
    static public void main(String[] args) {
        TestClass[] testClasses = new TestClass[]{
                new TestClass("sdf"),
                new TestClass("hello"),
                new TestClass("world"),
        };
    }
}
