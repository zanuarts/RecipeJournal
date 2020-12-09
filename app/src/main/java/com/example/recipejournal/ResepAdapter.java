package com.example.recipejournal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
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
    private final ArrayList<Model> listResep;

    public ResepAdapter(Context context, ArrayList<Model> listResep){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listResep = listResep;
    }

    @NonNull
    @Override
    public ResepAdapter.ResepViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.activity_main, viewGroup, false);
        return new ResepViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ResepAdapter.ResepViewHolder holder, int position) {
        Model posisiResep = listResep.get(position);
        holder.cardText.setText(posisiResep.getNama());
        try{
            InputStream ins = context.getAssets().open(posisiResep.getGambar());
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
        return 0;
    }

    public class ResepViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView cardText;
        public final ImageView cardImage;
        final ResepAdapter mAdapter;

        public ResepViewHolder(@NonNull View itemView, ResepAdapter adapter) {
            super(itemView);
            this.cardText = itemView.findViewById(R.id.card_text);
            this.cardImage = itemView.findViewById(R.id.card_image);
            this.mAdapter = adapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            int mPosition = getLayoutPosition();
            Model resep = listResep.get(mPosition);

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("resep", resep);

            context.startActivity(intent);
        }
    }
}
