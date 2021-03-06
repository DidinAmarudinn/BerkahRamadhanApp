package com.example.loginwithgoogle.Home.Favorite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginwithgoogle.DatabaseLocal.FavoriteDatabase;
import com.example.loginwithgoogle.DatabaseLocal.FavoriteList;
import com.example.loginwithgoogle.Home.HomeFragment;
import com.example.loginwithgoogle.R;

import java.util.List;

public class FavoriteFragment extends Fragment {
    ImageView empty;
    TextView tv_empety;
    RecyclerView rv_favorite;
    public static FavoriteDatabase favoriteDatabase;
    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_favorite, container, false);
        rv_favorite=view.findViewById(R.id.rv_favorite);
        tv_empety=view.findViewById(R.id.tv_empety);
        empty=view.findViewById(R.id.empety);
        rv_favorite.setLayoutManager(new LinearLayoutManager(getActivity()));
        favoriteDatabase= Room.databaseBuilder(getActivity(), FavoriteDatabase.class,"myfavdb").allowMainThreadQueries().build();
        LoadData();
        return view;
    }
    public void LoadData(){
        List<FavoriteList> favoriteLists=HomeFragment.favoriteDatabase.favoriteDao().getFavoriteData();
            FavoriteAdapter adapter=new FavoriteAdapter(favoriteLists,getContext());
            rv_favorite.setAdapter(adapter);
            if (adapter.getItemCount()==0){
                empty.setVisibility(View.VISIBLE);
                adapter.notifyDataSetChanged();
                tv_empety.setVisibility(View.VISIBLE);
            }
        adapter.setOnItemClickListener(new FavoriteAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                adapter.notifyDataSetChanged();
                empty.setVisibility(View.VISIBLE);
                tv_empety.setVisibility(View.VISIBLE);
            }
        });
    }

}
