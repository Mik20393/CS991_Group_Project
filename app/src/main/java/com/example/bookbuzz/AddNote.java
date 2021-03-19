package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        TextView bookTitle = findViewById(R.id.book_title_add_note);
        bookTitle.setText(DataUtility.getCurrentBook().getCurrentBookName());
        initializedListner();
    }

    private void initializedListner() {
        Button saveButton = findViewById(R.id.save_note_button);
        EditText enterText = findViewById(R.id.note_entry_text);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("on save", "clicking note save");
                BookBuzzDataModel currentbook = DataUtility.getCurrentBook();
                String noteToBeAdded = enterText.getText().toString();
                currentbook.getNotes().add(noteToBeAdded);
            }
        });
    }
}