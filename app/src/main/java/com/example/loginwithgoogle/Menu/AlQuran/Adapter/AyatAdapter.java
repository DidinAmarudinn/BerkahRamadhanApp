package com.example.loginwithgoogle.Menu.AlQuran.Adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginwithgoogle.DatabaseLocal.Helper;
import com.example.loginwithgoogle.Menu.AlQuran.BottomShetDialogFragment;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.AyahsItem;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.Data;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.Text;
import com.example.loginwithgoogle.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.ViewHolder>implements Serializable {
    private Context context;
    List<AyahsItem> ayahsItems;
    Data data;
    Helper helper;


    public AyatAdapter(Context context, List<AyahsItem> ayahsItems, Data data) {
        this.context = context;
        this.ayahsItems = ayahsItems;
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ayat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_arab.setText(ayahsItems.get(position).getText().getArab());
        holder.tv_artinya.setText("Artinya: "+ayahsItems.get(position).getText().getId());
        String numberAyat= String.valueOf(ayahsItems.get(position).getNumberInSurah());
        holder.tv_number_ayat.setText(numberAyat);
        holder.tv_latin.setText(ayahsItems.get(position).getText().getLatin());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getAudio= String.valueOf(ayahsItems.get(position).getAudio());
                String  na= String.valueOf(ayahsItems.get(position).getNumberInSurah());
                helper=new Helper(holder.itemView.getContext());
                helper.putAudio(getAudio);
                helper.putAyat(na);
                BottomShetDialogFragment bottomShetDialogFragment=new BottomShetDialogFragment();
                Log.d("audio",helper.getAUDIO_LINK());
                bottomShetDialogFragment.show(((FragmentActivity)context).getSupportFragmentManager(),bottomShetDialogFragment.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return ayahsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_arab,tv_artinya,tv_number_ayat,tv_latin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_arab=itemView.findViewById(R.id.tv_arab);
            tv_latin=itemView.findViewById(R.id.tv_latin);
            tv_artinya=itemView.findViewById(R.id.tv_artinya);
            tv_number_ayat=itemView.findViewById(R.id.number_ayat);
        }
    }

}
