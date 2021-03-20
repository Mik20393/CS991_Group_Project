package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewNotes extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);

        TextView bookName = findViewById(R.id.textViewBookName);
        bookName.setText(DataUtility.getCurrentBook().getCurrentBookName());

        List<NoteModel> notes = DataUtility.getCurrentBook().getNotes();
        NoteViewAdaptor noteViewAdaptor = new NoteViewAdaptor(this, notes);

        recyclerView = findViewById(R.id.noteRecycleView);
        recyclerView.setAdapter(noteViewAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteViewAdaptor.notifyDataSetChanged();
    }
}