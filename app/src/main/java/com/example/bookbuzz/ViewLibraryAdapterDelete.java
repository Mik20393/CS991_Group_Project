package com.example.bookbuzz;

import android.view.ViewGroup;
import android.widget.Filter;

import androidx.annotation.NonNull;

public interface ViewLibraryAdapterDelete {
    void setCriteria(String criteria);

    @NonNull
    ViewLibraryAdapter.LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull ViewLibraryAdapter.LibraryViewHolder holder, int position);

    int getItemCount();

    Filter getFilter();
}
