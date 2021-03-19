package com.example.bookbuzz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewLibraryAdapter extends RecyclerView.Adapter<ViewLibraryAdapter.MyViewHolder> {

    ArrayList<String> data1, data2;
    int images[];
    Context context;

    public ViewLibraryAdapter(Context ct, ArrayList<String> s1, ArrayList<String> s2, int[] img){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_library_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.book_title_txt.setText(data1.get(position));
        holder.book_author_txt.setText(data2.get(position));
        holder.viewLibImageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_title_txt, book_author_txt;
        ImageView viewLibImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            viewLibImageView = itemView.findViewById(R.id.viewLibImageView);
        }
    }
}
