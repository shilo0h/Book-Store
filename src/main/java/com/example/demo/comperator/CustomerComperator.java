package com.example.demo.comperator;

import com.example.demo.entities.Customer;

import java.util.Comparator;

public class CustomerComperator {
    public class CustomerComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            if(o1.getName().compareTo(o2.getName())<0){
                return -1;
            } else if (o1.getName().compareTo(o2.getName())>0){
                return 1;
            } else if (o1.getAge() < o2.getAge()) {
                return 1;
            } else if (o1.getAge() > o2.getAge()){
                return -1;
            } else if (o1.getEmail().compareTo(o2.getEmail())<0){
                return -1;
            } else if (o1.getEmail().compareTo(o2.getEmail())>0) {
                return 1;
            }
            return 0;
        }
    }
}
