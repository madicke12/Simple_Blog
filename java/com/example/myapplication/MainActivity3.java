package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        TextView title ,dt,contenu,atr;
        title = findViewById(R.id.article_title);
        dt = findViewById(R.id.article_date);
        atr = findViewById(R.id.article_auteur);
        contenu = findViewById(R.id.article_Contenu);

        String auteur = intent.getStringExtra("article.auteur");
        String desc = intent.getStringExtra("article.contenu");
        String titre = intent.getStringExtra("article.titre");
        String date = intent.getStringExtra("article.date");

        title.setText(titre);
        dt.setText(date);
        atr.setText(auteur);
        contenu.setText(desc);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                Intent intent = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}

