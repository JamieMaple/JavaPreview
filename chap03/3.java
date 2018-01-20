class Speed {
    float distance;
    float time;
    public float getSpeed() {
        return this.distance / this.time;
    }
}

class HelloWorld {
    public static void main(String[] args) {
        Speed s = new Speed();
        s.distance = 100;
        s.time = 1000;
        System.out.print(s.getSpeed());
    }
}
