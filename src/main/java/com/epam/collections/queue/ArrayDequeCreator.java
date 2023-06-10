package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.add(firstQueue.poll());
        arrayDeque.add(firstQueue.poll());
        arrayDeque.add(secondQueue.poll());
        arrayDeque.add(secondQueue.poll());

        boolean isAddElementToFirstQueue = true;
        boolean isAddElementToSecondQueue = false;
        boolean isTakeTwoElementsFromFirstQueue = false;
        boolean isTakeTwoElementsFromSecondQueue = false;

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            if(isAddElementToFirstQueue){
                firstQueue.add(arrayDeque.pollLast());
                isAddElementToFirstQueue = false;
                isTakeTwoElementsFromFirstQueue = true;
            }

            if(isTakeTwoElementsFromFirstQueue){
                arrayDeque.add(firstQueue.poll());
                arrayDeque.add(firstQueue.poll());
                isTakeTwoElementsFromFirstQueue = false;
                isAddElementToSecondQueue = true;
            }

            if(isAddElementToSecondQueue){
                secondQueue.add(arrayDeque.pollLast());
                isAddElementToSecondQueue = false;
                isTakeTwoElementsFromSecondQueue = true;
            }

            if(isTakeTwoElementsFromSecondQueue){
                arrayDeque.add(secondQueue.poll());
                arrayDeque.add(secondQueue.poll());
                isTakeTwoElementsFromSecondQueue = false;
                isAddElementToFirstQueue = true;
            }


        }

        return arrayDeque;
    }
}
