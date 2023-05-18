package com.example.myapplication;

import java.util.Date;

public class Article {
    private String title;
    private  String auteur;
    private String date;
    private String description;

    public Article(String title, String auteur,String date, String description) {
        this.title = title;
        this.auteur = auteur;
        this.date = date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuteur(){
        return auteur;
    }
    public String getDate(){
        return  date;
    }
}

