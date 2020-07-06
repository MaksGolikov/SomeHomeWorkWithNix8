package util;

import org.apache.log4j.Logger;

public class InsertionSort {
    final static Logger LOGGER = Logger.getLogger(InsertionSort.class);
    public static void insertionSort(int[] arr) throws NoSuchMethodException {
        LOGGER.info("Start " + InsertionSort.class.getMethod("insertionSort", int[].class).getName());
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        LOGGER.info("End " + InsertionSort.class.getMethod("insertionSort", int[].class).getName());
    }
}
