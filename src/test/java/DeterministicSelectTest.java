import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    void testSmallArray() {
        Integer[] arr = {7, 2, 9, 4, 1};
        Metrics metrics = new Metrics();
        int k = 2;
        Integer result = DeterministicSelect.select(arr, k, metrics);

        Arrays.sort(arr);
        assertEquals(arr[k], result);
    }

    @Test
    void testRandomArrayManyKs() {
        Random rnd = new Random(42);
        Integer[] arr = rnd.ints(50, 0, 1000).boxed().toArray(Integer[]::new);
        Integer[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        for (int k = 0; k < arr.length; k++) {
            Metrics metrics = new Metrics();
            Integer result = DeterministicSelect.select(Arrays.copyOf(arr, arr.length), k, metrics);
            assertEquals(sorted[k], result);
        }
    }

    @Test
    void testSingleElement() {
        Integer[] arr = {42};
        Metrics metrics = new Metrics();
        assertEquals(42, DeterministicSelect.select(arr, 0, metrics));
    }
}