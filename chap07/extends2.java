class GrandParent {
    GrandParent() {
        System.out.println("Grand");
    }
}

class Parent extends GrandParent {
    Parent() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child");
    }
}

class Main {
    static public void main(String[] args) {
        new Child();
    }
}

