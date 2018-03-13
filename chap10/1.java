class Outer {
    class Inner {
        Inner() {
            System.out.println("inner");
        }
    }
    public Inner getInnter() {
        return new Inner();
    }
}

class Main {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner inner = o.getInnter();
    }
}

