package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class News extends AppCompatActivity {
    Button frag1btn,frag2btn,frag3btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);
        frag1btn = findViewById(R.id.crickbtn);
        frag2btn = findViewById(R.id.batbtn);
        frag3btn = findViewById(R.id.footballbtn);

        frag1btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                replaceFragment(new cricket());


            }
        });

        frag2btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                replaceFragment(new Batminton());


            }
        });

        frag3btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                replaceFragment(new Football());


            }
        });

        ImageView registerImageView = findViewById(R.id.add);


        registerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(News.this, AddNews.class);
                startActivity(intent);
            }
        });

        ImageView registerImageView2 = findViewById(R.id.edit);


        registerImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(News.this, EditNews.class);
                startActivity(intent);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fa = getSupportFragmentManager();
        FragmentTransaction ft = fa.beginTransaction();
        ft.replace(R.id.frameN, fragment);
        ft.commit();
    }
}