class Main {
    static void Fibernacci(int num) {
        int prev = 0, now = 1;
        for (int i = 0; i < num; i++) {
            int temp = now;
            System.out.println(now + "\t");
            now = now + prev;
            prev = temp;
        }
    }
    public static void main(String[] args) {
        Fibernacci(10);
    }
}
