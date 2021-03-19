package com.example.bookbuzz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtility {
    private static Map<String,BookBuzzDataModel> books = new HashMap<>();
    private static BookBuzzDataModel currentBook;

    public static BookBuzzDataModel getCurrentBook() {
        return currentBook;
    }

    public static void setCurrentBook(final BookBuzzDataModel currentBookToset) {
        currentBook = currentBookToset;
    }

    public static void addABook(final BookBuzzDataModel bookBuzzDataModel) {
        books.put(bookBuzzDataModel.getIsbn(), bookBuzzDataModel);
    }

    public static BookBuzzDataModel getABookByIsbn(final String isbn) {
        return books.get(isbn);
    }
}
