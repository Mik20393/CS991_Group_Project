package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewNotes extends AppCompatActivity {
    Button homeButton;
    Button viewLibrary;
    Button addNote;
    ImageView imageView ;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);

        imageView = findViewById(R.id.deleteButton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        TextView bookName = findViewById(R.id.textViewBookName);
        bookName.setText(DataUtility.getCurrentBook().getCurrentBookName());

        List<NoteModel> notes = DataUtility.getCurrentBook().getNotes();
        NoteViewAdaptor noteViewAdaptor = new NoteViewAdaptor(this, notes);

        recyclerView = findViewById(R.id.noteRecycleView);
        recyclerView.setAdapter(noteViewAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteViewAdaptor.notifyDataSetChanged();

        homeButton = findViewById(R.id.homeFromViewNoteButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeButtonIntent = new Intent(ViewNotes.this, MainActivity.class);
                startActivity(homeButtonIntent);
            }
        });

        viewLibrary = findViewById(R.id.myLibraryFromNotebutton2);
        viewLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewLibraryButtonIntent = new Intent(ViewNotes.this, ViewLibrary.class);
                startActivity(viewLibraryButtonIntent);
            }
        });


        addNote = findViewById(R.id.addNoteFromViewNoteButton3);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNoteButtonIntent = new Intent(ViewNotes.this, AddNote.class);
                startActivity(addNoteButtonIntent);
            }
        });

    }
}