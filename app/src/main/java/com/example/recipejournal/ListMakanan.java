package com.example.recipejournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListMakanan extends AppCompatActivity {
    private RecyclerView rv;
    private ResepAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_makanan);

        String kategori = getIntent().getStringExtra("kategori");

        ArrayList<Resep> reseps = new JsonParser(this).getResep(kategori);
        adapter = new ResepAdapter(this, reseps);

        rv = findViewById(R.id.list_recycler);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
