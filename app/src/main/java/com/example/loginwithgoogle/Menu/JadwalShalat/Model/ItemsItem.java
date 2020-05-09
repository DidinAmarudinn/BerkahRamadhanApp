package com.example.loginwithgoogle.Menu.JadwalShalat.Model;

import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("asr")
	private String asr;

	@SerializedName("isha")
	private String isha;

	@SerializedName("shurooq")
	private String shurooq;

	@SerializedName("date_for")
	private String dateFor;

	@SerializedName("dhuhr")
	private String dhuhr;

	@SerializedName("fajr")
	private String fajr;

	@SerializedName("maghrib")
	private String maghrib;

	public void setAsr(String asr){
		this.asr = asr;
	}

	public String getAsr(){
		return asr;
	}

	public void setIsha(String isha){
		this.isha = isha;
	}

	public String getIsha(){
		return isha;
	}

	public void setShurooq(String shurooq){
		this.shurooq = shurooq;
	}

	public String getShurooq(){
		return shurooq;
	}

	public void setDateFor(String dateFor){
		this.dateFor = dateFor;
	}

	public String getDateFor(){
		return dateFor;
	}

	public void setDhuhr(String dhuhr){
		this.dhuhr = dhuhr;
	}

	public String getDhuhr(){
		return dhuhr;
	}

	public void setFajr(String fajr){
		this.fajr = fajr;
	}

	public String getFajr(){
		return fajr;
	}

	public void setMaghrib(String maghrib){
		this.maghrib = maghrib;
	}

	public String getMaghrib(){
		return maghrib;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"asr = '" + asr + '\'' + 
			",isha = '" + isha + '\'' + 
			",shurooq = '" + shurooq + '\'' + 
			",date_for = '" + dateFor + '\'' + 
			",dhuhr = '" + dhuhr + '\'' + 
			",fajr = '" + fajr + '\'' + 
			",maghrib = '" + maghrib + '\'' + 
			"}";
		}
}