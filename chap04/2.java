import java.util.Random;

class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        int bound = 1000;

        for (int now = rand.nextInt(bound), i = 0; i < 25; i++) {
            int next = rand.nextInt(bound);

            if (next > now) {
                System.out.println(next + " > " + now);
            } else if (next == now) {
                System.out.println(next + " = " + now);
            } else {
                System.out.println(next + " < " + now);
            }

            now = next;
        }
    }
}
