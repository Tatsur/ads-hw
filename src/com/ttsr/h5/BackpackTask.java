package com.ttsr.h5;

import java.util.List;

public class BackpackTask {

    public static List<Item> items;

    public static void main(String[] args) {
        items = new ItemsRepo().getItems();
        calcAndShow(6);
        calcAndShow(3);
    }

    private static void calcAndShow(int weightLimit) {
        Backpack backpack = new Backpack(weightLimit);
        backpack.calcBestItemsSet(items);
        for (Item bestItem : backpack.getBestItems()) {
            System.out.println(bestItem);
        }
        System.out.println(backpack.getBestCost());
    }
}
