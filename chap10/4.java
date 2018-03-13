package entry;

class Outer {
    private String name;
    Outer(String name) {
        this.name = name;
    }
    class Inner {
        public String toString() {
            return name;
        }
    }
    public Inner getInner() {
        return new Inner();
    }
}

class Main {
    public static void main(String[] args) {
        Outer o = new Outer("outer");
        Outer.Inner i = o.getInner();

        System.out.println(i);
    }
}

