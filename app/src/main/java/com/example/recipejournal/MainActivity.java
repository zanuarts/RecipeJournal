package com.example.recipejournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView ayam = findViewById(R.id.kartu_ayam);
        CardView telur = findViewById(R.id.kartu_telur);
        CardView sayur = findViewById(R.id.kartu_sayur);
        telur.setOnClickListener(this);
        sayur.setOnClickListener(this);
        ayam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kartu_ayam:
                Intent moveIntent = new Intent(MainActivity.this, ListMakanan.class);
                startActivity(moveIntent);
                break;
            case R.id.kartu_telur:
                Intent telurIntent = new Intent(MainActivity.this, ListMakanan.class);
                startActivity(telurIntent);
                break;
            case R.id.kartu_sayur:
                Intent sayurIntent = new Intent(MainActivity.this, ListMakanan.class);
                startActivity(sayurIntent);
                break;
        }
    }
}
