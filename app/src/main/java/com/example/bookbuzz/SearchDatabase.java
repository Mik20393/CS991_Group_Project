package com.example.bookbuzz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchDatabase extends AppCompatActivity {

    RecyclerView databaseRecyclerView;


    ArrayList<String> title;
    ArrayList<String> author;
    ArrayList<String> isbn;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_library);

        databaseRecyclerView = findViewById(R.id.searchDatabaserecyclerView);

        images = DataUtility.getImagesDB();
        title = DataUtility.getNamesDB();
        author = DataUtility.getAuthorsDB();
        isbn = DataUtility.getISBNsDB();

        SearchDatabaseAdapter searchDatabaseAdapter = new SearchDatabaseAdapter(this, title, author, isbn, images);
        databaseRecyclerView.setAdapter(searchDatabaseAdapter);
        databaseRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
