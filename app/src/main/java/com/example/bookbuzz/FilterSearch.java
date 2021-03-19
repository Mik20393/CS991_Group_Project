package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FilterSearch extends AppCompatActivity {

    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_search);

        search = findViewById(R.id.search_btn2);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSearchResults();
            }
        });
    }

    public void showSearchResults(){
        Intent searchResultIntent = new Intent(this, SearchResults.class);
        startActivity(searchResultIntent);
    }
}