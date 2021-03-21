package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.TextView;

public class NotesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_page);
        EditText textView = findViewById(R.id.note_text1);

        String textTobeShow = textView.getText().toString();
//        for (String note : DataUtility.getCurrentBook().getNotes()) {
//            textTobeShow = textTobeShow + "\n" + note + "\n";
//        }
        textView.setText(textTobeShow);
        textView.setInputType(InputType.TYPE_NULL);
        textView.setTextIsSelectable(true);

       
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("in edit view", "in listner");
                textView.setInputType(InputType.TYPE_CLASS_TEXT);
                textView.setTextIsSelectable(false);
            }
        });
//
//        textView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                Log.i("in key event view", "in listner");
//                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
//                    Log.i("in key event view", "in UP listner");
//                    textView.setEnabled(true);
//                }
//                return false;
//            }
//        });
//    }
    }
}