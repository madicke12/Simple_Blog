package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView articleList ;
        articleList = findViewById(R.id.articles);



        List<Article> listAr = new ArrayList<>();
        listAr = getAllArticles();

        List<Article> articles =getAllArticles();

        ArticleAdapter adapter = new ArticleAdapter(this, articles);
        articleList.setAdapter(adapter);
        articleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article article = articles.get(position);
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra("article.date", article.getDate());
                intent.putExtra("article.auteur",article.getAuteur());
                intent.putExtra("article.contenu",article.getDescription());
                intent.putExtra("article.titre",article.getTitle());
                startActivity(intent);
            }
        });

    }

    helper h = new helper(this);
    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();

        Cursor cursor = h.readAllData();

        while (cursor.moveToNext()) {

            String title = cursor.getString(cursor.getColumnIndex(helper.COLUMN_TITLE));
            String description = cursor.getString(cursor.getColumnIndex(helper.COLUMN_DESCRIPTION));
            String auteur = cursor.getString(cursor.getColumnIndex(helper.COLUMN_AUTEUR));
            String date= cursor.getString(cursor.getColumnIndex(helper.COLUMN_Date));
            Article article = new Article( title ,auteur,date, description);
            articles.add(article);
        }

        cursor.close();
        return articles;
    }



    public void onClick(View view) {
        switch (view.getId()){
           case R.id.Btn:
               Intent intent = new Intent(MainActivity.this, MainActivity2.class);
               startActivity(intent);
               break;



       }


    }

}


   /* EditText lieu,gagnant ,date ,score ;
        switch (view.getId()){
        case  R.id.soumettre:
            Intent intent = new Intent(MainActivity.this, MainActivity2.class)
            intent.putExtra("Lieu",lieu.getText().toString());
            startActivity(intent);
            break;*/