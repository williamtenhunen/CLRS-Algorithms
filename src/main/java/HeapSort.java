public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);
            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify subtree rooted at index i, n is the heap size
    private void heapify(int[] arr, int n, int i) {
        int largest = i;      // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Utility method to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        HeapSort heapSort = new HeapSort();

        System.out.println("Original array:");
        printArray(arr);

        heapSort.sort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Utility method to print the array
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}