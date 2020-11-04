package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public abstract class BorrowableItem {

    private String name;
    private UUID uuid;
    private Optional<Calendar> dateBorrowed;

    public BorrowableItem(String name, Optional<Calendar> dateBorrowed) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.dateBorrowed = dateBorrowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Optional<Calendar> getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Optional<Calendar> dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }
}
