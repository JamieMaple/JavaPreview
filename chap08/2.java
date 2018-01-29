class Parent {
    public void methodA() {
        System.out.println("Parent.methodA()");
        methodB();
    }
    public void methodB() {
        System.out.println("Parent.methodB()");
    }
}

class Child extends Parent {
    @Override public void methodB() {
        System.out.println("Child.methodB()");
    }
}

class Main {
    public static void main(String[] args) {
        new Child().methodA();
    }
}

