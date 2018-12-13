import edu.princeton.cs.algs4.StdOut;

public class Example {
    public static void main(String[] args) {
        String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        Selection.sort(a);
        assert isSorted(a);
        show(a);
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

