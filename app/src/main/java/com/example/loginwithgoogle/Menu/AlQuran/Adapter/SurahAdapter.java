package com.example.loginwithgoogle.Menu.AlQuran.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginwithgoogle.Menu.AlQuran.DetailSurah;
import com.example.loginwithgoogle.Menu.AlQuran.model.DataItem;
import com.example.loginwithgoogle.R;

import java.util.ArrayList;
import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.ViewHolder> {
    private List<DataItem> list=new ArrayList<>();
    Context context;


    public SurahAdapter(List<DataItem> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_surah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_name_surah.setText(list.get(position).getEnglishName());
        String numberSurah= String.valueOf(list.get(position).getNumber());
        String numberAyat= String.valueOf(list.get(position).getNumberOfAyahs());
        holder.tv_translate.setText(list.get(position).getEnglishNameTranslation()+" "+"("+numberAyat+")");
        holder.tv_name_arab.setText(list.get(position).getName());
        holder.tv_number_surah.setText(numberSurah);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailSurah.class);
                intent.putExtra("numbersurah",numberSurah);
                intent.putExtra("nameSurah",list.get(position).getEnglishName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView tv_number_surah,tv_name_surah,tv_translate,tv_name_arab;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_number_surah=itemView.findViewById(R.id.tv_number_surah);
            tv_name_arab=itemView.findViewById(R.id.tv_name_arab);
            tv_translate=itemView.findViewById(R.id.tv_translate);
            tv_name_surah=itemView.findViewById(R.id.tv_nama_surah);
        }
    }
}
