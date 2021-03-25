package com.example.bookbuzz;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

class SearchViewHolder extends RecyclerView.ViewHolder{
    TextView bookTitle, authorName, rating, gener;

    public SearchViewHolder( View itemView) {
        super(itemView);
        bookTitle = (TextView)itemView.findViewById(R.id.title1);
        authorName = (TextView)itemView.findViewById(R.id.author1);
        rating = (TextView)itemView.findViewById(R.id.rating1);
        gener = (TextView)itemView.findViewById(R.id.ficiton1);

    }



}
public class SearchAdapter extends  RecyclerView.Adapter<SearchViewHolder>{
    private Context context;
    private List< BookBuzzDataModel> books;

    public SearchAdapter(Context context) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate((R.layout.layout_item), parent,false);
        return new SearchViewHolder((itemView));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.bookTitle.setText((books.get(position).getCurrentBookName()));
        holder.authorName.setText(books.get(position).getAuthorName());
        holder.gener.setText(books.get(position).getGenre());
        holder.rating.setText(books.get(position).getIsbn());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
