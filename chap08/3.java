class Parent {
    private void methodA() {
        System.out.println("Parent.methodA()");
    }
    public void methodB() {
        System.out.println("Parent.methodB()");
    }
    static void methodC() {
        Parent son = new Child();
        son.methodA();
    }
}

class Child extends Parent {
    public void methodA() {
        System.out.println("Child.methodA()");
    }
    public void methodB() {
        System.out.println("Child.methodB()");
    }
}

class Main {
    public static void main(String[] args) {
        Parent.methodC();
    }
}

