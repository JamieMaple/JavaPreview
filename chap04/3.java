class Main {
    public static void main(String[] args) {
        int a = 17;
        boolean isPrime = true;

        if (a != 1) {
            for (int i = 2; i < a / 2; i++) {
                if (a % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        } else {
            isPrime = false;
        }

        if (isPrime)
            System.out.printf("%d 是素数", a);
        else
            System.out.printf("%d 不是素数", a);
    }
}
