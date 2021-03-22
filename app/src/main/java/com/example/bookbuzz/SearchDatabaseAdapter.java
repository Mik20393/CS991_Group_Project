package com.example.bookbuzz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchDatabaseAdapter extends RecyclerView.Adapter<SearchDatabaseAdapter.DatabaseViewHolder> {

    ArrayList<String> title, author, isbn;
    int[] images;
    Context context;

    public SearchDatabaseAdapter(Context ct, ArrayList<String> title, ArrayList<String> author, ArrayList<String> isbn, int[] img) {
        context = ct;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        images = img;

    }

    @NonNull
    @Override
    public DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_library_row, parent, false);
        return new DatabaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseViewHolder holder, final int position) {

        holder.book_title_txt.setText(title.get(position));
        holder.book_author_txt.setText(author.get(position));
        holder.isbn_txt.setText(isbn.get(position));
        holder.searchDBImageView.setImageResource(images[position]);

        holder.searchDBLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String db = "db";
                Intent intent = new Intent(context, EnterBookDetails.class);
                intent.putExtra("isbn", isbn.get(position));
                intent.putExtra("db", db);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public class DatabaseViewHolder extends RecyclerView.ViewHolder {

        TextView book_title_txt, book_author_txt, book_status_txt, bookmark_txt, isbn_txt;
        ImageView searchDBImageView;
        ConstraintLayout searchDBLayout;


        public DatabaseViewHolder(@NonNull View itemView) {
            super(itemView);
            book_title_txt = itemView.findViewById(R.id.book_title_txt_db);
            book_author_txt = itemView.findViewById(R.id.book_author_txt_db);
            book_status_txt = itemView.findViewById(R.id.book_status_txt_db);
            bookmark_txt = itemView.findViewById(R.id.book_bookmark_txt_db);
            isbn_txt = itemView.findViewById(R.id.book_isbn_txt);
            searchDBImageView = itemView.findViewById(R.id.searchDBImageView);
            searchDBLayout = itemView.findViewById(R.id.searchDBLayout);
            isbn_txt.setVisibility(View.GONE);

        }
    }
}

