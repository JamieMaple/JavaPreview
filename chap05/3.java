class Dog {
    void bark(int i) {
        System.out.println("barking");
    }

    void bark(char ch) {
        System.out.println("howling");
    }
}

class Main {
    static public void main(String[] args) {
        Dog dog = new Dog();
        dog.bark(1);
        dog.bark('s');
    }
}
