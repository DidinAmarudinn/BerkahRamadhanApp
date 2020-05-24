package com.example.loginwithgoogle.Menu.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.loginwithgoogle.Menu.news.ModelSlider.BeritaItem;
import com.example.loginwithgoogle.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {
    public SliderAdapter(List<BeritaItem> list) {
        this.list = list;
    }

    List<BeritaItem> list=new ArrayList<>();

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_news,parent,false);
        return new SliderAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH holder, int position) {
        holder.tv_judul_slider.setText(list.get(position).getJudul());
        final String url_gambar="http://192.168.43.231/apiberita/images_slider/"+list.get(position).getImagePosts();
        Glide.with(holder.itemView.getContext()).load(url_gambar)
                .into(holder.img_slider);

    }


    @Override
    public int getCount() {
        return list.size();
    }

    public class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        TextView tv_judul_slider;
        ImageView img_slider;
        public SliderAdapterVH(View itemView) {
            super(itemView);
            img_slider=itemView.findViewById(R.id.img_slider);
            tv_judul_slider=itemView.findViewById(R.id.tv_judul_slider);
        }
    }
}
