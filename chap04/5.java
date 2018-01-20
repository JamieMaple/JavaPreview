class Main {
    static int testval(int target, int begin, int end) {
        if (target>= begin && target <= end)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        System.out.print(testval(10, 2, 30));
    }
}
