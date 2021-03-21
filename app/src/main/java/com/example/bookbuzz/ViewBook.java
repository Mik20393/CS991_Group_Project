package com.example.bookbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewBook extends AppCompatActivity {

    ImageView bookPicture;
    TextView title;
    Button removeBook;
    Button bookmark;
    TextView status;
    EditText bookmarkPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        removeBook = findViewById(R.id.removeBook);
        bookPicture = findViewById(R.id.bookPicture);
        title = findViewById(R.id.title_txt_vb);
        status = findViewById(R.id.status_txt_vb);
        bookmark = findViewById(R.id.bookmark_btn);
        bookmarkPage = findViewById(R.id.editBookmark);
        setBookDetails();



        removeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBook();
            }
        });

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBookmark();
            }
        });

    }

    private void setBookDetails() {

        String isbn = getIntent().getStringExtra("isbn");
        BookBuzzDataModel book = DataUtility.getABookByIsbn(isbn);

        title.setText(book.getCurrentBookName());
        bookPicture.setImageResource(book.getImage());
        status.setText(book.getStatus());
        bookmarkPage.setText(book.getBookmark());
    }

    private void removeBook() {

        String isbn = getIntent().getStringExtra("isbn");
        DataUtility.removeBook(isbn);
        goBackToLibrary();
    }


    public void goBackToLibrary() {
        Intent intent = new Intent(this, ViewLibrary.class);
        startActivity(intent);
    }

    public void setBookmark(){
        String page = bookmarkPage.getText().toString();
        String isbn = getIntent().getStringExtra("isbn");
        BookBuzzDataModel book = DataUtility.getABookByIsbn(isbn);
        book.setBookmark(page);
        bookmarkPage.setText(book.getBookmark());
        goBackToLibrary();

    }
}

