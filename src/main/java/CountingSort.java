public class CountingSort {
    public static void sort(int[] A, int[] B, int k) {
        if (A == null || B == null) {
            throw new IllegalArgumentException("Input and output arrays cannot be null.");
        }
        if (A.length != B.length) {
            throw new IllegalArgumentException("Input array A and output array B must have the same length.");
        }
        if (k < 0) {
            throw new IllegalArgumentException("Maximum value k must be non-negative.");
        }
        if (A.length == 0) {
            return;
        }

        int[] C = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }

        for (int j = 0; j < A.length; j++) {
            if (A[j] < 0 || A[j] > k) {
                throw new IllegalArgumentException("Element " + A[j] + " at index " + j + " is out of the specified range [0, " + k + "].");
            }
            C[A[j]] = C[A[j]] + 1;
        }

        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }
}