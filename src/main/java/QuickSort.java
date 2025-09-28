import java.util.Random;

public class QuickSort {

    private static final Random rnd = new Random();
    private static final int CUTOFF = 16;

    public static <T extends Comparable<? super T>> void sort(T[] a, Metrics metrics) {
        shuffle(a); // чтобы избежать худшего случая
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

                // рекурсия сначала на меньшей половине
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

    private static <T> void swap(T[] a, int i, int j, Metrics metrics) {
        if (i != j) {
            T tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            metrics.incSwaps();
        }
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int lo, int hi, Metrics metrics) {
        for (int i = lo + 1; i <= hi; i++) {
            T key = a[i];
            int j = i - 1;
            while (j >= lo) {
                metrics.incComparisons();
                if (a[j].compareTo(key) <= 0) break;
                a[j + 1] = a[j];
                metrics.incSwaps();
                j--;
            }
            a[j + 1] = key;
            metrics.incSwaps();
        }
    }

    private static <T> void shuffle(T[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = rnd.nextInt(i + 1);
            T tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
