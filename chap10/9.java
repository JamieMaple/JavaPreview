package entry;

class OuterA {
    class InnerA {
        InnerA(String name) {
            System.out.println("Hello, InnerA " + name);
        }
    }
}

class OuterB {
    class InnerB extends OuterA.InnerA {
        InnerB(String name) {
            new OuterA().super(name);
            System.out.println("Hello, InnerB");
        }
    }
}

class Main {
    public static void main(String[] args) {
        OuterB b = new OuterB();
        OuterB.InnerB ib = b.new InnerB("Kevin");
    }
}
