package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        //Build the library
        Library library = new Library();

        //Build books and cds
        Book book = new Book("Hunger Games vol.1", Optional.empty(), 500);
        Book book1 = new Book("Hunger Games vol.2", Optional.empty(), 500);
        Book book2 = new Book("Hunger Games vol.3", Optional.empty(), 500);

        CD cd = new CD("Tiesto", Optional.empty(), 10);
        CD cd1 = new CD("Lost Frequencies", Optional.empty(), 6);
        CD cd2 = new CD("Carla's Dreams", Optional.empty(), 8);

        //add items to the library
        library.addItems(book);
        library.addItems(book1);
        library.addItems(book2);
        library.addItems(cd);
        library.addItems(cd1);
        library.addItems(cd2);


        //build a student and a town resident
        Student student = new Student();
        TownResident townResident = new TownResident();

        //Student is registering before he is able to borrow items
        library.userRegistration(student);

        //Library items before somebody is borrowing
        System.out.println("Library initial list of items :  " + library.seeAvailableItems());

        library.borrowItem(book, student);
        library.borrowItem(book1, student);
        library.borrowItem(book2, student);
        library.borrowItem(cd, student);
        library.borrowItem(cd1, student);

        //student reached maximum items he can borrow error
//        library.borrowItem(cd2, student);

        //student borrowed items
        System.out.println("Students items after borrowing 5  : " + student.getBorrowedItems());

        //Library items after somebody is borrowing
        System.out.println("Library available items after borrowing 5 of them : " + library.seeAvailableItems());

        //Item is not available anymore error
//        library.borrowItem(cd1, townResident);

        //Student is returning a book
        library.returnItem(book, student);
        System.out.println("Students borrowed books after returning one : " + student.getBorrowedItems());
        System.out.println("Library available books after receiving back one : " + library.seeAvailableItems());


        //See when books were borrowed
        library.seeBorrowedItems().forEach(item -> {
            System.out.println(item.getDateBorrowed().get().getTime());
        });

    }
}
