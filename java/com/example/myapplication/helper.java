package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class helper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "articles.db";
    private static final int DATABASE_VERSION = 1;

    // Définition de la table des articles
    public static final String TABLE_ARTICLES = "articles";
    public  static final  String COLUMN_AUTEUR="auteur";
    public  static final  String COLUMN_Date="Date_publicaton";

    public static final String COLUMN_TITLE = "titre";
    public static final String COLUMN_DESCRIPTION = "description";

    public void insertArticle(Article article) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_Date,article.getDate());
        values.put(COLUMN_AUTEUR,article.getAuteur());
        values.put(COLUMN_TITLE, article.getTitle());
        values.put(COLUMN_DESCRIPTION, article.getDescription());

        db.insert(TABLE_ARTICLES, null, values);
        db.close();
    }
    public helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Création de la table des articles lors de la création de la base de données
        String createTableQuery = "CREATE TABLE "  + TABLE_ARTICLES + "(" +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_AUTEUR + " TEXT, " +
                COLUMN_Date + " TEXT" + ")";


        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    Cursor readAllData(){
        String query ="SELECT * FROM "+TABLE_ARTICLES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
