package com.example.recipejournal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private List<String> bahan;
    private List<String> langkah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Resep resep = (Resep)getIntent().getSerializableExtra("resep");
        renderResep(resep);
    }

    protected void renderResep(Resep res){
        TextView namaResep = ((TextView)findViewById(R.id.nama_resep));
        namaResep.setText(res.getNama());

        try {
            InputStream ins = this.getAssets().open(res.getGambar());
            Drawable d = Drawable.createFromStream(ins, null);
            ((ImageView)findViewById(R.id.gambar_resep)).setImageDrawable(d);
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((TextView)findViewById(R.id.waktu_masak)).setText(res.getWaktu());

        bahan = res.getBahan();
        String bahan_makan = "";
        try {
            for(int i=0; i<bahan.size(); i++){
                bahan_makan += (bahan.get(i));
                bahan_makan += "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        langkah = res.getResep();
        Log.d("LangkahArray", String.valueOf(langkah));
        String langkah_makan = "";
        try {
            for(int i=0; i<langkah.size(); i++){
                langkah_makan += (langkah.get(i));
                langkah_makan += "\n";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("Langkah", langkah_makan);


        ((TextView)findViewById(R.id.bahan_resep)).setText(bahan_makan);
        ((TextView)findViewById(R.id.langkah_resep)).setText(langkah_makan);
    }

    protected void bahanMakan(){

    }
}
