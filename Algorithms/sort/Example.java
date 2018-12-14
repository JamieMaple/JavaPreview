import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public class Example {
    public static void main(String[] args) {
        //String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        //Selection.sort(a);
        //Insertion.sort(a);
        //assert isSorted(a);
        //show(a);
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = SortCompare.timeRandomInput(alg1, N, T);
        double t2 = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }

    private static void show(Comparable[] arr) {
        for (Comparable item : arr) {
            System.out.print(item + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (SortBase.less(arr[i], arr[i - 1])) {
                return false;
            }
        }

        return true;
    }
}

class SortCompare {
    public static double time(String alg, Comparable[] arr) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(arr);
        } else if (alg.equals("Selection")) {
            Selection.sort(arr);
        } else if (alg.equals("Shell")) {
            Shell.sort(arr);
        } else {
            return 0;
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] arr = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                arr[j] = StdRandom.uniform();
            }
            total += time(alg, arr);
        }
        return total;
    }
}

class SortBase {
    public static void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}

// O(n^2), swap: n
class Selection extends SortBase {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            exch(arr, i, minIndex);
        }
    }
}

// N-1 <= O <= O(n^2/2), 0 <= swap <= O(n^2/2)
class Insertion extends SortBase {
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j-1])) {
                    exch(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}

class Shell extends SortBase {
    public static void sort(Comparable[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N/3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j-= h)  {
                    if (less(arr[j], arr[j-h])) {
                        exch(arr, j, j-h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }
}

