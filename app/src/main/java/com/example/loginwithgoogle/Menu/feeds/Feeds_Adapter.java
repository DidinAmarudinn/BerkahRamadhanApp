package com.example.loginwithgoogle.Menu.feeds;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginwithgoogle.DatabaseLocal.FavoriteList;
import com.example.loginwithgoogle.Home.Favorite.FavoriteFragment;
import com.example.loginwithgoogle.Home.HomeFragment;
import com.example.loginwithgoogle.Menu.feeds.model.FeedsItem;
import com.example.loginwithgoogle.Menu.news.model.BeritaItem;
import com.example.loginwithgoogle.R;
import com.example.loginwithgoogle.Splash.MainActivity;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class Feeds_Adapter extends RecyclerView.Adapter<Feeds_Adapter.ViewHolder> {
    List<FeedsItem> list;
    int SHIMER_ITEM_NUMBER=2;
    public boolean showShimmer=true;
    Context context;
    public Feeds_Adapter(List<FeedsItem> list, Context context) {
        this.list = list;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_feed,parent,false);
      return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         if (showShimmer){
             holder.shimmerFrameLayout.startShimmer();
             holder.linearLayout.setBackground(null);
             holder.btn_share.setBackground(null);
             holder.btn_bookmark.setBackground(null);
         }else {
             holder.shimmerFrameLayout.hideShimmer();
             holder.shimmerFrameLayout.stopShimmer();
             holder.shimmerFrameLayout.setShimmer(null);
             final String url_gambar="http://192.168.43.231/apiberita/images_feed/"+list.get(position).getFotoFeed();
             Glide.with(holder.itemView.getContext()).
                     load(url_gambar)
                     .into(holder.img_feed);
             if (HomeFragment.favoriteDatabase.favoriteDao().isFavorite((list.get(position).getId()))==1)
                 holder.btn_bookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
             else
                 holder.btn_bookmark.setImageResource(R.drawable.ic_bookmark);
             holder.btn_bookmark.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     FavoriteList favoriteList=new FavoriteList();
                     int id=list.get(position).getId();
                     String image=list.get(position).getFotoFeed();
                     favoriteList.setId(id);
                     favoriteList.setImage(image);
                     if (HomeFragment.favoriteDatabase.favoriteDao().isFavorite(id)!=1){
                         Toast.makeText(holder.itemView.getContext(),"Disimpan"+favoriteList.getImage(),Toast.LENGTH_LONG).show();
                         holder.btn_bookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
                         HomeFragment.favoriteDatabase.favoriteDao().addData(favoriteList);
                     }else {
                         Toast.makeText(holder.itemView.getContext(),"Dihapus",Toast.LENGTH_LONG).show();
                         holder.btn_bookmark.setImageResource(R.drawable.ic_bookmark);
                         HomeFragment.favoriteDatabase.favoriteDao().delete(favoriteList);
                     }
                 }
             });
         }


    }
    @Override
    public int getItemCount() {
        return showShimmer?SHIMER_ITEM_NUMBER : list.size() ;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView img_feed;
         ImageView btn_bookmark,btn_share;
         LinearLayout linearLayout;
         ShimmerFrameLayout shimmerFrameLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_bookmark=itemView.findViewById(R.id.btn_bookmark);
            img_feed=itemView.findViewById(R.id.img_feed);
            btn_share=itemView.findViewById(R.id.btn_share);
            linearLayout=itemView.findViewById(R.id.linearLayoutfeeds);
            shimmerFrameLayout=itemView.findViewById(R.id.shimer_layout);
        }
    }
}
