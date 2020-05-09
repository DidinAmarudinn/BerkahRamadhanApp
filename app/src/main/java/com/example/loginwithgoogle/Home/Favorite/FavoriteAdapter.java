package com.example.loginwithgoogle.Home.Favorite;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginwithgoogle.DatabaseLocal.FavoriteList;
import com.example.loginwithgoogle.R;

import java.util.List;


public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private static ItemClickListener ItemClickListener;
    private List<FavoriteList> lists;
    Context context;
    public FavoriteAdapter(List<FavoriteList> lists,Context context) {
        this.lists = lists;
        this.context=context;
    }
    public interface ItemClickListener {
        void onItemClick(int position, View v);
    }
    public void setOnItemClickListener(ItemClickListener myClickListener) {
        FavoriteAdapter.ItemClickListener = myClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_favorite,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavoriteList favoriteList=lists.get(position);
        final String url_gambar="http://192.168.43.231/apiberita/images_feed/"+favoriteList.getImage();
        Glide.with(context).load(url_gambar).into(holder.img_feed_fav);

        holder.btn_bookmark_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemClickListener.onItemClick(position,v);
                FavoriteFragment.favoriteDatabase.favoriteDao().delete(favoriteList);
                lists.remove(position);
                notifyDataSetChanged();
            }
        });

    }
    @Override
    public int getItemCount() {
        return lists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_feed_fav;
        private ImageView btn_bookmark_fav;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_feed_fav=itemView.findViewById(R.id.img_feed_fav);
            btn_bookmark_fav=itemView.findViewById(R.id.btn_bookmark_fav);
        }
    }
}
