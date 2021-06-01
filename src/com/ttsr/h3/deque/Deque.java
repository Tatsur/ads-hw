package com.ttsr.h3.deque;

import com.ttsr.h3.queue.Queue;

public interface Deque<E> extends Queue<E> {

    E removeLeft();
    E removeRight();

    boolean insertLeft(E value);
    boolean insertRight(E value);
}
