package com.ttsr.h5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final int weightLimit;
    private List<Item> bestItems;
    private int bestCost;

    public Backpack(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    private int calcWeight(List<Item> items){
        int sum = 0;
        for (Item item : items) {
            sum += item.getWeight();
        }
        return sum;
    }

    private int calcCost(List<Item> items){
        int sum = 0;
        for (Item item : items) {
            sum += item.getCost();
        }
        return sum;
    }

    public void checkBestItemsSet(List<Item> items){
        if(items.isEmpty()) return;
        int sumWeight = calcWeight(items);
        int sumCost = calcCost(items);
        if(sumWeight <= weightLimit && sumCost > bestCost){
            bestCost = sumCost;
            bestItems = items;
        }
    }

    public void calcBestItemsSet(List<Item> items) {
        if (items.isEmpty()) return;

        checkBestItemsSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Item> tempItems = new ArrayList<>(items);
            tempItems.remove(i);
            calcBestItemsSet(tempItems);
        }
    }

    public List<Item> getBestItems() {
        return bestItems;
    }

    public int getBestCost() {
        System.out.println("Best summary cost of items in backpack: " + bestCost);
        return bestCost;
    }
}
