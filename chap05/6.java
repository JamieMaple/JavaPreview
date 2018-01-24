class Dog {
    static int i;
    static int j = 20;
    static {
        i = 2;
    }
    static void print() {
        System.out.println("i: " + i + ", j: " + j);
    }
}

class Main {
    static public void main(String[] args) {
        Dog.print();
    }
}
