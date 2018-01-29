class Parent {
    public void sayParamType() {
        System.out.println("parent none type");
    }
    public void sayParamType(int i) {
        System.out.println("int()");
    }
    public void sayParamType(char ch) {
        System.out.println("char()");
    }
}

class Child extends Parent {
    @Override public void sayParamType() {
        System.out.println("None type");
    }
}

class Main {
    static public void main(String[] args) {
        Child child = new Child();

        child.sayParamType();
        child.sayParamType('s');
        child.sayParamType(1);
    }
}

