package com.example.recipejournal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ResepViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private final ArrayList<Resep> listResep;

    public ResepAdapter(Context context, ArrayList<Resep> listResep){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listResep = listResep;
    }

    @NonNull
    @Override
    public ResepAdapter.ResepViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.list_makanan, viewGroup, false);
        return new ResepViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ResepAdapter.ResepViewHolder holder, int position) {
        Resep currentResep = listResep.get(position);

        holder.cardText.setText(currentResep.getNama());
        holder.cardTime.setText(currentResep.getWaktu());
        try{
            InputStream ins = context.getAssets().open(currentResep.getGambar());
            Drawable d = Drawable.createFromStream(ins, null);
            holder.cardImage.setImageDrawable(d);
            ins.close();
        }
        catch (IOException e){
            e.getStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listResep.size();
    }

    public class ResepViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView cardText;
        public final ImageView cardImage;
        public final TextView cardTime;
        final ResepAdapter mAdapter;

        public ResepViewHolder(@NonNull View itemView, ResepAdapter adapter) {
            super(itemView);
            this.cardText = itemView.findViewById(R.id.card_name);
            this.cardImage = itemView.findViewById(R.id.card_image);
            this.cardTime = itemView.findViewById(R.id.card_waktu);
            this.mAdapter = adapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            int mPosition = getLayoutPosition();
            Resep resep = listResep.get(mPosition);

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("resep", resep);

            context.startActivity(intent);
        }
    }
}
