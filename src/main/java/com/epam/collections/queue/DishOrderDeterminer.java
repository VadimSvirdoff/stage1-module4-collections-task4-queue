package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> dishOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.offer(i);
        }
        int count = 1;
        while (!queue.isEmpty()) {
            int dishNumber = queue.poll();
            if (count % everyDishNumberToEat == 0) {
                dishOrder.add(dishNumber);
            } else {
                queue.offer(dishNumber);
            }
            count++;
        }
        return dishOrder;
    }
}
