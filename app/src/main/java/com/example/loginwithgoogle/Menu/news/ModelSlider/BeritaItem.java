package com.example.loginwithgoogle.Menu.news.ModelSlider;

import com.google.gson.annotations.SerializedName;

public class BeritaItem{

	@SerializedName("isi_posts")
	private String isiPosts;

	@SerializedName("tgl_post")
	private String tglPost;

	@SerializedName("user_potos")
	private String userPotos;

	@SerializedName("image_posts")
	private String imagePosts;

	@SerializedName("kategori")
	private String kategori;

	@SerializedName("id")
	private String id;

	@SerializedName("judul")
	private String judul;

	public void setIsiPosts(String isiPosts){
		this.isiPosts = isiPosts;
	}

	public String getIsiPosts(){
		return isiPosts;
	}

	public void setTglPost(String tglPost){
		this.tglPost = tglPost;
	}

	public String getTglPost(){
		return tglPost;
	}

	public void setUserPotos(String userPotos){
		this.userPotos = userPotos;
	}

	public String getUserPotos(){
		return userPotos;
	}

	public void setImagePosts(String imagePosts){
		this.imagePosts = imagePosts;
	}

	public String getImagePosts(){
		return imagePosts;
	}

	public void setKategori(String kategori){
		this.kategori = kategori;
	}

	public String getKategori(){
		return kategori;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	@Override
 	public String toString(){
		return 
			"BeritaItem{" + 
			"isi_posts = '" + isiPosts + '\'' + 
			",tgl_post = '" + tglPost + '\'' + 
			",user_potos = '" + userPotos + '\'' + 
			",image_posts = '" + imagePosts + '\'' + 
			",kategori = '" + kategori + '\'' + 
			",id = '" + id + '\'' + 
			",judul = '" + judul + '\'' + 
			"}";
		}
}