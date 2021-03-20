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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        search = findViewById(R.id.search_btn);
        addNewBook = findViewById(R.id.add_new_book_button);
        addNote = findViewById(R.id.add_note_main);
        viewNotes = findViewById(R.id.view_notes_btn);
        filter_search = findViewById(R.id.filter_search_btn2);
        setCurrentBook();

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
    }

    public void goToSearchPage(){
        Intent searchPageIntent = new Intent(this, SearchResults.class);
        startActivity(searchPageIntent);
    }

    public void createNewBook(){
        Intent craeteBookIntent = new Intent(this, AddNewBook.class);
        startActivity(craeteBookIntent);
    }

    public void createNewNote(){
        Intent createNoteIntent = new Intent(this, AddNote.class);
        startActivity(createNoteIntent);
    }

    public void goToNotes(){
        Intent viewNotePageIntent = new Intent(this, ViewNotes.class);
        startActivity(viewNotePageIntent);
    }

    public void filterSearch(){
        Intent filterSearchIntent = new Intent(this, FilterSearch.class);
        startActivity(filterSearchIntent);
    }

    public void setCurrentBook() {
        BookBuzzDataModel currentBook = new BookBuzzDataModel("Duglas Adams", "ISIN-234566");
        DataUtility.addABook(currentBook);
        DataUtility.setCurrentBook(currentBook);
    }


}