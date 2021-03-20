package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddNewBook extends AppCompatActivity {

    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);
        search = findViewById(R.id.search_btn_add_book);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySearchResults();
            }
        });
    }

    public void displaySearchResults(){
        Intent displayResultintent = new Intent(this, SearchResults.class);
        startActivity(displayResultintent);
    }
}