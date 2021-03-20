package com.example.bookbuzz;

import java.util.ArrayList;
import java.util.List;

public class BookBuzzDataModel {
    private String isbn;
    private String currentBookName;
    private List<NoteModel> notes;

    public BookBuzzDataModel(final String bookName, final String bookIsbn) {
        this.currentBookName = bookName;
        this.isbn = bookIsbn;
        notes = new ArrayList<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCurrentBookName() {
        return currentBookName;
    }

    public void setCurrentBookName(String currentBookName) {
        this.currentBookName = currentBookName;
    }

    public List<NoteModel> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteModel> notes) {
        this.notes = notes;
    }
}
