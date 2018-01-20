
class Tank {
    float size;
}

class HelloWorld {
    static void fn(Tank t, float s) {
        t.size = s;
    }
    public static void main(String[] args) {
        Tank t1 = new Tank();

        t1.size = 20;
        System.out.println("t1=" + t1.size);
        fn(t1, 17);
        System.out.println("t1=" + t1.size);
    }
}
