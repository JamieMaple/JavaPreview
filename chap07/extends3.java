class A {
    A() {
        System.out.println("A");
    }
}

class B {
    B() {
        System.out.println("B");
    }
}

class C extends A {
    private B testB = new B();
}

class Main {
    static public void main(String[] args) {
        new C();
    }
}
