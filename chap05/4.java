class Counter {
    int i;
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

