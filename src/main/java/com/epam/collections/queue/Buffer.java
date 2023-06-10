package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Buffer extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.add(firstQueue.poll());
        arrayDeque.add(firstQueue.poll());
        arrayDeque.add(secondQueue.poll());
        arrayDeque.add(secondQueue.poll());

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            Integer firstItem = arrayDeque.pollFirst();
            if (firstItem != null) {
                firstQueue.add(firstItem);
            } else {
                break;
            }

            Integer secondItem = arrayDeque.pollFirst();
            if (secondItem != null) {
                secondQueue.add(secondItem);
            } else {
                break;
            }

            if (!firstQueue.isEmpty()) {
                arrayDeque.add(firstQueue.poll());
            } else {
                break;
            }
            if (!firstQueue.isEmpty()) {
                arrayDeque.add(firstQueue.poll());
            } else {
                break;
            }
            if (!secondQueue.isEmpty()) {
                arrayDeque.add(secondQueue.poll());
            } else {
                break;
            }
            if (!secondQueue.isEmpty()) {
                arrayDeque.add(secondQueue.poll());
            } else {
                break;
            }
        }


        return arrayDeque;
    }
}
