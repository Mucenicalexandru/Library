package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class CD extends BorrowableItem {

    private int numberOfTracks;

    public CD(String name, Optional<Calendar> dateBorrowed, int numberOfTracks) {
        super(name, dateBorrowed);
        this.numberOfTracks = numberOfTracks;
    }
}
