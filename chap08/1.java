class Cycle {
    public void ride() {
        print("Cycle ride!");
    }
    public void print(String s) {
        System.out.println(s);
    }
}

class Unicycle extends Cycle {
    public void ride() {
        print("Unicycle ride!");
    }
}

class Bicycle extends Cycle {
    public void ride() {
        print("Bicycle ride!");
    }
}

class Tricycle extends Cycle {
    public void ride() {
        print("Tricycle ride!");
    }
}

class Main {
    public static void ride(Cycle cycle) {
        cycle.ride();
    }
    public static void main(String[] args) {
        ride(new Cycle());
        ride(new Unicycle());
        ride(new Bicycle());
        ride(new Tricycle());
    }
}

