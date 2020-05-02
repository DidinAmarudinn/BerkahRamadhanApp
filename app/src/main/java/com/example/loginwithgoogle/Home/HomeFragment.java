package com.example.loginwithgoogle.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.loginwithgoogle.Menu.kiblat.KiblatAct;
import com.example.loginwithgoogle.Menu.news.NewsAct;
import com.example.loginwithgoogle.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
    RelativeLayout kiblatAct,newsAct;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        kiblatAct=view.findViewById(R.id.kiblatAct);
        newsAct=view.findViewById(R.id.newsAct);
        kiblatAct.setOnClickListener(this);
        newsAct.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.kiblatAct:
            Intent intent=new Intent(getActivity(),KiblatAct.class);
            startActivity(intent);
            break;
            case R.id.newsAct:
                Intent newsAct=new Intent(getActivity(), NewsAct.class);
                startActivity(newsAct);
                break;
        }
    }
}
