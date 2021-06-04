package com.ttsr.h4;

import com.ttsr.h3.deque.Deque;
import com.ttsr.h3.deque.DequeImpl;

import java.util.Iterator;
import java.util.Queue;

public class LinkIteratorApp {
    public static void main(String[] args) {

        LinkedList<Integer> list = createList();

        listIteratorTest(list);

        show(list);

        linkedDequeTest();
    }

    private static LinkedList<Integer> createList() {
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        for (int i = 5; i > 0; i--) {
            list.insertFirst(i);
        }
        list.display();
        return list;
    }

    private static void listIteratorTest(LinkedList<Integer> list) {
        ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();
        iterator.reset();
        list.display();
        iterator.insertAfter(25);
        list.display();
        iterator.insertBefore(13);
        list.display();
        iterator.remove();
        list.display();
        iterator.next();
        iterator.insertAfter(16);
    }

    private static void linkedDequeTest() {
        Deque<Integer> deque = new LinkedDequeImpl<>();
        deque.insertLeft(2);
        deque.insertRight(4);
        deque.insertLeft(1);
        deque.insertRight(5);
        deque.remove();
        deque.display();
    }

    private static void show(LinkedList<Integer> list) {
        StringBuilder label = new StringBuilder();
        System.out.println("---------------");
        label.append("|");
        for (Integer i : list) {
            label.append(i).append("|");
        }
        System.out.println(label);
        System.out.println("---------------");

    }
}
