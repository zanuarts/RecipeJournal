package com.example.recipejournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListMakanan extends AppCompatActivity {
    private RecyclerView rv;
    private ResepAdapter adapter;
    private ArrayList<Resep> recipes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_makanan);

        recipes = new JsonParser(this).getRecipesArrayList();
        adapter = new ResepAdapter(this, recipes);

        rv = findViewById(R.id.recycler);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
