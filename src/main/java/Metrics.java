public class Metrics {
    private long comparisons = 0;
    private long swaps = 0;
    private long allocations = 0;
    private int currentDepth = 0;
    private int maxDepth = 0;

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void incAllocations() { allocations++; }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void exitRecursion() {
        if (currentDepth > 0) {
            currentDepth--;
        }
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAllocations() { return allocations; }
    public int getMaxDepth() { return maxDepth; }

    @Override
    public String toString() {
        return String.format(
            "Metrics{comparisons=%d, swaps=%d, allocations=%d, maxDepth=%d}",
            comparisons, swaps, allocations, maxDepth
        );
    }
}
