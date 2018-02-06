interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    public void ride() {
        System.out.println("Cycle ride");
    }
}

class Bicycle implements Cycle {
    public void ride() {
        System.out.println("Bicycle ride");
    }
}

class Tricycle implements Cycle {
    public void ride() {
        System.out.println("Tricycle ride");
    }
}

class UnicycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Tricycle();
    }
}

class Main {
    public static void rideCycle(CycleFactory cf) {
        Cycle c = cf.getCycle();
        c.ride();
    }
    public static void main(String[] args) {
        rideCycle(new UnicycleFactory());
        rideCycle(new BicycleFactory());
        rideCycle(new TricycleFactory());
    }
}

