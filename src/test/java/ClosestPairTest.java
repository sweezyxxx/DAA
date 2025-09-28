import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {

    @Test
    void testSimpleCase() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(3,4),
                new ClosestPair.Point(7,7),
                new ClosestPair.Point(1,1)
        };
        Metrics metrics = new Metrics();
        double d = ClosestPair.closest(pts, metrics);
        assertEquals(Math.sqrt(2), d, 1e-9);
    }

    @Test
    void testRandomSmall() {
        Random rnd = new Random(42);
        ClosestPair.Point[] pts = new ClosestPair.Point[50];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new ClosestPair.Point(rnd.nextDouble()*100, rnd.nextDouble()*100);
        }
        Metrics m1 = new Metrics();
        Metrics m2 = new Metrics();
        double d1 = ClosestPair.closest(pts, m1);
        double d2 = ClosestPair.bruteForce(pts, m2);
        assertEquals(d2, d1, 1e-9);
    }

    @Test
    void testSinglePair() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(1,0)
        };
        Metrics metrics = new Metrics();
        assertEquals(1.0, ClosestPair.closest(pts, metrics), 1e-9);
    }
}
