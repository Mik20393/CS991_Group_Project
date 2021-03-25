package com.example.bookbuzz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteAssetHelper {
    private  String DB_Name = "BookBuzzDB";
    private  int DB_ver =1;
    private String AuthorName;
    private String BookName;

    public DataBase(Context context) {
        super(context);
    }


    public List<BookBuzzDataModel>  getBooks (){
        SQLiteDatabase db = getReadableDataBase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        String[] sqlselect = {"Isbn", "AuthorName", "BookName","gener"};
        String tableName = "Book";
        queryBuilder.setTables(tableName);
        Cursor cursor = queryBuilder.query(db,sqlselect,null ,
                null, null,null,null,null);
        List<BookBuzzDataModel> result = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                BookBuzzDataModel bookBuzzDataModel =new BookBuzzDataModel();
                bookBuzzDataModel.setCurrentBookName(cursor.getString(cursor.getColumnIndex("BookName")));
                bookBuzzDataModel.setIsbn(cursor.getString(cursor.getColumnIndex("ISBN")));
                bookBuzzDataModel.setAuthorName(cursor.getString(cursor.getColumnIndex("AuthorName")));
                bookBuzzDataModel.setGenre(cursor.getString(cursor.getColumnIndex("Gener")));
                result.add(bookBuzzDataModel);
            }
            while (cursor.moveToNext())
        }
        return result;
    }

    public List<String> getBookName(){
        SQLiteDatabase db = getReadableDataBase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        String[] sqlselect = {"Book Name"};
        String tableName = "Book";
        queryBuilder.setTables(tableName);
        Cursor cursor = queryBuilder.query(db,sqlselect,"AuthorName Like ?", new
                String[]{"%"+AuthorName+"%"}, null, null,null,null,null);
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                result.add(cursor.getString((cursor.getColumnIndex("Book Name"))));
            }
            while (cursor.moveToNext());
        }
        return result;

    }

    public List<String> getBookByName(){
        SQLiteDatabase db = getReadableDataBase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        String[] sqlselect = {"Isbn", "AuthorName", "BookName","gener"};
        String tableName = "Book";
        queryBuilder.setTables(tableName);
        Cursor cursor = queryBuilder.query(db,sqlselect,"BookName Like ?", new
                String[]{"%"+BookName+"%"}, null, null,null,null,null);
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                result.add(cursor.getString((cursor.getColumnIndex("Book Name"))));
            }
            while (cursor.moveToNext());
        }
        return result;

    }



    private SQLiteDatabase getReadableDataBase() {
    }

}
