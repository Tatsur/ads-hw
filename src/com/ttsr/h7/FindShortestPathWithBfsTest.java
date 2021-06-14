package com.ttsr.h7;

import java.util.Stack;

public class FindShortestPathWithBfsTest {

    public static void main(String[] args) {
        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва", "Тула", "Рязань", "Калуга", "Липецк", "Орел", "Курск", "Воронеж", "Тамбов");

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

        findAndShowTheShortestPath(graph,"Москва","Воронеж");
        findAndShowTheShortestPath(graph,"Тамбов","Орел");
    }

    private static void findAndShowTheShortestPath(Graph graph,String startLabel,String finishLabel) {
        Stack<String> path = graph.findShortestPathWithBfs(startLabel, finishLabel);
        System.out.println("The shortest path is: ");
        graph.showPath(path);
    }

}