package com.ttsr.h3.deque;

import com.ttsr.h3.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        if(isEmpty())
            return null;

        if(tail == TAIL_DEFAULT) tail = data.length - size;

        size--;

        return data[tail--];
    }

    @Override
    public boolean insertLeft(E value) {
        return super.insert(value);
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }
        if (head == HEAD_DEFAULT)
            head = data.length;

        data[--head] = value;
        size++;

        return true;
    }
}
