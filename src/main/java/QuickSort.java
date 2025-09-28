import java.util.Random;

public class QuickSort {

    private static final Random rnd = new Random();
    private static final int CUTOFF = 16;

    public static <T extends Comparable<? super T>> void sort(T[] a, Metrics metrics) {
        shuffle(a);
        sort(a, 0, a.length - 1, metrics);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi, Metrics metrics) {
        metrics.enterRecursion();
        try {
            while (lo < hi) {
                int len = hi - lo + 1;
                if (len <= CUTOFF) {
                    insertionSort(a, lo, hi, metrics);
                    break;
                }

                int p = partition(a, lo, hi, metrics);

                if (p - lo < hi - p) {
                    sort(a, lo, p - 1, metrics);
                    lo = p + 1;
                } else {
                    sort(a, p + 1, hi, metrics);
                    hi = p - 1;
                }
            }
        } finally {
            metrics.exitRecursion();
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi, Metrics metrics) {
        int pivotIndex = lo + rnd.nextInt(hi - lo + 1);
        T pivot = a[pivotIndex];
        swap(a, pivotIndex, hi, metrics);

        int i = lo;
        for (int j = lo; j < hi; j++) {
            metrics.incComparisons();
            if (a[j].compareTo(pivot) < 0) {
                swap(a, i++, j, metrics);
            }
        }
        swap(a, i, hi, metrics);
        return i;
    }

    private static <T
