package com.ttsr.h5;

public class Item {

    private final String name;
    private final int weight;
    private final int cost;

    public Item(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if(obj == null || getClass() != obj.getClass()) return false;
       Item item = (Item) obj;
       if(weight != item.getWeight()) return false;
       if(cost != item.getCost()) return false;
       if(name!= null) return name.equals(item.getName());
        else return item.getName() == null;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Item {" +
                "name ='" + name + '\'' +
                ", weight =" + weight +
                ", cost =" + cost +
                '}';
    }
}
