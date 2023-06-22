package com.example.demo.comperator;

import com.example.demo.entities.Order;

import java.util.Comparator;

public class GenreComperator {
    public class OrderComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            if (o1.getTotalAmount()<o2.getTotalAmount()){
                return 1;
            } else if (o1.getTotalAmount()>o2.getTotalAmount()){
                return -1;
            } else if (o1.getCustomerId()<o2.getCustomerId()){
                return 1;
            } else if (o1.getCustomerId()>o2.getCustomerId()){
                return -1;
            }
            return 0;
        }
    }
}
