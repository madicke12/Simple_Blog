package com.example.myapplication;

import android.icu.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.Date;

public class Dateparser {
    public Date parser(String date) {

        String format = "dd/MM/YYYY";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
