package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button search;
    private Button addNewBook;
    private Button addNote;
    private Button viewNotes;
    private TextView filter_search;
    private Button view_library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        search = findViewById(R.id.search_btn);
        addNewBook = findViewById(R.id.add_new_book_button);
        addNote = findViewById(R.id.add_note_main);
        viewNotes = findViewById(R.id.view_notes_btn);
        filter_search = findViewById(R.id.filter_search_btn2);
        view_library = findViewById(R.id.view_library_button);

        setCurrentBook();
        createUserLibrary();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSearchPage();
            }
        });

        addNewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewBook();
            }
        });

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewNote();
            }
        });

        viewNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNotes();
            }
        });

        filter_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterSearch();
            }
        });
        view_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewLibrary();
            }
        });
    }

    public void goToSearchPage(){
        Intent intent = new Intent(this, SearchResults.class);
        startActivity(intent);
    }

    public void createNewBook(){
        Intent intent = new Intent(this, AddNewBook.class);
        startActivity(intent);
    }

    public void createNewNote(){
        Intent intent = new Intent(this, AddNote.class);
        startActivity(intent);
    }

    public void goToNotes(){
        Intent intent = new Intent(this, NotesPage.class);
        startActivity(intent);
    }

    public void filterSearch(){
        Intent intent = new Intent(this, FilterSearch.class);
        startActivity(intent);
    }

    public void setCurrentBook() {
        BookBuzzDataModel currentBook = new BookBuzzDataModel("Duglas Adams", "ISIN-234566");
        currentBook.setImage(R.drawable.hitchhikers_guide);
        DataUtility.addABook(currentBook);
        DataUtility.setCurrentBook(currentBook);
    }
    public void viewLibrary() {
        Intent intent = new Intent(this, ViewLibrary.class);
        startActivity(intent);
    }

    public static void createUserLibrary(){
        BookBuzzDataModel book1 = new BookBuzzDataModel("Hitchhikers guide to the Galaxy", "ISBN-54321");
        book1.setImage(R.drawable.hitchhikers_guide);
        BookBuzzDataModel book2 = new BookBuzzDataModel("Lanark", "ISBN-64321");
        book2.setImage(R.drawable.hitchhikers_guide);
        BookBuzzDataModel book3 = new BookBuzzDataModel("Brave New World", "ISBN-74321");
        book3.setImage(R.drawable.hitchhikers_guide);
        DataUtility.addABook(book1);
        DataUtility.addABook(book2);
        DataUtility.addABook(book3);

    }

}