class Main {
    public static void main(String[] args) {
        int a = 8 + 2 + 4;
        String s = "";

        for (int temp = a; temp > 0; temp /= 2) {
            s = (temp % 2) + s;
        }

        System.out.print(s);
    }
}
