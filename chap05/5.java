class Counter {
    int i;

    Counter() {
        this(1);
        i = 0;
        System.out.println("inited");
    }

    Counter(int i) {
        System.out.println("Other constructor");
    }

    Counter increment() {
        i++;
        return this;
    }

    void print() {
        System.out.println("i = " + i);
    }
}

class Main {
    static public void main(String[] args) {
        Counter counter = new Counter();
        counter.increment().increment().increment().print();
    }
}

