package com.example.bookbuzz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewLibrary extends AppCompatActivity {

    RecyclerView libraryRecyclerView;


    ArrayList<String> title;
    ArrayList<String> author;
    ArrayList<String> status;
    ArrayList<String> bookmark;
    ArrayList<String> isbn;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_library);

        libraryRecyclerView = findViewById(R.id.searchDatabaserecyclerView);

        images = DataUtility.getImages();
        title = DataUtility.getNames();
        author = DataUtility.getAuthors();
        bookmark = DataUtility.getBookmarks();
        status = DataUtility.getAllStatus();
        isbn = DataUtility.getISBNs();

        ViewLibraryAdapter viewLibraryAdapter = new ViewLibraryAdapter(this, title, author, status, bookmark, isbn, images);
        libraryRecyclerView.setAdapter(viewLibraryAdapter);
        libraryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}