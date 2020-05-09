package com.example.loginwithgoogle.Menu.JadwalShalat.Model;

import com.google.gson.annotations.SerializedName;

public class TodayWeather{

	@SerializedName("temperature")
	private String temperature;

	@SerializedName("pressure")
	private String pressure;

	public void setTemperature(String temperature){
		this.temperature = temperature;
	}

	public String getTemperature(){
		return temperature;
	}

	public void setPressure(String pressure){
		this.pressure = pressure;
	}

	public String getPressure(){
		return pressure;
	}

	@Override
 	public String toString(){
		return 
			"TodayWeather{" + 
			"temperature = '" + temperature + '\'' + 
			",pressure = '" + pressure + '\'' + 
			"}";
		}
}