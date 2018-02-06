import java.nio.*;
import java.util.*;

class RandomChar {
    private char[] chars = "ABCDE".toCharArray();
    private Random random = new Random(chars.length);
    public char next() {
        return chars[random.nextInt(chars.length)];
    }
}

class RandomCharAdapter implements Readable {
    private RandomChar getter;
    private int count;
    RandomCharAdapter(RandomChar getter, int count) {
        this.getter = getter;
        this.count = count;
    }
    public int read(CharBuffer cb) {
        if (count <= 0) {
            return -1;
        }
        count -= 1;
        cb.append(getter.next());
        return 1;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomCharAdapter(new RandomChar(), 7));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}

