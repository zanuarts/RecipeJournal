package com.example.recipejournal;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonParser {

    private Context context;

    public JsonParser(Context context){
        this.context = context;
    }

    public ArrayList<Kategori> getKategori(){
        ArrayList<Kategori> kategoris = new ArrayList<>();

        try{
            JSONObject obj = new JSONObject(loadJson());
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()){
                String key = keys.next();
                JSONObject jsonVal = (JSONObject)obj.get(key);

                String name = key;
                String image = jsonVal.get("image").toString();

                Kategori kategori = new Kategori();
                kategori.setName(name);
                kategori.setImage(image);

                kategoris.add(kategori);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return kategoris;
    }

    public ArrayList<Resep> getRecipesArrayList(){
        ArrayList<Resep> reseps = new ArrayList<>();

        try {
            JSONArray obj = new JSONObject(loadJson())
                    .getJSONObject("Ayam")
                    .getJSONArray("recipe");

            for (int i = 0; i < obj.length(); i++){
                JSONObject jsonVal = obj.getJSONObject(i);

                String nama = jsonVal.get("nama").toString();
                String gambar = jsonVal.get("gambar").toString();
                String waktu = jsonVal.get("waktu").toString();

                Log.d("RecipeName", nama);
                Log.d("RecipeImage", gambar);
                Log.d("RecipeURL", waktu);

                JSONArray jsonArray = jsonVal.getJSONArray("bahan");
                List<String> bahan = new ArrayList<>();
                for (int j = 0; i < jsonArray.length(); i++){
                    bahan.add(jsonArray.getString(j));
                }

                jsonArray = jsonVal.getJSONArray("resep");
                List<String> resep = new ArrayList<>();
                for (int j = 0; i < jsonArray.length(); i++){
                    resep.add(jsonArray.getString(j));
                }

                Resep recipe = new Resep();
                recipe.setNama(nama);
                recipe.setGambar(gambar);
                recipe.setWaktu(waktu);
                recipe.setBahan(bahan);
                recipe.setResep(resep);

                reseps.add(recipe);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return reseps;
    }

    public String loadJson(){
        String json = null;
        try {
            InputStream is = context.getAssets().open("recipes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
