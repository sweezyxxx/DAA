# Divide and Conquer Algorithms

This project implements classic divide-and-conquer algorithms in **Java** with **Maven** and JUnit 5 tests.  
The goal is to analyze performance using custom metrics (comparisons, swaps, allocations, recursion depth, time).

---

##  Implemented Algorithms

- **MergeSort**  
  Optimized merge sort with cutoff for small subarrays and buffer reuse.

- **QuickSort**  
  Randomized pivot, smaller-first recursion to minimize stack depth, insertion sort cutoff.

- **Deterministic Select (Median of Medians)**  
  Finds the k-th order statistic in O(n) worst case.

- **Closest Pair of Points**  
  Divide-and-conquer algorithm in O(n log n), compared against brute force.

---

## Metrics Tracked

- `comparisons` – number of key comparisons  
- `swaps` – number of element moves  
- `allocations` – number of new array allocations  
- `maxDepth` – maximum recursion depth  
- `timeMs` – runtime in milliseconds  

---

##  Running the Project

Build & test:
mvn clean test
<img width="696" height="167" alt="image" src="https://github.com/user-attachments/assets/b5c9d572-60ca-4442-8d72-7a3affe9d121" />
<img width="645" height="309" alt="image" src="https://github.com/user-attachments/assets/30ba5195-68d2-455d-b4a7-b452e21267fb" />
<img width="827" height="463" alt="image" src="https://github.com/user-attachments/assets/c80e675b-3d77-427b-a298-9fb9e7148a6e" />
```bash
GITLOG:
PS C:\Users\temir\OneDrive\Desktop\DAA\1\divide-and-conquer> git log --oneline --graph --all
* 9c54e34 (HEAD -> master) fix: ClosestPair
* 7992ee0 fix: DeterministicSelectTest
* ab51689 fix: Main.java
*   158bf7b fix: quicksort
|\
| * 9869a3e (docs/report) fix: MetricsTest.java
| * 6a907c5 fix: fix quicksort
* 9c54e34 (HEAD -> master) fix: ClosestPair
* 7992ee0 fix: DeterministicSelectTest
* ab51689 fix: Main.java
*   158bf7b fix: quicksort
|\
| * 9869a3e (docs/report) fix: MetricsTest.java
| * 6a907c5 fix: fix quicksort
| * 44da97c docs(report): project description, usage, metrics, results template
* | 19a7253 fix: QuickSort
* 9c54e34 (HEAD -> master) fix: ClosestPair
* 7992ee0 fix: DeterministicSelectTest
* ab51689 fix: Main.java
*   158bf7b fix: quicksort
|\
| * 9869a3e (docs/report) fix: MetricsTest.java
| * 6a907c5 fix: fix quicksort
| * 44da97c docs(report): project description, usage, metrics, results template
* | 19a7253 fix: QuickSort
* 9c54e34 (HEAD -> master) fix: ClosestPair
* 7992ee0 fix: DeterministicSelectTest
* ab51689 fix: Main.java
*   158bf7b fix: quicksort
|\
| * 9869a3e (docs/report) fix: MetricsTest.java
| * 6a907c5 fix: fix quicksort
| * 44da97c docs(report): project description, usage, metrics, results template
* | 19a7253 fix: QuickSort
|\|
* | bd3e1fa chore: add pom.xml and initial build output
| | * 613ea72 (feature/cli) feat(cli): run algorithms, collect metrics, save results to CSV
| |/
:...skipping...
* 9c54e34 (HEAD -> master) fix: ClosestPair
* 7992ee0 fix: DeterministicSelectTest
* ab51689 fix: Main.java
*   158bf7b fix: quicksort
|\
| * 9869a3e (docs/report) fix: MetricsTest.java
| * 6a907c5 fix: fix quicksort
| * 44da97c docs(report): project description, usage, metrics, results template
* | 19a7253 fix: QuickSort
|\|
* | bd3e1fa chore: add pom.xml and initial build output
| | * 613ea72 (feature/cli) feat(cli): run algorithms, collect metrics, save results to CSV
| |/
| | * 6c8ac8f (feature/closest) feat(closest): divide-and-conquer implementation + tests
| | * 1af906f (feature/select) feat(select): deterministic select (MoM5) + tests
| |/
:...skipping...
* 9c54e34 (HEAD -> master) fix: ClosestPair
* 7992ee0 fix: DeterministicSelectTest
* ab51689 fix: Main.java
*   158bf7b fix: quicksort
|\
| * 9869a3e (docs/report) fix: MetricsTest.java
| * 6a907c5 fix: fix quicksort
| * 44da97c docs(report): project description, usage, metrics, results template
* | 19a7253 fix: QuickSort
|\|
* | bd3e1fa chore: add pom.xml and initial build output
| | * 613ea72 (feature/cli) feat(cli): run algorithms, collect metrics, save results to CSV
| |/
| | * 6c8ac8f (feature/closest) feat(closest): divide-and-conquer implementation + tests
| |/
| | * 1af906f (feature/select) feat(select): deterministic select (MoM5) + tests
| |/
| * 4cd1d49 (feature/quicksort, feature/metrics, feature/mergesort) feat(quicksort): smaller-first recursion, randomized pivot + tests
|/
* 0ec82ce test(metrics): basic unit tests
* 9c54e34 (HEAD -> master) fix: ClosestPair
* 7992ee0 fix: DeterministicSelectTest
* ab51689 fix: Main.java
*   158bf7b fix: quicksort
|\
| * 9869a3e (docs/report) fix: MetricsTest.java
| * 6a907c5 fix: fix quicksort
| * 44da97c docs(report): project description, usage, metrics, results template
* | 19a7253 fix: QuickSort
|\|
* | bd3e1fa chore: add pom.xml and initial build output
| | * 613ea72 (feature/cli) feat(cli): run algorithms, collect metrics, save results to CSV
| |/
| | * 6c8ac8f (feature/closest) feat(closest): divide-and-conquer implementation + tests
| |/
| | * 1af906f (feature/select) feat(select): deterministic select (MoM5) + tests
| |/
| * 4cd1d49 (feature/quicksort, feature/metrics, feature/mergesort) feat(quicksort): smaller-first recursion, randomized pivot + tests
|/
* 0ec82ce test(metrics): basic unit tests
* 11c63df feat(metrics): counters, depth tracker
* 615eca4 feat(mergesort): baseline + reuse buffer + cutoff + tests
:...skipping...
* 9c54e34 (HEAD -> master) fix: ClosestPair
* 7992ee0 fix: DeterministicSelectTest
* ab51689 fix: Main.java
*   158bf7b fix: quicksort
|\
| * 9869a3e (docs/report) fix: MetricsTest.java
| * 6a907c5 fix: fix quicksort
| * 44da97c docs(report): project description, usage, metrics, results template
* | 19a7253 fix: QuickSort
|\|
* | bd3e1fa chore: add pom.xml and initial build output
| | * 613ea72 (feature/cli) feat(cli): run algorithms, collect metrics, save results to CSV
| |/
| | * 6c8ac8f (feature/closest) feat(closest): divide-and-conquer implementation + tests
| |/
| | * 1af906f (feature/select) feat(select): deterministic select (MoM5) + tests
| |/
| * 4cd1d49 (feature/quicksort, feature/metrics, feature/mergesort) feat(quicksort): smaller-first recursion, randomized pivot + tests
|/
* 0ec82ce test(metrics): basic unit tests
* 11c63df feat(metrics): counters, depth tracker
* 615eca4 feat(mergesort): baseline + reuse buffer + cutoff + tests
* 3d3b1b6 init: maven, junit5, ci, readme
