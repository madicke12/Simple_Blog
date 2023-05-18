package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity2.this ,MainActivity.class);

        EditText titre =findViewById(R.id.titre);
        EditText commentaire =findViewById(R.id.contenu);
        EditText auteur = findViewById(R.id.Auteur);
        EditText date = findViewById(R.id.Date);
        Dateparser parser = new Dateparser();

        switch (view.getId()){

            case R.id.cancel:
                startActivity(intent);
                break;
            case R.id.ajouter:
                String atr = auteur.getText().toString();
                String d = (date.getText().toString());
                String t = titre.getText().toString();
                String c = commentaire.getText().toString();
                Article a = new Article(t,atr,d, c);
                helper helper =new helper(this);
                helper.insertArticle(a);
                startActivity(intent);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView text1,G,score,date;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Intent intent = getIntent();




}
}