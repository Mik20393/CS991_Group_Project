package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
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
    private Button setReminder;
    private TextView filter_search;
    private Button view_library;
    private Button view_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        search = findViewById(R.id.search_btn);
        addNewBook = findViewById(R.id.add_new_book_button);
        addNote = findViewById(R.id.add_note_main);
        viewNotes = findViewById(R.id.view_notes_btn);
        filter_search = findViewById(R.id.filter_search_btn2);
        setReminder = findViewById(R.id.set_reminder_button);
        view_library = findViewById(R.id.view_library_button);
        view_history = findViewById(R.id.view_read_history_button);

        setCurrentBook();
        createUserLibrary();

        setReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setReminderIntent = new Intent(MainActivity.this, Reminder.class);
                startActivity(setReminderIntent);
            }
        });

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
        view_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {viewHistory();}
        });
    }

    public void goToSearchPage(){
        Intent searchPageIntent = new Intent(this, SearchResults.class);
        startActivity(searchPageIntent);
    }

    public void createNewBook(){
        Intent createBookIntent = new Intent(this, AddNewBook.class);
        startActivity(createBookIntent);
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
        currentBook.setImage(R.drawable.hitchhikers_guide);
        DataUtility.addABook(currentBook);
        DataUtility.setCurrentBook(currentBook);
    }
    public void viewLibrary() {
        Intent intent = new Intent(this, ViewLibrary.class);
        startActivity(intent);
    }

    public void viewHistory() {
        Intent intent = new Intent(this, ReadHistory.class);
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