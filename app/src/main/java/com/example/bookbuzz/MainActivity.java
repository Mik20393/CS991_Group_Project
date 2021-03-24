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
        Intent searchPageIntent = new Intent(this, SearchDatabase.class);
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
        BookBuzzDataModel hitchhikersGuideToTheGalaxy = new BookBuzzDataModel("Hitchhikers guide to the Galaxy", "ISBN-54321");
        hitchhikersGuideToTheGalaxy.setImage(R.drawable.hitchhikers_guide);

        BookBuzzDataModel lanark = new BookBuzzDataModel("Lanark", "ISBN-64321");
        lanark.setAuthor("Alasdair Gray");
        lanark.setImage(R.drawable.lanark_book);

        BookBuzzDataModel braveNewWorld = new BookBuzzDataModel("Brave New World", "ISBN-74321");
        braveNewWorld.setImage(R.drawable.hitchhikers_guide);
        braveNewWorld.setAuthor("Aldous Huxley");

        DataUtility.addABook(hitchhikersGuideToTheGalaxy);
        DataUtility.addABook(lanark);
        DataUtility.addABook(braveNewWorld);

    }

    public static void createDatabase(){

        BookBuzzDataModel grapesOfWrath = new BookBuzzDataModel("The Grapes of Wrath", "ISBN-5678");
        grapesOfWrath.setAuthor("John Steinbeck");
        grapesOfWrath.setImage(R.drawable.restaurant_at_the_end_of_the_universe);

        BookBuzzDataModel LOTR = new BookBuzzDataModel("The Fellowship of the Ring", "ISBN-3657");
        LOTR.setAuthor("J. R. R. Tolkein");
        LOTR.setImage(R.drawable.lotr_book);

        BookBuzzDataModel catch22 = new BookBuzzDataModel("Catch 22", "ISBN-23657");
        catch22.setImage(R.drawable.life_the_universe_and_everything);
        catch22.setAuthor("Joseph Heller");

        BookBuzzDataModel lordOfLight = new BookBuzzDataModel("Lord of Light", "ISBN-24356");
        lordOfLight.setAuthor("Roger Zelazny");
        lordOfLight.setImage(R.drawable.lord_of_light);

        BookBuzzDataModel restaurantAtEOU = new BookBuzzDataModel("Restaurant at the End of the Universe", "ISBN-14356");
        restaurantAtEOU.setImage(R.drawable.restaurant_at_the_end_of_the_universe);
        restaurantAtEOU.setAuthor("Douglas Adams");

        BookBuzzDataModel lifeUniverseEverything = new BookBuzzDataModel("Restaurant at the End of the Universe", "ISBN-54586");
        lifeUniverseEverything.setImage(R.drawable.life_the_universe_and_everything);
        lifeUniverseEverything.setAuthor("Douglas Adams");


        DataUtility.addBookDB(grapesOfWrath);
        DataUtility.addBookDB(LOTR);
        DataUtility.addBookDB(catch22);
        DataUtility.addBookDB(lordOfLight);
        DataUtility.addBookDB(restaurantAtEOU);
        DataUtility.addBookDB(lifeUniverseEverything);

    }


}