package com.example.loginwithgoogle.Menu.news;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;
public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    List<BeritaItem> beritaItems;
    public boolean shimerShow=true;
    int shimerItem=4;
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
       if (shimerShow){
           holder.shimmerFrameLayout.startShimmer();
       }else {
           holder.shimmerFrameLayout.stopShimmer();
           holder.shimmerFrameLayout.setShimmer(null);
           holder.img_berita.setBackground(null);
           holder.img_user.setBackground(null);
           holder.tv_user_name.setBackground(null);
           holder.tv_judul_berita.setBackground(null);
           holder.tv_tgl_berita.setBackground(null);
           holder.tv_isi_berita.setBackground(null);
           final String url_gambar="http://192.168.43.231/apiberita/images/"+beritaItems.get(position).getFoto();
           String isiBerita= Html.fromHtml(beritaItems.get(position).getIsiBerita()).toString();
           holder.tv_judul_berita.setText(beritaItems.get(position).getJudulBerita());
           holder.tv_tgl_berita.setText(beritaItems.get(position).getTanggalPosting());
           holder.tv_isi_berita.setText(isiBerita);
           Glide.with(holder.itemView.getContext())
                   .load(url_gambar)
                   .into(holder.img_berita);
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(holder.itemView.getContext(),Detail_News.class);
                    intent.putExtra("judul_berita",beritaItems.get(position).getJudulBerita());
                    String isiBeritaDet= Html.fromHtml(beritaItems.get(position).getIsiBerita()).toString();
                    intent.putExtra("isi_berita",isiBeritaDet);
                    intent.putExtra("tg_berita",beritaItems.get(position).getTanggalPosting());
                    intent.putExtra("foto",beritaItems.get(position).getFoto());
                    holder.itemView.getContext().startActivity(intent);
               }
           });
       }
    }
    @Override
    public int getItemCount() {
        return shimerShow?shimerItem : beritaItems.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_isi_berita,tv_judul_berita,tv_tgl_berita,tv_user_name;
        private ImageView img_berita,img_user;
        ShimmerFrameLayout shimmerFrameLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_judul_berita=itemView.findViewById(R.id.tv_judul_berita);
            tv_isi_berita=itemView.findViewById(R.id.tv_isi_berita);
            tv_user_name=itemView.findViewById(R.id.tv_user_name);
            img_user=itemView.findViewById(R.id.img_user);
            tv_tgl_berita=itemView.findViewById(R.id.tv_tangal_berita);
            img_berita=itemView.findViewById(R.id.img_berita);
            shimmerFrameLayout=itemView.findViewById(R.id.shimer_layout_news);
        }
    }
}
