package com.example.recipejournal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private final ArrayList<Kategori> kategoris;

    public KategoriAdapter(Context context, ArrayList<Kategori> kategoris){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.kategoris = kategoris;
    }

    @NonNull
    @Override
    public KategoriAdapter.KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.card_category, viewGroup, false);
        return new KategoriViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriAdapter.KategoriViewHolder holder, int position) {
        Kategori currentKategori = kategoris.get(position);

        holder.cardText.setText(currentKategori.getName());

        try{
            InputStream ins = context.getAssets().open(currentKategori.getImage());
            Drawable d = Drawable.createFromStream(ins, null);
            holder.cardImage.setImageDrawable(d);
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return kategoris.size();
    }

    public class KategoriViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView cardText;
        public final ImageView cardImage;
        final KategoriAdapter mAdapter;

        public KategoriViewHolder(@NonNull View itemView, KategoriAdapter kategoriAdapter) {
            super(itemView);
            this.cardText = itemView.findViewById(R.id.kartu_nama);
            this.cardImage = itemView.findViewById(R.id.kartu_gambar);
            this.mAdapter = kategoriAdapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            int mPosition = getLayoutPosition();
            String kategori = kategoris.get(mPosition).getName();

            Intent intent = new Intent(context, ListMakanan.class);
            intent.putExtra("kategori", kategori);

            context.startActivity(intent);
        }
    }
}
