class Dog {
    String name;
    {
        name = "Kevin";
    }
    void printName() {
        System.out.println(name);
    }
}

class Main {
    static public void main(String[] args) {
        new Dog().printName();
    }
}
