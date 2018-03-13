package entry;

interface  Selector {
    boolean end();
    Object current();
    void next();
}

class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if (next <= items.length) {
            items[next++] = x;
        }
    }
    private class SequnceSelector implements Selector {
        private int i = 0;
        public boolean end() {
            return items.length == i;
        }
        public Object current() {
            return items[i];
        }
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }
    public Selector selector() {
        return new SequnceSelector();
    }
}

class A {
    private String name = "";
    A(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(new String("object" + i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + "");
            selector.next();
        }
    }
}

