package entry;

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

interface CanClimb {
    void climb();
}

class ActionCharactor {
    public void fight() {}
}

class Hero extends ActionCharactor implements CanFight, CanSwim, CanFly, CanClimb {
    public void swim() {}
    public void fly() {}
    public void climb() {}
}

class Main {
    public static void main(String[] args) {

    }
}

