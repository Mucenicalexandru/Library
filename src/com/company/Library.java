package com.company;

import java.util.*;

public class Library {
    private List<BorrowableItem> availableItems;
    private List<BorrowableItem> borrowedItems;
    private List<Person> registeredPerson;

    public Library() {
        this.availableItems = new ArrayList<>();
        this.borrowedItems = new ArrayList<>();
        this.registeredPerson = new ArrayList<>();
    }

    public void returnItem(BorrowableItem item, Person person){
        availableItems.add(item);
        borrowedItems.remove(item);
        person.getBorrowedItems().remove(item);
    }


    public void borrowItem(BorrowableItem requestedItem, Person person){
        if(person.getBorrowedItems().size() > person.getMaxItemsToBorrow()){
            throw new IllegalArgumentException("Maximum borrowed items reached");
        }else if(!person.isRegistered()){
            throw new IllegalArgumentException("Person should register to be able to borrow");
        }else{
            if(availableItems.contains(requestedItem)){
                borrowedItems.add(requestedItem);
                availableItems.remove(requestedItem);
                person.borrowItem(requestedItem);
                requestedItem.setDateBorrowed(Optional.of(Calendar.getInstance()));

            }else{
                throw new IllegalArgumentException("The item is not available");
            }

        }
    }


    public String getInfoAboutItem(UUID uuid){
        if(registeredPerson.size() > 0){
            for(Person person : registeredPerson){
                for(BorrowableItem item : person.getBorrowedItems()){
                    if(item.getUuid().equals(uuid)){
                        return  "Status : borrowed by " + person;
                    }
                }
            }
        }else{
            return "Status : available";
        }
        return null;
    }


    public void userRegistration(Person personToRegister){
        if(registeredPerson.size() > 0){
            for(Person person : registeredPerson){
                if(person.equals(personToRegister)){
                    throw new IllegalArgumentException("Already registered person");
                }else{
                    registeredPerson.add(personToRegister);
                    personToRegister.setRegistered(true);
                }
            }
        }else{
            registeredPerson.add(personToRegister);
            personToRegister.setRegistered(true);
        }
    }

    public void addItems(BorrowableItem item){
        availableItems.add(item);
    }

    public List<BorrowableItem> seeAvailableItems(){
        return availableItems;
    }

    public List<BorrowableItem> seeBorrowedItems(){
        return borrowedItems;
    }

}
