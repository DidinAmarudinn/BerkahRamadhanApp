package com.example.loginwithgoogle.Menu.news.model;

import java.util.List;

public class ResponseBerita{
	private List<BeritaItem> berita;
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