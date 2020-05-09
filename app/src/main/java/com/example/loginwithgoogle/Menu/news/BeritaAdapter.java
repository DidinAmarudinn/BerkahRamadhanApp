package com.example.loginwithgoogle.Menu.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.Menu.news.model.ResponseBerita;
import com.example.loginwithgoogle.R;

import java.util.ArrayList;
import java.util.List;
public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    List<BeritaItem> beritaItems;
    public BeritaAdapter(List<BeritaItem> beritaItems) {
        this.beritaItems = beritaItems;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_berita,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String url_gambar="http://192.168.43.231/apiberita/images/"+beritaItems.get(position).getFoto();
        holder.tv_judul_berita.setText(beritaItems.get(position).getJudulBerita());
        holder.tv_tgl_berita.setText(beritaItems.get(position).getTanggalPosting());
        Glide.with(holder.itemView.getContext())
                .load(url_gambar)
                .into(holder.img_berita);
    }
    @Override
    public int getItemCount() {
        return beritaItems.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_isi_berita,tv_judul_berita,tv_tgl_berita;
        private ImageView img_berita;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_judul_berita=itemView.findViewById(R.id.tv_judul_berita);
            tv_tgl_berita=itemView.findViewById(R.id.tv_tanggal_berita);
            img_berita=itemView.findViewById(R.id.img_berita);
        }
    }
}
