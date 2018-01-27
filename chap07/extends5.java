class Component1 {
    Component1() {
        System.out.println("Component1");
    }
}

class Component2 {
    Component2() {
        System.out.println("Component2");
    }
}

class Component3 {
    Component3() {
        System.out.println("Component3");
    }
}

class Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;
    Root() {
        component1 = new Component1();
        component2 = new Component2();
        component3 = new Component3();
        System.out.println("Root");
    }
}

class Stem extends Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;
    Stem() {
        component1 = new Component1();
        component2 = new Component2();
        component3 = new Component3();
        System.out.println("Stem");
    }
}

class Main {
    public static void main(String[] args) {
        new Stem();
    }
}

