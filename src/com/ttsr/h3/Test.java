package com.ttsr.h3;

//1. Реализовать рассмотренные структуры данных в консольных программах.
//2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
//3. Создать класс для реализации дека.

import com.ttsr.h3.deque.Deque;
import com.ttsr.h3.deque.DequeImpl;
import com.ttsr.h3.queue.Queue;
import com.ttsr.h3.queue.QueueImpl;
import com.ttsr.h3.stack.Stack;
import com.ttsr.h3.stack.StackImpl;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        dequeTask();
        reverseTask();
    }

    private static void reverseTask() {
        Scanner scanner = new Scanner(System.in);
        String textLine = "";
        while (true){
            textLine = scanner.nextLine();
            if(textLine.equals("/end")) break;
            Stack<Character> stack = new StackImpl<>(textLine.length());
            for (char c : textLine.toCharArray() ) {
                stack.push(c);
            }
            while(!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }

    private static void dequeTask(){
        Deque<Integer> deque = new DequeImpl<>(5);
        System.out.println(deque.insertLeft(1));
        System.out.println(deque.insertLeft(2));
        System.out.println(deque.insertLeft(3));
        System.out.println(deque.insertRight(5));
        System.out.println(deque.insertRight(6));
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        System.out.println(deque.insertLeft(7));
        System.out.println(deque.insertLeft(8));
        deque.display();
    }
}
