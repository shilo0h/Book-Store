package com.example.demo.comperator;

import com.example.demo.entities.Author;

import java.util.Comparator;

public class AuthorComperator {
    public class AuthorComparator implements Comparator<Author> {
        @Override
        public int compare(Author o1, Author o2) {
            if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            } else if (o1.getName().compareTo(o2.getName()) > 0) {
                return 1;
            } else if (o1.getAge() < o2.getAge()) {
                return 1;
            } else if (o1.getAge() > o2.getAge()) {
                return -1;
            }
            return 0;
        }
    }
}
