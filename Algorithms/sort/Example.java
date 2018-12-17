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
        } else if (alg.equals("Merge")) {
            Merge.sort(arr);
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
                } }
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

    public static void sortWithSentinel(Comparable[] arr) {
        //for (int i = 1; i < arr.length - 1; i++) {
            //if (less(arr[i], arr[i-1])) {
                //exch(arr, i, i-1);
            //}
        //}
        // 得出最小的数字
        int exchanges = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (less(arr[i], arr[i-1])) {
                exch(arr, i, i-1);
                exchanges++;
            }
        }
        if (exchanges == 0) {
            return;
        }

        for (int i = 2; i < arr.length; i++) {
            Comparable v = arr[i];
            int j = i;
            while (less(v, arr[j-1])) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = v;
        }
    }
}

class Shell extends SortBase {
    public static void sort(Comparable[] arr) {
        int N = arr.length;
        int h = 1;

        //int hLength = 0;
        //while (h < N/3) {
            //hLength++;
            //h = h * 3 + 1;
        //}
        //int j = 1;
        //int[] a = new int[hLength];
        //for (int i = 0; i < hLength; i++) {
            //a[i] = j; 
            //j = j * 3 + 1;
        //}

        while (h < N/3) {
            h = h * 3 + 1;
        }
        
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(arr[j], arr[j-h])) {
                        exch(arr, j, j-h);
                    } else {
                        break;
                    }
                }
            }
            h /= 3;
        }
    }
}

/*
 * 一共是 N 个数，即长度为 N。
 * 一共有 n 层，n = lgN
 * 设当前层为第 k 层(k = 0, 1, 2 ...)
 * 当前层有 2^k 个子数组，每个数组第长度为 2^(n-k) 个数
 * 所以层需要比较 2^k * 2^(n-k) = 2^n 次
 * 一共 n 层，所以一共需要比较 n * 2^n 次
 * 换算一下就是 lgN * N
 * 
 */

class Merge extends SortBase {
    private static Comparable[] tempArr;

    public static void sort(Comparable[] arr) {
        tempArr = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = (hi + lo) / 2;

        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);

        merge(arr, lo, mid, hi);
    }

    public static void sortToTop(Comparable[] arr) {
        tempArr = new Comparable[arr.length];
        for (int sz = 1; sz < arr.length; sz = sz + sz) {
            for (int lo = 0; lo < arr.length-sz; lo += sz + sz) {
                merge(arr, lo, lo+sz-1, Math.min(lo+sz+sz-1, arr.length-1));
            }
        }
    }

    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        // copy
        for (int k = lo; k <= hi; k++) {
            tempArr[k] = arr[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = tempArr[j++];
                continue;
            }

            if (j > hi) {
                arr[k] = tempArr[i++];
                continue;
            }

            if (less(tempArr[i], tempArr[j])) {
                arr[k] = tempArr[i++];
            } else {
                arr[k] = tempArr[j++];
            }
        }
    }
}

class Quick extends SortBase {
    public static void sort(Comparable[] arr) {
    }
}

