class Rock {
    Rock(int i) {
        System.out.println("hello " + i);
    }
}

class Main {
    static public void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock(i);
        }
    }
}
