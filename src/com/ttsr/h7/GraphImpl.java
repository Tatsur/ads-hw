package com.ttsr.h7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }
    public void addVertex(String... labels){
        for (String label : labels) {
            vertexList.add(new Vertex(label));
        }
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String another : others) {
            result &= addEdge(startLabel, another);
        }
        return result;
    }

    private boolean addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            Vertex vertex = vertexList.get(i);
            if (vertex.getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
            vertex.setPreviousVertex(null);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex current) {
        int currentIndex = vertexList.indexOf(current);
        for (int i = 0; i < getSize(); i++) {
            if (adjMat[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    @Override
    public Stack<String> findShortestPathWithBfs(String startVertex, String finishVertex) {

        int startIndex = indexOf(startVertex);
        int finishIndex = indexOf(finishVertex);
        if (startIndex == -1)
            throw new IllegalArgumentException("Invalid start vertex name: " + startVertex);

        if (finishIndex == -1)
            throw new IllegalArgumentException("Invalid finish vertex name: " + finishVertex);


        Queue<Vertex> tempQueue = new ArrayDeque<>();
        Vertex currentVertex = vertexList.get(startIndex);
        visitVertex(tempQueue, currentVertex);

        Stack<String> shortPath = new Stack<>();

        while (!tempQueue.isEmpty()) {
            Vertex previousVertex = tempQueue.peek();
            currentVertex = getNearUnvisitedVertex(previousVertex);
            if (currentVertex == null)
                tempQueue.remove();
             else {
                visitVertex(tempQueue, currentVertex);
                currentVertex.setPreviousVertex(previousVertex);
                if (currentVertex.getLabel().equals(finishVertex))
                    shortPath = addVertexToPath(currentVertex);
            }
        }

        resetVertexState();
        return shortPath;
    }

    private Stack<String> addVertexToPath(Vertex vertex) {
        Stack<String> stack = new Stack<>();
        Vertex current = vertex;
        while (current != null) {
            stack.push(current.getLabel());
            current = current.getPreviousVertex();
        }

        return stack;
    }

    @Override
    public void showPath(Stack<String> path) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            stringBuilder.append(path.pop());
            if (path.isEmpty()) {
                break;
            }
            stringBuilder.append(" -> ");
        }

        System.out.println(stringBuilder);
    }
}
