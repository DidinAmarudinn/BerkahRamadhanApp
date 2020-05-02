package com.example.loginwithgoogle.Menu.news.model;

public class BeritaItem{
	private String penulis;
	private String foto;
	private String id;
	private String judulBerita;
	private String tanggalPosting;
	private String isiBerita;

	public void setPenulis(String penulis){
		this.penulis = penulis;
	}

	public String getPenulis(){
		return penulis;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJudulBerita(String judulBerita){
		this.judulBerita = judulBerita;
	}

	public String getJudulBerita(){
		return judulBerita;
	}

	public void setTanggalPosting(String tanggalPosting){
		this.tanggalPosting = tanggalPosting;
	}

	public String getTanggalPosting(){
		return tanggalPosting;
	}

	public void setIsiBerita(String isiBerita){
		this.isiBerita = isiBerita;
	}

	public String getIsiBerita(){
		return isiBerita;
	}

	@Override
 	public String toString(){
		return 
			"BeritaItem{" + 
			"penulis = '" + penulis + '\'' + 
			",foto = '" + foto + '\'' + 
			",id = '" + id + '\'' + 
			",judul_berita = '" + judulBerita + '\'' + 
			",tanggal_posting = '" + tanggalPosting + '\'' + 
			",isi_berita = '" + isiBerita + '\'' + 
			"}";
		}
}
