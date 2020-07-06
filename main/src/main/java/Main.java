import org.apache.log4j.Logger;
import util.*;

import java.util.*;

public class Main {

    final static Logger LOGGER = Logger.getLogger(Main.class);

    private static final int CAPACITY = 100000;

    private static int[] ints = new int[CAPACITY];
    private static int[] intsCopy = new int[CAPACITY];
    private static int index = 0;

    private static long before;
    private static long after;
    private static long delta;

    private static long bubbleTime;
    private static long insertionTime;
    private static long mergeTime;
    private static long quickTime;
    private static long selectionTime;
    private static long shellTime;
    private static long shuttleTime;
    private static long collectionsTime;

    public static void main(String[] args) {

        for (int i = 0; i < ints.length; i++) {
            index = (int) Math.floor(Math.random() * CAPACITY);
            ints[i] = index;
        }
        intsCopy = ints.clone();


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }

        int count = 0;
        while (count < 5) {
            try {
                before = System.nanoTime();
                BubbleSort.bubbleSort(ints);
                after = System.nanoTime();
                delta = after - before;
                LOGGER.debug("Time of " + BubbleSort.class.getMethod("bubbleSort", int[].class) + " = " + delta);
                bubbleTime += delta;
                ints = intsCopy.clone();

                before = System.nanoTime();
                InsertionSort.insertionSort(ints);
                after = System.nanoTime();
                delta = after - before;
                LOGGER.debug("Time of " + InsertionSort.class.getMethod("insertionSort", int[].class) + " = " + delta);
                insertionTime += delta;
                ints = intsCopy.clone();

                before = System.nanoTime();
                MergeSort.mergeSort(ints, 0, ints.length - 1);
                after = System.nanoTime();
                delta = after - before;
                LOGGER.debug("Time of " + MergeSort.class.getMethod("mergeSort", int[].class, int.class, int.class) + " = " + delta);
                mergeTime += delta;
                ints = intsCopy.clone();

                before = System.nanoTime();
                QuickSort.quickSort(ints, 0, ints.length - 1);
                after = System.nanoTime();
                delta = after - before;
                LOGGER.debug("Time of " + QuickSort.class.getMethod("quickSort", int[].class, int.class, int.class) + " = " + delta);
                quickTime += delta;
                ints = intsCopy.clone();

                before = System.nanoTime();
                SelectionSort.selectionSort(ints);
                after = System.nanoTime();
                delta = after - before;
                LOGGER.debug("Time of " + SelectionSort.class.getMethod("selectionSort", int[].class) + " = " + delta);
                selectionTime += delta;
                ints = intsCopy.clone();

                before = System.nanoTime();
                ShellSort.shellSort(ints);
                after = System.nanoTime();
                delta = after - before;
                LOGGER.debug("Time of " + ShellSort.class.getMethod("shellSort", int[].class) + " = " + delta);
                shellTime += delta;
                ints = intsCopy.clone();

                before = System.nanoTime();
                ShuttleSort.shuttleSort(ints, ints.length);
                after = System.nanoTime();
                delta = after - before;
                LOGGER.debug("Time of " + ShuttleSort.class.getMethod("shuttleSort", int[].class, int.class) + " = " + delta);
                shuttleTime += delta;
                ints = intsCopy.clone();

                LOGGER.debug("Start " + Collections.class.getMethod("sort", List.class) + " from class " + Collections.class.getName());
                before = System.nanoTime();
                Collections.sort(list);
                after = System.nanoTime();
                LOGGER.debug("End " + Collections.class.getMethod("sort", List.class) + " from class " + Collections.class.getName());
                delta = after - before;
                LOGGER.debug("Time of " + Collections.class.getMethod("sort", List.class) + " from class " + Collections.class.getName() + " = " + delta);
                collectionsTime += delta;
                list.clear();
                for (int i = 0; i < ints.length; i++) {
                    list.add(ints[i]);
                }
            } catch (NoSuchMethodException e) {
                LOGGER.error(e);
            }
            count++;
        }

        LOGGER.info("\n --- Рейтинг ---\n");


        Map<String,Long> mapOfTime = new LinkedHashMap<>();
        mapOfTime.put("BubbleSort",bubbleTime);
        mapOfTime.put("InsertionSort",insertionTime);
        mapOfTime.put("MergeSort",mergeTime);
        mapOfTime.put("QuickSort",quickTime);
        mapOfTime.put("SelectionSort",selectionTime);
        mapOfTime.put("ShellSort",shellTime);
        mapOfTime.put("ShuttleSort",shuttleTime);
        mapOfTime.put("CollectionsSort", collectionsTime);

        List<Map.Entry<String,Long>> list1 = new LinkedList<>(mapOfTime.entrySet());
        list1.sort(Map.Entry.comparingByValue());
        Map<String,Long> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String,Long> entry : list1) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        int i = 0;
        for (Map.Entry<String, Long> me : sortedMap.entrySet()) {
            LOGGER.info(++i + " - "+ me.getKey() + ": " + me.getValue());
        }
    }
}
