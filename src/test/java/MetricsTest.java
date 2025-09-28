import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetricsTest {

    @Test
    void testCounters() {
        Metrics m = new Metrics();
        m.incComparisons();
        m.incSwaps();
        m.incAllocations();

        assertEquals(1, m.getComparisons());
        assertEquals(1, m.getSwaps());
        assertEquals(1, m.getAllocations());
    }

    @Test
    void testRecursionDepth() {
        Metrics m = new Metrics();
        m.enterRecursion();
        m.enterRecursion();
        m.exitRecursion();
        assertEquals(2, m.getMaxDepth());
    }
}
