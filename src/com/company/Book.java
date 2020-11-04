package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class Book extends BorrowableItem {

    private int numberOfPages;


    public Book(String name, Optional<Calendar> dateBorrowed, int numberOfPages) {
        super(name, dateBorrowed);
        this.numberOfPages = numberOfPages;
    }
}
