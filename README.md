# Divide and Conquer Algorithms

This project implements classic divide-and-conquer algorithms in **Java** with **Maven** and JUnit 5 tests.  
The goal is to analyze performance using custom metrics (comparisons, swaps, allocations, recursion depth, time).

---

## 📌 Implemented Algorithms

- **MergeSort**  
  Optimized merge sort with cutoff for small subarrays and buffer reuse.

- **QuickSort**  
  Randomized pivot, smaller-first recursion to minimize stack depth, insertion sort cutoff.

- **Deterministic Select (Median of Medians)**  
  Finds the k-th order statistic in O(n) worst case.

- **Closest Pair of Points**  
  Divide-and-conquer algorithm in O(n log n), compared against brute force.

---

## 📊 Metrics Tracked

- `comparisons` – number of key comparisons  
- `swaps` – number of element moves  
- `allocations` – number of new array allocations  
- `maxDepth` – maximum recursion depth  
- `timeMs` – runtime in milliseconds  

---

## 🚀 Running the Project

Build & test:
```bash
mvn clean test