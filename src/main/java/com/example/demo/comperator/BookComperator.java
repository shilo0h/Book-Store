package com.example.demo.comperator;

import com.example.demo.entities.Book;

import java.util.Comparator;

public class BookComperator {
    public class BookComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            if(o1.getPrice()<o2.getPrice()){
                return 1;
            } else if (o1.getPrice()>o2.getPrice()){
                return -1;
            } else if (o1.getTitle().compareTo(o2.getTitle())<0){
                return -1;
            } else if (o1.getTitle().compareTo(o2.getTitle())>0) {
                return 1;
            } else if (o1.getPublication_year()<o2.getPublication_year()) {
                return -1;
            } else if (o1.getPublication_year()>o2.getPublication_year()) {
                return 1;
            }
            return 0;
        }
    }
}
