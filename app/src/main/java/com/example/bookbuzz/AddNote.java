package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

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
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("on save", "clicking note save");
                String userNote = enterText.getText().toString();
                NoteModel currentNote = new NoteModel(currentDate, userNote);
                BookBuzzDataModel currentbook = DataUtility.getCurrentBook();
                currentbook.getNotes().add(currentNote);
            }
        });
    }
}