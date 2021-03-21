package com.example.bookbuzz;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtility {
    private static Map<String, BookBuzzDataModel> books = new HashMap<>();
    private static BookBuzzDataModel currentBook;

    public static BookBuzzDataModel getCurrentBook() { return currentBook;
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

    public static ArrayList<BookBuzzDataModel> getBooks() {

        ArrayList<BookBuzzDataModel> booksArray
                = new ArrayList<>(books.values());
        return booksArray;
    }

    public static ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();

        for (BookBuzzDataModel book : getBooks()) {
            names.add(book.getCurrentBookName());

        }
        return names;
    }

    public static ArrayList<String> getISBNs() {
        ArrayList<String> isbn = new ArrayList<>();

        for (BookBuzzDataModel book : getBooks()) {
            isbn.add(book.getIsbn());

        }
        return isbn;

    }
    public static int[] getImages() {
        int count = 0;
        int[] images = new int[getBooks().size()];

        for (BookBuzzDataModel book : getBooks()) {
            images[count] = book.getImage();
            count++;

        }
        return images;
    }
    public static void removeBook(String isbn) {
        books.remove(isbn);
    }


    public static void setStatus(String isbn, String status) {

        books.get(isbn).setStatus(status);
    }


}

