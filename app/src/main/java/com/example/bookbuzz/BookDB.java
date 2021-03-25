package com.example.bookbuzz;

public class BookDB {
    public String isbn;
    private BookBuzzDataModel bookBuzzDataModel;

    public void setBookBuzzDataModel(BookBuzzDataModel bookBuzzDataModel) {
        this.bookBuzzDataModel = bookBuzzDataModel;
    }

    public BookBuzzDataModel getBookBuzzDataModel()
    {
        String book = bookBuzzDataModel.getCurrentBookName().toString();
        return bookBuzzDataModel;
    }



}
