package util;

import org.apache.log4j.Logger;

public class ShuttleSort {
    final static Logger LOGGER = Logger.getLogger(ShuttleSort.class);
    public static void shuttleSort(int[] a, int n) throws NoSuchMethodException {
        LOGGER.info("Start " + ShuttleSort.class.getMethod("shuttleSort", int[].class, int.class).getName());
        int temp, i, j;

        for (i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                j = i - 1;
                temp = a[i + 1];
                a[i + 1] = a[i];
                while (j >= 0 && a[j] > temp) {
                    a[j + 1] = a[j];
                    j = j - 1;
                }
                a[j + 1] = temp;
            }
        }
        LOGGER.info("End " + ShuttleSort.class.getMethod("shuttleSort", int[].class, int.class).getName());
    }
}
