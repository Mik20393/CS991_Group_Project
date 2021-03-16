package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SearchResults extends AppCompatActivity {

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
                Toast.makeText(SearchResults.this, "Book added to Library", Toast.LENGTH_LONG).show();
            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchResults.this, "Book added to Library", Toast.LENGTH_LONG).show();
            }
        });
    }
}