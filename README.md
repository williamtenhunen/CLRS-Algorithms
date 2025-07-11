# CLRS Algorithms

This repository contains implementations of algorithms from the book *Introduction to Algorithms* by Cormen, Leiserson, Rivest, and Stein (commonly referred to as CLRS).

## Current Implementations

The algorithms are located in the `src/main/java` directory. Currently, the following algorithms are implemented:

- **Insertion Sort** (`InsertSort.java`): A simple, in-place sorting algorithm with O(n²) time complexity, effective for small datasets or nearly sorted arrays.
- **Merge Sort** (`MergeSort.java`): A divide-and-conquer sorting algorithm with O(n log n) time complexity, suitable for larger datasets.
- **Heap Sort** (`HeapSort.java`): A comparison-based sorting algorithm that uses a max-heap data structure, with O(n log n) time complexity, efficient for large datasets and offering in-place sorting with no additional memory overhead.
- **Quicksort** (`Quicksort.java`): An efficient, in-place sorting algorithm following the divide-and-conquer strategy. It works by selecting a 'pivot' and partitioning the array around it, achieving an average time complexity of O(n log n), but can degrade to O(n²) in the worst case.
- **Counting Sort** (`CountingSort.java`): A linear-time, non-comparison sorting algorithm that works by counting occurrences of each element. It's highly efficient for integers within a small, known range, with a time complexity of O(n+k) where k is the maximum value.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with Java compilation support
- Git (optional, for cloning the repository)

### Usage

Each algorithm is implemented as a standalone Java class in the src/main/java directory. You can import and use these classes in your projects or run them directly to test their functionality. Example usage for each algorithm is included in the respective source files.

## License
This project is licensed under the MIT License.