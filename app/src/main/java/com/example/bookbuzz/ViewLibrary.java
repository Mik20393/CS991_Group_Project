package com.example.bookbuzz;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewLibrary extends AppCompatActivity {

    RecyclerView libraryRecyclerView;

    ViewLibraryAdapter viewLibraryAdapter;
    ArrayList<BookBuzzDataModel> library;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_library);

        library = DataUtility.getBooks();
        libraryRecyclerView = findViewById(R.id.searchDatabaserecyclerView);



        viewLibraryAdapter = new ViewLibraryAdapter(this, library);
        libraryRecyclerView.setAdapter(viewLibraryAdapter);
        libraryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_library_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.library_action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchText) {
                viewLibraryAdapter.getFilter().filter(searchText);
                return false;
            }
        });
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.library_by_author:
                viewLibraryAdapter.setCriteria("author");
                return true;
            case R.id.library_by_title:
                viewLibraryAdapter.setCriteria("title");
                return true;
            case R.id.library_by_genre:
                viewLibraryAdapter.setCriteria("genre");
                return true;
            case R.id.library_by_year:
                viewLibraryAdapter.setCriteria("year");
                return true;
            case R.id.library_by_status:
                viewLibraryAdapter.setCriteria("status");
                return true;
            case R.id.library_by_isbn:
                viewLibraryAdapter.setCriteria("isbn");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}