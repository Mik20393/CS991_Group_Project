package com.example.bookbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NotesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_page);
        EditText textView = findViewById(R.id.note_text1);

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.ACTION_UP == motionEvent.getAction()) {
                    textView.setText(textView.getText());
                }
                return true;
            }
        });
        String textTobeShow = textView.getText().toString();
//        for (String note : DataUtility.getCurrentBook().getNotes()) {
//            textTobeShow = textTobeShow + "\n" + "Current date" + System.currentTimeMillis() + note + "\n";
//        }
//        textView.setText(textTobeShow);
//        textView.setEnabled(false);

//        textView.setOnHoverListener(new View.OnHoverListener() {
//            @Override
//            public boolean onHover(View view, MotionEvent motionEvent) {
//                Log.i("in eHover", "in hoverlistner");
//                textView.setEnabled(true);
//                return true;
//            }
//        });

//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("in edit view", "in listner");
//                textView.setEnabled(true);
//            }
//        });
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