package com.example.recipejournal;

import android.content.Context;

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

    public ArrayList<Model> getRecipesArrayList(){
        ArrayList<Model> models = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJson());
            Iterator<String> temp = obj.keys();
            while (temp.hasNext()){
                String key = temp.next();
                JSONObject jsonVal = (JSONObject)obj.get(key);

                String nama = jsonVal.get("nama").toString();
                String gambar = jsonVal.get("gambar").toString();
                String waktu = jsonVal.get("waktu").toString();

                JSONArray jsonArray = jsonVal.getJSONArray("bahan");
                List<String> bahan = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++){
                    bahan.add(jsonArray.getString(i));
                }

                jsonArray = jsonVal.getJSONArray("resep");
                List<String> resep = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++){
                    resep.add(jsonArray.getString(i));
                }

                Model model = new Model();
                model.setNama(nama);
                model.setGambar(gambar);
                model.setWaktu(waktu);
                model.setBahan(bahan);
                model.setResep(resep);

                models.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return models;
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
