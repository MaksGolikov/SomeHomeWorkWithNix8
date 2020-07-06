package util;

import org.apache.log4j.Logger;

public class MergeSort {
    public static void mergeSort(int[] array, int low, int high) throws NoSuchMethodException {
        if (high <= low) return;

        int mid = (low+high)/2;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {

        int[] leftArray = new int[mid - low + 1];
        int[] rightArray = new int[high - mid];


        if (leftArray.length >= 0) System.arraycopy(array, low, leftArray, 0, leftArray.length);
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
