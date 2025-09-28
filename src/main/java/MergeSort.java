public class MergeSort {

    private static final int CUTOFF = 16;

    public static <T extends Comparable<? super T>> void sort(T[] a, Metrics metrics) {
        @SuppressWarnings("unchecked")
        T[] buf = (T[]) new Comparable[a.length];
        metrics.incAllocations();
        sort(a, buf, 0, a.length, metrics);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, T[] buf, int lo, int hi, Metrics metrics) {
        metrics.enterRecursion();
        try {
            int len = hi - lo;
            if (len <= CUTOFF) {
                insertionSort(a, lo, hi, metrics);
                return;
            }

            int mid = (lo + hi) >>> 1;
            sort(a, buf, lo, mid, metrics);
            sort(a, buf, mid, hi, metrics);

            metrics.incComparisons();
            if (a[mid - 1].compareTo(a[mid]) <= 0) return;

            merge(a, buf, lo, mid, hi, metrics);
        } finally {
            metrics.exitRecursion();
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] buf, int lo, int mid, int hi, Metrics metrics) {
        System.arraycopy(a, lo, buf, lo, hi - lo);
        int i = lo, j = mid, k = lo;

        while (i < mid && j < hi) {
            metrics.incComparisons();
            if (buf[i].compareTo(buf[j]) <= 0) {
                a[k++] = buf[i++];
            } else {
                a[k++] = buf[j++];
            }
            metrics.incSwaps();
        }

        while (i < mid) {
            a[k++] = buf[i++];
            metrics.incSwaps();
        }
        while (j < hi) {
            a[k++] = buf[j++];
            metrics.incSwaps();
        }
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int lo, int hi, Metrics metrics) {
        for (int i = lo + 1; i < hi; i++) {
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
}