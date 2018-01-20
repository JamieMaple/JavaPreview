package quickstart;

import java.util.Arrays;

// functional way
class Main {
    static Integer[] convert(String s) {
        int length = s.length();
        Integer arrInt[] = new Integer[length];
        for (int i = 0; i < length; i++) {
            arrInt[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        return arrInt;
    }

    static Integer[] sort(Integer[] intArr) {
        Integer copiedArr[] = intArr.clone();

        Arrays.sort(copiedArr);

        return copiedArr;
    }

    static String arrayToString(Integer[] intArr) {
        String s = "";

        for (int num: intArr) {
            s += num;
        }

        return s;
    }

    static String getToSortedNumString(int num) {
        return arrayToString(sort(convert("" + num)));
    }

    static String getToSortedNumString(String s) {
        return arrayToString(sort(convert(s)));
    }

    static void vampireNum() {
        System.out.println("吸血鬼数字以下：");
        for (int i = 10; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int mul = i * j;
                if (mul > 1000) {
                    String sortedMul = getToSortedNumString(mul);
                    String sortedCmp = getToSortedNumString("" + i + j);
                    if (sortedMul.equals(sortedCmp)) {
                        System.out.println(i + " * " + j + " = " + mul);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        vampireNum();
    }
}

