package com.example.loginwithgoogle.Menu.feeds.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseFeeds{

	@SerializedName("berita")
	private List<FeedsItem> berita;

	@SerializedName("status")
	private boolean status;

	public void setBerita(List<FeedsItem> berita){
		this.berita = berita;
	}

	public List<FeedsItem> getBerita(){
		return berita;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseFeeds{" + 
			"berita = '" + berita + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}