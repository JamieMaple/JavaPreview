package entry;

interface A {
    void methodA1();
    void methodA2();
}

interface B {
    void methodB1();
    void methodB2();
}

interface C {
    void methodC1();
    void methodC2();
}

interface Out extends A, B, C {
    void method();
}

class ClassA {
    public void print(String s) {
        System.out.println(s);
    }
    public void sayHi() {
        System.out.println("Hi!");
    }
}

class ClassB extends ClassA implements Out {
    public void methodA1() {
        print("method A1");
    }
    public void methodA2() {
        print("method A2");
    }
    public void methodB1() {
        print("method B1");
    }
    public void methodB2() {
        print("method B2");
    }
    public void methodC1() {
        print("method C1");
    }
    public void methodC2() {
        print("method C2");
    }
    public void method() {
        print("method !!");
    }
}

class Main {
    static void a(A a) {
        a.methodA1();
        a.methodA2();
    }
    static void b(B b) {
        b.methodB1();
        b.methodB2();
    }
    static void c(C c) {
        c.methodC1();
        c.methodC2();
    }
    static void out(Out o) {
        o.method();
    }
    public static void main(String[] args) {
        ClassB test = new ClassB();
        a(test);
        b(test);
        c(test);
        out(test);
    }
}

