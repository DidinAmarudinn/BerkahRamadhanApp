package com.example.loginwithgoogle.Menu.AlQuran.modelayat;

import com.google.gson.annotations.SerializedName;

public class Text{

	@SerializedName("en")
	private String en;

	@SerializedName("latin")
	private String latin;

	@SerializedName("id")
	private String id;

	@SerializedName("arab")
	private String arab;

	public void setEn(String en){
		this.en = en;
	}

	public String getEn(){
		return en;
	}

	public void setLatin(String latin){
		this.latin = latin;
	}

	public String getLatin(){
		return latin;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setArab(String arab){
		this.arab = arab;
	}

	public String getArab(){
		return arab;
	}

	@Override
 	public String toString(){
		return 
			"Text{" + 
			"en = '" + en + '\'' + 
			",latin = '" + latin + '\'' + 
			",id = '" + id + '\'' + 
			",arab = '" + arab + '\'' + 
			"}";
		}
}