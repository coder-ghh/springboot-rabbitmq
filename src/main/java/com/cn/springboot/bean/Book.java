package com.cn.springboot.bean;

public class Book {
    private String booknamel;
    private  String author;

    public Book(String booknamel, String author) {
        this.booknamel = booknamel;
        this.author = author;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "booknamel='" + booknamel + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getBooknamel() {
        return booknamel;
    }

    public void setBooknamel(String booknamel) {
        this.booknamel = booknamel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
