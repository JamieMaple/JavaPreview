package Entry;

class Outer {
    private int count;
    protected void methodA() {
        System.out.println("Private");
    }
    public void getCount() {
        System.out.println(count);
    }
    public class Inner {
        public void method() {
            methodA();
        }
        public boolean changeCount(int count) {
            Outer.this.count = count;
            return true;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner i = o.new Inner();
        i.method();
        o.getCount();
        i.changeCount(32);
        o.getCount();
    }
}

