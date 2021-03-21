package com.example.bookbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnterBookDetails extends AppCompatActivity {

    EditText enter_author_name;
    EditText enter_book_name;
    Button addBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_book_details);

        enter_author_name = findViewById(R.id.enter_author_name);
        enter_book_name = findViewById(R.id.enter_book_name);

        addBook = findViewById(R.id.addBookButton);

        Intent intent = getIntent();
        String identity = intent.getStringExtra("identity");


        if (identity.equals("database")) {
            String title = intent.getStringExtra("title");
            String author = intent.getStringExtra("author");
            enter_book_name.setText(title);
            enter_author_name.setText(author);
        }

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
            }
        });

    }

    public void addBook() {

        BookBuzzDataModel addedBook = new BookBuzzDataModel((enter_book_name.getText().toString()), enter_author_name.getText().toString());
        addedBook.setImage(R.drawable.hitchhikers_guide);
        DataUtility.addABook(addedBook);
        openSetStatus();
    }

    public void openSetStatus() {

        String isbn = enter_author_name.getText().toString();
        Intent intent = new Intent(this, SetStatus.class);
        intent.putExtra("isbn", isbn);
        startActivity(intent);
    }
}

