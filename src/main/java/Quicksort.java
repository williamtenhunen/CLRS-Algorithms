import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Quicksort {

    public static void sort(int[] A) {
        if (A == null || A.length <= 1) {
            return; // Already sorted or empty
        }
        quicksort(A, 0, A.length - 1);
    }

    private static void quicksort(int[] A, int p, int r) {
        if (p < r) {
            // q is the partitioning index, A[q] is now at its correct sorted position
            int q = partition(A, p, r);
            quicksort(A, p, q - 1); // Recursively sort elements before partition
            quicksort(A, q + 1, r); // Recursively sort elements after partition
        }
    }

    private static int partition(int[] A, int p, int r) {
        int x = A[r]; // Choose the last element as the pivot
        int i = p - 1; // i will point to the last element of the "less than or equal to pivot" partition

        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j); // Move A[j] to the "less than or equal to pivot" partition
            }
        }
        swap(A, i + 1, r); // Place the pivot A[r] into its correct sorted position
        return i + 1; // Return the index of the pivot
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private static void assertArrayEquals(int[] expected, int[] actual, String testName, AtomicInteger passedTests, AtomicInteger failedTests) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("PASS: " + testName);
            passedTests.incrementAndGet();
        } else {
            System.err.println("FAIL: " + testName);
            System.err.println("  Expected: " + Arrays.toString(expected));
            System.err.println("  Actual:   " + Arrays.toString(actual));
            failedTests.incrementAndGet();
        }
    }

    private static void assertDoesNotThrow(Runnable runnable, String testName, AtomicInteger passedTests, AtomicInteger failedTests) {
        try {
            runnable.run();
            System.out.println("PASS: " + testName);
            passedTests.incrementAndGet();
        } catch (Exception e) {
            System.err.println("FAIL: " + testName + " - Threw exception: " + e.getMessage());
            failedTests.incrementAndGet();
        }
    }

    private static void runTestBasicSort(AtomicInteger passedTests, AtomicInteger failedTests) {
        int[] input = {5, 2, 4, 6, 1, 3};
        int[] expected = {1, 2, 3, 4, 5, 6};
        Quicksort.sort(input);
        assertArrayEquals(expected, input, "testBasicSort", passedTests, failedTests);
    }

    private static void runTestAlreadySortedArray(AtomicInteger passedTests, AtomicInteger failedTests) {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Quicksort.sort(input);
        assertArrayEquals(expected, input, "testAlreadySortedArray", passedTests, failedTests);
    }

    private static void runTestReverseSortedArray(AtomicInteger passedTests, AtomicInteger failedTests) {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Quicksort.sort(input);
        assertArrayEquals(expected, input, "testReverseSortedArray", passedTests, failedTests);
    }

    private static void runTestArrayWithDuplicates(AtomicInteger passedTests, AtomicInteger failedTests) {
        int[] input = {5, 2, 4, 2, 1, 3, 5};
        int[] expected = {1, 2, 2, 3, 4, 5, 5};
        Quicksort.sort(input);
        assertArrayEquals(expected, input, "testArrayWithDuplicates", passedTests, failedTests);
    }

    private static void runTestSingleElementArray(AtomicInteger passedTests, AtomicInteger failedTests) {
        int[] input = {42};
        int[] expected = {42};
        Quicksort.sort(input);
        assertArrayEquals(expected, input, "testSingleElementArray", passedTests, failedTests);
    }

    private static void runTestEmptyArray(AtomicInteger passedTests, AtomicInteger failedTests) {
        int[] input = {};
        int[] expected = {};
        Quicksort.sort(input);
        assertArrayEquals(expected, input, "testEmptyArray", passedTests, failedTests);
    }

    private static void runTestNegativeNumbers(AtomicInteger passedTests, AtomicInteger failedTests) {
        int[] input = {-5, -2, -8, 0, 3};
        int[] expected = {-8, -5, -2, 0, 3};
        Quicksort.sort(input);
        assertArrayEquals(expected, input, "testNegativeNumbers", passedTests, failedTests);
    }

    private static void runTestNullArray(AtomicInteger passedTests, AtomicInteger failedTests) {
        assertDoesNotThrow(() -> Quicksort.sort(null), "testNullArray", passedTests, failedTests);
    }

    private static void runTestLargeRandomArray(AtomicInteger passedTests, AtomicInteger failedTests) {
        int size = 10000;
        int[] input = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            input[i] = random.nextInt(size * 10);
        }

        int[] expected = Arrays.copyOf(input, size);
        Arrays.sort(expected);

        long startTime = System.nanoTime();
        Quicksort.sort(input);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // milliseconds

        System.out.println("DEBUG: Quicksort for " + size + " elements took: " + duration + " ms");
        assertArrayEquals(expected, input, "testLargeRandomArray", passedTests, failedTests);
    }

    public static void main(String[] args) {
        System.out.println("Running Quicksort Tests");
        System.out.println("-----------------------");

        AtomicInteger passedTests = new AtomicInteger(0);
        AtomicInteger failedTests = new AtomicInteger(0);

        runTestBasicSort(passedTests, failedTests);
        runTestAlreadySortedArray(passedTests, failedTests);
        runTestReverseSortedArray(passedTests, failedTests);
        runTestArrayWithDuplicates(passedTests, failedTests);
        runTestSingleElementArray(passedTests, failedTests);
        runTestEmptyArray(passedTests, failedTests);
        runTestNegativeNumbers(passedTests, failedTests);
        runTestNullArray(passedTests, failedTests);
        runTestLargeRandomArray(passedTests, failedTests);

        System.out.println("\nTest Summary\n");
        System.out.println("Total tests run: " + (passedTests.get() + failedTests.get()));
        System.out.println("Passed: " + passedTests.get());
        System.out.println("Failed: " + failedTests.get());
        System.out.println("--------------------");
    }
}