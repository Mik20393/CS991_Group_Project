package com.example.bookbuzz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewLibrary extends AppCompatActivity {

    RecyclerView recyclerView;


    ArrayList<String> s1;
    ArrayList<String> s2;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_library);

        recyclerView = findViewById(R.id.recyclerView);

        images = DataUtility.getImages();
        s1 = DataUtility.getNames();
        s2 = DataUtility.getISBNs();

        ViewLibraryAdapter viewLibraryAdapter = new ViewLibraryAdapter(this, s1, s2, images);
        recyclerView.setAdapter(viewLibraryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
