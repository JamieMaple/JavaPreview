interface Rodent {
    void eat();
    void run();
}

class Mouse implements Rodent {
    public void eat() {
        System.out.println("mouse eat");
    }
    public void run() {
        System.out.println("mouse run");
    }
}

class Gerbil implements Rodent {
    public void eat() {
        System.out.println("gerbil eat");
    }
    public void run() {
        System.out.println("gerbil run");
    }
}

class Hamster implements Rodent {
    public void eat() {
        System.out.println("hamster eat");
    }
    public void run() {
        System.out.println("hamster run");
    }
}

