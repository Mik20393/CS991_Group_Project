package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class AddNewBook extends AppCompatActivity {
    public static final String EXTRA_IDENTITY = "com.example.bookbuzz.example.EXTRA_IDENTITY";

    ImageButton search;
    Spinner findBookSpinner;
    Button addManually;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);
        search = findViewById(R.id.search_btn_add_book);
        findBookSpinner = findViewById(R.id.findBookSpinner);
        addManually = findViewById(R.id.addManually);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddNewBook.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.find_book_spinner));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        findBookSpinner.setAdapter(myAdapter);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySearchResults();
            }
        });
        addManually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnterBookDetails();
            }
        });

    }

    public void displaySearchResults(){
        Intent intent = new Intent(this, SearchResults.class);
        startActivity(intent);
    }
    public void openEnterBookDetails(){

        String identity = "manual";

        Intent intent = new Intent(this, EnterBookDetails.class);
        intent.putExtra("identity", identity);
        startActivity(intent);
    }
}