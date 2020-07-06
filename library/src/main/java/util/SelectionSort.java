package util;

import org.apache.log4j.Logger;

public class SelectionSort {
    final static Logger LOGGER = Logger.getLogger(SelectionSort.class);
    public static void selectionSort(int[] arr) throws NoSuchMethodException {
        LOGGER.info("Start " + SelectionSort.class.getMethod("selectionSort", int[].class).getName());
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        LOGGER.info("End " + SelectionSort.class.getMethod("selectionSort", int[].class).getName());
    }
}
