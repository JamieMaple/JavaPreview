class Detergent {
    public void scrub() {
        System.out.println("scrub");
    }
}

class Child extends Detergent {
    public void scrub() {
        System.out.println("Child scrub");
    }
    public void sterilize() {
        System.out.println("sterilized");
        super.scrub();
    }
}

