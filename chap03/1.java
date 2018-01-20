class Tank {
    float size;
}

class HelloWorld {
    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.size = 22;
        t2.size = 17;

        System.out.println("t1=" + t1.size + ", t2=" + t2.size);
        t1 = t2;
        t2.size = 35;
        System.out.println("t1=" + t1.size + ", t2=" + t2.size);
    }
}
