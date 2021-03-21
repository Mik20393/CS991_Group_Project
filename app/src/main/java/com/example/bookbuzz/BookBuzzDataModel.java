package com.example.bookbuzz;

import java.util.ArrayList;
import java.util.List;

/***
 * This class holds the book and list of notes.
 */
public class BookBuzzDataModel {
    private String isbn;
    private String currentBookName;
    private List<NoteModel> notes;

    public BookBuzzDataModel(final String bookName, final String bookIsbn) {
        this.currentBookName = bookName;
        this.isbn = bookIsbn;
        notes = new ArrayList<>();
    }

    /***
     * Funtion used to get ISBN of book
     * @return ISBN of type string.
     */
    public String getIsbn() {
        return isbn;
    }

    /***
     * function to use set the value of ISBN
     * @param isbn of string type
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /***
     * function to get value of current book name.
     * @return string value of current book name.
     */
    public String getCurrentBookName() {
        return currentBookName;
    }

    /***
     * Function to set current book name
     * @param currentBookName of type string
     */
    public void setCurrentBookName(String currentBookName) {
        this.currentBookName = currentBookName;
    }

    /***
     * Function to get list of notes
     * @return value of notes.
     */
    public List<NoteModel> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteModel> notes) {
        this.notes = notes;
    }
}
