package com.example.loginwithgoogle.Menu.feeds.model;

import com.google.gson.annotations.SerializedName;

public class FeedsItem {

	@SerializedName("foto_feed")
	private String fotoFeed;

	@SerializedName("id")
	private int id;

	public void setFotoFeed(String fotoFeed){
		this.fotoFeed = fotoFeed;
	}

	public String getFotoFeed(){
		return fotoFeed;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"BeritaItem{" + 
			"foto_feed = '" + fotoFeed + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}