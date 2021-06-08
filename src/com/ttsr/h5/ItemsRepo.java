package com.ttsr.h5;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepo {

    private final List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public ItemsRepo() {
        items = new ArrayList<>();
        items.add(new Item("Книга",1,600));
        items.add(new Item("Бинокль",2,5000));
        items.add(new Item("Аптечка",4,1500));
        items.add(new Item("Ноутбук",2,40000));
        items.add(new Item("Котелок",1,500));
    }
}
