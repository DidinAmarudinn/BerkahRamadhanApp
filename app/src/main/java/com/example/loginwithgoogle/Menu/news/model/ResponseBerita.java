package com.example.loginwithgoogle.Menu.news.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBerita extends BeritaItem {
	@SerializedName("berita")
	private List<BeritaItem> berita;

	@SerializedName("status")
	private boolean status;

	public void setBerita(List<BeritaItem> berita){
		this.berita = berita;
	}

	public List<BeritaItem> getBerita(){
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
				"ResponseBerita{" +
						"berita = '" + berita + '\'' +
						",status = '" + status + '\'' +
						"}";
	}
}