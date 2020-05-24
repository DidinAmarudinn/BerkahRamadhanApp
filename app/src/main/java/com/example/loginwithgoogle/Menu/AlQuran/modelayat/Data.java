package com.example.loginwithgoogle.Menu.AlQuran.modelayat;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("number")
	private int number;

	@SerializedName("englishName")
	private String englishName;

	@SerializedName("idRevelationType")
	private String idRevelationType;

	@SerializedName("numberOfAyahs")
	private int numberOfAyahs;

	@SerializedName("idNameTranslation")
	private String idNameTranslation;

	@SerializedName("revelationType")
	private String revelationType;

	@SerializedName("name")
	private String name;

	@SerializedName("ayahs")
	private List<AyahsItem> ayahs;

	@SerializedName("englishNameTranslation")
	private String englishNameTranslation;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setEnglishName(String englishName){
		this.englishName = englishName;
	}

	public String getEnglishName(){
		return englishName;
	}

	public void setIdRevelationType(String idRevelationType){
		this.idRevelationType = idRevelationType;
	}

	public String getIdRevelationType(){
		return idRevelationType;
	}

	public void setNumberOfAyahs(int numberOfAyahs){
		this.numberOfAyahs = numberOfAyahs;
	}

	public int getNumberOfAyahs(){
		return numberOfAyahs;
	}

	public void setIdNameTranslation(String idNameTranslation){
		this.idNameTranslation = idNameTranslation;
	}

	public String getIdNameTranslation(){
		return idNameTranslation;
	}

	public void setRevelationType(String revelationType){
		this.revelationType = revelationType;
	}

	public String getRevelationType(){
		return revelationType;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAyahs(List<AyahsItem> ayahs){
		this.ayahs = ayahs;
	}

	public List<AyahsItem> getAyahs(){
		return ayahs;
	}

	public void setEnglishNameTranslation(String englishNameTranslation){
		this.englishNameTranslation = englishNameTranslation;
	}

	public String getEnglishNameTranslation(){
		return englishNameTranslation;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"number = '" + number + '\'' + 
			",englishName = '" + englishName + '\'' + 
			",idRevelationType = '" + idRevelationType + '\'' + 
			",numberOfAyahs = '" + numberOfAyahs + '\'' + 
			",idNameTranslation = '" + idNameTranslation + '\'' + 
			",revelationType = '" + revelationType + '\'' + 
			",name = '" + name + '\'' + 
			",ayahs = '" + ayahs + '\'' + 
			",englishNameTranslation = '" + englishNameTranslation + '\'' + 
			"}";
		}
}