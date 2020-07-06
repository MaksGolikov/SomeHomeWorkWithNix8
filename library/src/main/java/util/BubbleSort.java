package util;

import org.apache.log4j.Logger;

public class BubbleSort {
    final static Logger LOGGER = Logger.getLogger(BubbleSort.class);

    public static void bubbleSort(int[] arr) throws NoSuchMethodException {
        LOGGER.info("Start " + BubbleSort.class.getMethod("bubbleSort", int[].class).getName());
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        LOGGER.info("End  " + BubbleSort.class.getMethod("bubbleSort", int[].class).getName());
    }
}
