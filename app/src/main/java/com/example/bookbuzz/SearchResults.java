package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResults extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.example.bookbuzz.example.EXTRA_TITLE";
    public static final String EXTRA_AUTHOR = "com.example.bookbuzz.example.EXTRA_AUTHOR";

    Button add1;
    Button add2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        add1 = findViewById(R.id.addbtn1);
        add2 = findViewById(R.id.addbtn2);

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(SearchResults.this, "Book added to Library", Toast.LENGTH_LONG).show();
                addBook1();
            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchResults.this, "Book added to Library", Toast.LENGTH_LONG).show();
            }
        });

    }
    public void addBook1() {
        TextView title1 = findViewById(R.id.title1);
        String title = title1.getText().toString();

        TextView author1 = findViewById(R.id.author1);
        String author = author1.getText().toString();

        String identity = "database";


        Intent intent = new Intent(this, EnterBookDetails.class);
        intent.putExtra("identity", identity);
        intent.putExtra("title", title);
        intent.putExtra("author", author);

        startActivity(intent);
    }
}