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
    private TextView currentBookTitle;
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

        setReminder = findViewById(R.id.set_reminder_button);
        view_library = findViewById(R.id.view_library_button);
        view_history = findViewById(R.id.view_read_history_button);

        setCurrentBook();
        createUserLibrary();
        createDatabase();

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

    public static void createDatabase(){
        BookBuzzDataModel bookDB1 = new BookBuzzDataModel("The Grapes of Wrath", "ISBN-5678");
        bookDB1.setAuthor("John Steinbeck");
        bookDB1.setImage(R.drawable.restaurant_at_the_end_of_the_universe);
        BookBuzzDataModel bookDB2 = new BookBuzzDataModel("The Fellowship of the Ring", "ISBN-3657");
        bookDB2.setAuthor("J. R. R. Tolkein");
        bookDB2.setImage(R.drawable.hitchhikers_guide);
        BookBuzzDataModel bookDB3 = new BookBuzzDataModel("Catch 22", "ISBN-23657");
        bookDB3.setAuthor("Joseph Heller");
        bookDB3.setImage(R.drawable.life_the_universe_and_everything);
        bookDB3.setAuthor("Joseph Heller");
        DataUtility.addBookDB(bookDB1);
        DataUtility.addBookDB(bookDB2);
        DataUtility.addBookDB(bookDB3);
    }


}