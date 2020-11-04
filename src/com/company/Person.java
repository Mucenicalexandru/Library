package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Person {

    private UUID uuid;
    private boolean isRegistered;
    private List<BorrowableItem> borrowedItems;
    private int maxItemsToBorrow;

    public Person() {
        this.uuid = UUID.randomUUID();
        this.isRegistered = false;
        this.borrowedItems = new ArrayList<>();

    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public List<BorrowableItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrowItem(BorrowableItem item){
        borrowedItems.add(item);
    }

    public void setMaxItemsToBorrow(int maxItemsToBorrow) {
        this.maxItemsToBorrow = maxItemsToBorrow;
    }

    public int getMaxItemsToBorrow() {
        return maxItemsToBorrow;
    }
}
