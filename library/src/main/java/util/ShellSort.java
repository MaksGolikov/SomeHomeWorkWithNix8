package util;

import org.apache.log4j.Logger;

public class ShellSort {
    final static Logger LOGGER = Logger.getLogger(ShellSort.class);
    public static void shellSort(int[] arr) throws NoSuchMethodException {
        LOGGER.info("Start " + ShellSort.class.getMethod("shellSort", int[].class).getName());

        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {

            for (int i = gap; i < n; i += 1)
            {

                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];


                arr[j] = temp;
            }
        }
        LOGGER.info("End " + ShellSort.class.getMethod("shellSort", int[].class).getName());
    }
}
