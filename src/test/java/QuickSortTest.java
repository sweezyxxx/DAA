import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    void testSmallArray() {
        Integer[] arr = {5, 1, 4, 2, 8};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new Integer[]{1, 2, 4, 5, 8}, arr);
    }

    @Test
    void testRandomArray() {
        Random rnd = new Random(123);
        Integer[] arr = rnd.ints(1000, 0, 10000).boxed().toArray(Integer[]::new);
        Integer[] expected = Arrays.copyOf(arr, arr.length);

        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        Arrays.sort(expected);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testRecursionDepthBound() {
        int n = 1 << 12;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = n - i; // худший случай

        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);

        int depth = metrics.getMaxDepth();
        int bound = 2 * (int) (Math.log(n) / Math.log(2)) + 20;
        assertTrue(depth <= bound, "Recursion depth too high: " + depth);
    }
}
