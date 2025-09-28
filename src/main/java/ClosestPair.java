import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static class Point {
        public final double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closest(Point[] points, Metrics metrics) {
        Point[] pts = Arrays.copyOf(points, points.length);
        Arrays.sort(pts, Comparator.comparingDouble(p -> p.x));
        return closestRec(pts, 0, pts.length, metrics);
    }

    private static double closestRec(Point[] pts, int lo, int hi, Metrics metrics) {
        int n = hi - lo;
        if (n <= 3) {
            return bruteForce(pts, lo, hi, metrics);
        }

        int mid = (lo + hi) / 2;
        double midX = pts[mid].x;

        double d1 = closestRec(pts, lo, mid, metrics);
        double d2 = closestRec(pts, mid, hi, metrics);
        double d = Math.min(d1, d2);

        Point[] strip = new Point[n];
        int m = 0;
        for (int i = lo; i < hi; i++) {
            if (Math.abs(pts[i].x - midX) < d) {
                strip[m++] = pts[i];
            }
        }
        Arrays.sort(strip, 0, m, Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m && (strip[j].y - strip[i].y) < d; j++) {
                d = Math.min(d, dist(strip[i], strip[j], metrics));
            }
        }
        return d;
    }

    private static double bruteForce(Point[] pts, int lo, int hi, Metrics metrics) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = lo; i < hi; i++) {
            for (int j = i + 1; j < hi; j++) {
                min = Math.min(min, dist(pts[i], pts[j], metrics));
            }
        }
        return min;
    }

    private static double dist(Point a, Point b, Metrics metrics) {
        metrics.incComparisons();
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double bruteForce(Point[] pts, Metrics metrics) {
        return bruteForce(pts, 0, pts.length, metrics);
    }
}
