package com.example.phobook;

public class Book {

    private String bookName;
    private String artist;
    private String note;
    private int priority;

    public Book(){

    }
    public Book(String bookName, String artist, String note, int priority){
        this.bookName = bookName;
        this.artist = artist;
        this.note = note;
        this.priority = priority;

    }

    public String getBookName() {
        return bookName;
    }

    public String getArtist() {
        return artist;
    }

    public String getNote() {
        return note;
    }

    public int getPriority() {
        return priority;
    }
}
