import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        String output = "results.csv";
        try (FileWriter writer = new FileWriter(output)) {
            writer.write("Algorithm,Size,Comparisons,Swaps,Allocations,MaxDepth,TimeMs\n");

            runSort("MergeSort", writer);
            runSort("QuickSort", writer);
            runSelect("DeterministicSelect", writer);
            runClosest("ClosestPair", writer);
        }
        System.out.println("Results saved to " + output);
    }

    private static void runSort(String algo, FileWriter writer) throws IOException {
        Random rnd = new Random(42);
        for (int n : new int[]{100, 1000, 5000}) {
            Integer[] arr = rnd.ints(n, 0, 10000).boxed().toArray(Integer[]::new);
            Integer[] copy = Arrays.copyOf(arr, arr.length);

            Metrics metrics = new Metrics();
            long start = System.currentTimeMillis();

            switch (algo) {
                case "MergeSort" -> MergeSort.sort(copy, metrics);
                case "QuickSort" -> QuickSort.sort(copy, metrics);
            }

            long elapsed = System.currentTimeMillis() - start;
            writer.write(String.format("%s,%d,%d,%d,%d,%d,%d\n",
                    algo, n,
                    metrics.getComparisons(),
                    metrics.getSwaps(),
                    metrics.getAllocations(),
                    metrics.getMaxDepth(),
                    elapsed));
        }
    }

    private static void runSelect(String algo, FileWriter writer) throws IOException {
        Random rnd = new Random(99);
        for (int n : new int[]{100, 1000}) {
            Integer[] arr = rnd.ints(n, 0, 10000).boxed().toArray(Integer[]::new);
            int k = n / 2;

            Metrics metrics = new Metrics();
            long start = System.currentTimeMillis();

            Integer result = DeterministicSelect.select(Arrays.copyOf(arr, arr.length), k, metrics);

            long elapsed = System.currentTimeMillis() - start;
            writer.write(String.format("%s,%d,%d,%d,%d,%d,%d\n",
                    algo, n,
                    metrics.getComparisons(),
                    metrics.getSwaps(),
                    metrics.getAllocations(),
                    metrics.getMaxDepth(),
                    elapsed));
        }
    }

    private static void runClosest(String algo, FileWriter writer) throws IOException {
        Random rnd = new Random(77);
        for (int n : new int[]{100, 1000}) {
            ClosestPair.Point[] pts = new ClosestPair.Point[n];
            for (int i = 0; i < n; i++) {
                pts[i] = new ClosestPair.Point(rnd.nextDouble() * 1000, rnd.nextDouble() * 1000);
            }

            Metrics metrics = new Metrics();
            long start = System.currentTimeMillis();

            double result = ClosestPair.closest(pts, metrics);

            long elapsed = System.currentTimeMillis() - start;
            writer.write(String.format("%s,%d,%d,%d,%d,%d,%d\n",
                    algo, n,
                    metrics.getComparisons(),
                    metrics.getSwaps(),
                    metrics.getAllocations(),
                    metrics.getMaxDepth(),
                    elapsed));
        }
    }
}