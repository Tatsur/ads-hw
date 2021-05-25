package com.ttsr;

import java.util.Random;

//jdk 1.8
// Bubble sorting: |50k| 7611 ms  |200k| 117262 ms
// select sorting:       2531 ms         39752 ms
// insert sorting:       964 ms          15083 ms

//jdk 11

// Bubble sorting: |50k| 9982 ms  |200k| 236710 ms
// select sorting:       2790 ms         43266 ms
// insert sorting:       3248 ms         89327 ms

//jdk 14

// Bubble sorting: |50k| 9833 ms  |200k| 233789 ms
// select sorting:       2751 ms         43202 ms
// insert sorting:       3050 ms         89815 ms

//jdk 1.8 быстрее, чем jdk 11+???

public class Test {

    public static void main(String[] args) {

        SortTime sortTime = new SortTime();
        Random random = new Random();
        Array<Integer> initData = new ArrayImpl<>();
        fillArrayWithRandomData(random, initData);
        sort(sortTime, initData, "bubble");
        sort(sortTime, initData, "select");
        sort(sortTime, initData, "insert");

    }

    private static void sort(SortTime sortTime, Array<Integer> initData, String sortType) {
        Array<Integer> data = initData.cloneArray();
        sortTime.setStartTime(System.nanoTime());
        switch (sortType) {
            case "bubble": {
                data.sortBubble();
                sortTime.setFinishTime(System.nanoTime());
                sortTime.getResultTime("Bubble sorting");
            }
            break;
            case "select": {
                data.sortSelect();
                sortTime.setFinishTime(System.nanoTime());
                sortTime.getResultTime(sortType + " sorting");
            }
            break;
            case "insert": {
                data.sortInsert();
                sortTime.setFinishTime(System.nanoTime());
                sortTime.getResultTime(sortType + " sorting");
            }
            break;
        }
    }

    private static void fillArrayWithRandomData(Random random, Array<Integer> data) {
        for (int i = 0; i < ArrayImpl.DEFAULT_CAPACITY; i++) {
            data.add(random.nextInt(100));
        }
    }
}
