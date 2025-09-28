import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    void testSmallArray() {
        Integer[] arr = {5, 3, 8, 1, 2};
        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    void testRandomArray() {
        Random rnd = new Random(42);
        Integer[] arr = rnd.ints(1000, 0, 10000).boxed().toArray(Integer[]::new);
        Integer[] expected = Arrays.copyOf(arr, arr.length);

        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);
        Arrays.sort(expected);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySorted() {
        Integer[] arr = {1, 2, 3, 4, 5};
        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }
}