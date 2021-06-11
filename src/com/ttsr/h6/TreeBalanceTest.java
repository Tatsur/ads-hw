package com.ttsr.h6;

import java.util.Random;

public class TreeBalanceTest {
    static Random random;
    static int randomMaxValue;
    static int treesAmount;
    static int maxLevel;
    static int nodesAmount;
    static int balancedTreesCounter;
    static {
        random = new Random();
        randomMaxValue = 25;
        treesAmount = 20;
        maxLevel = 4;
        nodesAmount = (int) (Math.pow(2, maxLevel) - 1);
        balancedTreesCounter = 0;
    }

    public static void main(String[] args) {

        for (int i = 0; i < treesAmount; i++) {
            Tree<Integer> tree = new TreeImpl<>(maxLevel);
            fillTreeWithRandomValues(tree);
            if (tree.isBalanced()) {
                balancedTreesCounter++;
                tree.display();
            }
        }
        System.out.printf("Percent of balanced trees = %s %%%n",(balancedTreesCounter / (double)(treesAmount) * 100));
    }

    private static void fillTreeWithRandomValues(Tree<Integer> tree) {
        for (int j = 0; j < nodesAmount; j++) {
            tree.add(random.nextInt(randomMaxValue * 2 + 1) - randomMaxValue);
        }
    }
}