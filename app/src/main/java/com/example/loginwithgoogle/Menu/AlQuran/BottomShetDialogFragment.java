package com.example.loginwithgoogle.Menu.AlQuran;

import android.app.Dialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.loginwithgoogle.DatabaseLocal.Helper;
import com.example.loginwithgoogle.Menu.AlQuran.Adapter.AyatAdapter;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.AyahsItem;
import com.example.loginwithgoogle.Menu.AlQuran.modelayat.Data;
import com.example.loginwithgoogle.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;


public class BottomShetDialogFragment extends BottomSheetDialogFragment {
    ImageView playorpause;
    private MediaPlayer mediaPlayer;
    private TextView tv_number_ayat,tv_ayat_murotal;
    Helper helper;

    public BottomShetDialogFragment() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bottom_sheet_layout,container,false);
        tv_ayat_murotal=view.findViewById(R.id.tv_ayat_murotal);
        tv_number_ayat=view.findViewById(R.id.tv_number_ayat);
        mediaPlayer=new MediaPlayer();
        helper=new Helper(getContext());
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        playorpause=view.findViewById(R.id.playorpause);
        tv_number_ayat.setText("Ayat"+" "+helper.getNUMBER_AYAT());
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                tooglePlayPause();
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playorpause.setImageResource(R.drawable.ic_play_arrow_black_24dp);
            }
        });;
        playorpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tooglePlayPause();
                getResourec();
            }
        });
        return view;
    }

    private void tooglePlayPause() {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            playorpause.setImageResource(R.drawable.ic_play_arrow_black_24dp);
        }else {
            mediaPlayer.start();
            playorpause.setImageResource(R.drawable.ic_pause_black_24dp);
        }
    }
    private void getResourec(){
        try {
            mediaPlayer.setDataSource(helper.getAUDIO_LINK());
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mediaPlayer !=null){
           if (mediaPlayer.isPlaying()){
               mediaPlayer.stop();
           }
        }mediaPlayer.release();
        mediaPlayer=null;
    }
}

