package com.ttsr.h7;

import java.util.Stack;

public interface Graph {

    void addVertex(String label);

    void addVertex(String... label);

    boolean addEdge(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    Stack<String> findShortestPathWithBfs(String startLabel, String finishLabel);

    void showPath(Stack<String> path);
}
