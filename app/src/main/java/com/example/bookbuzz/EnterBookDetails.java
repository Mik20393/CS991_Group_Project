package com.example.bookbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnterBookDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_book_details);

        EditText enter_author_name = findViewById(R.id.enter_author_name);
        EditText enter_book_name = findViewById(R.id.enter_book_name);


        Intent intent = getIntent();
        String identity = intent.getStringExtra("identity");


        if (identity.equals("database")) {
            String title =  intent.getStringExtra("title");
            String author = intent.getStringExtra("author");
            enter_book_name.setText(title);
            enter_author_name.setText(author);
        }
    }
}

