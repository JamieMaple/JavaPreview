class Rock {
    String name;

    Rock(String s) {
        this.name = s;
        System.out.println(s + " rock constructed");
    }

    Rock() {
        System.out.println("constructed");
    }
}

class Main {
    static public void main(String[] args) {
        Rock rock = new Rock("wowo");
        Rock rock1 = new Rock();
    }
}

