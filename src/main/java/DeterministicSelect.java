import java.util.Arrays;

public class DeterministicSelect {

    public static <T extends Comparable<? super T>> T select(T[] a, int k, Metrics metrics) {
        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException("k out of range");
        }
        return select(a, 0, a.length - 1, k, metrics);
    }

    private static <T extends Comparable<? super T>> T select(T[] a, int lo, int hi, int k, Metrics metrics) {
        while (true) {
            if (lo == hi) return a[lo];

            int pivotIndex = pivot(a, lo, hi, metrics);
            int p = partition(a, lo, hi, pivotIndex, metrics);

            if (k == p) {
                return a[k];
            } else if (k < p) {
                hi = p - 1;
            } else {
                lo = p + 1;
            }
        }
    }

    private static <T extends Comparable<? super T>> int pivot(T[] a, int lo, int hi, Metrics metrics) {
        int n = hi - lo + 1;
        if (n <= 5) {
            Arrays.sort(a, lo, hi + 1);
            return lo + n / 2;
        }

        int numMedians = 0;
        for (int i = lo; i <= hi; i += 5) {
            int subHi = Math.min(i + 4, hi);
            Arrays.sort(a, i, subHi + 1);
            int medianIndex = i + (subHi - i) / 2;
            swap(a, lo + numMedians, medianIndex, metrics);
            numMedians++;
        }

        return pivot(a, lo, lo + numMedians - 1, metrics);
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi, int pivotIndex, Metrics metrics) {
        T pivotValue = a[pivotIndex];
        swap(a, pivotIndex, hi, metrics);
        int storeIndex = lo;

        for (int i = lo; i < hi; i++) {
            metrics.incComparisons();
            if (a[i].compareTo(pivotValue) < 0) {
                swap(a, storeIndex, i, metrics);
                storeIndex++;
            }
        }
        swap(a, storeIndex, hi, metrics);
        return storeIndex;
    }

    private static <T> void swap(T[] a, int i, int j, Metrics metrics) {
        if (i != j) {
            T tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            metrics.incSwaps();
        }
    }
}