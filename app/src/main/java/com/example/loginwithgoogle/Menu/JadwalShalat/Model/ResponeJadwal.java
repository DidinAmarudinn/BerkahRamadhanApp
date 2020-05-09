package com.example.loginwithgoogle.Menu.JadwalShalat.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponeJadwal{

	@SerializedName("country")
	private String country;

	@SerializedName("status_description")
	private String statusDescription;

	@SerializedName("address")
	private String address;

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("method")
	private int method;

	@SerializedName("prayer_method_name")
	private String prayerMethodName;

	@SerializedName("city")
	private String city;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("query")
	private String query;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("for")
	private String jsonMemberFor;

	@SerializedName("link")
	private String link;

	@SerializedName("qibla_direction")
	private String qiblaDirection;

	@SerializedName("title")
	private String title;

	@SerializedName("status_valid")
	private int statusValid;

	@SerializedName("sealevel")
	private String sealevel;

	@SerializedName("country_code")
	private String countryCode;

	@SerializedName("daylight")
	private int daylight;

	@SerializedName("today_weather")
	private TodayWeather todayWeather;

	@SerializedName("state")
	private String state;

	@SerializedName("postal_code")
	private String postalCode;

	@SerializedName("items")
	private List<ItemsItem> items;

	@SerializedName("map_image")
	private String mapImage;

	@SerializedName("longitude")
	private String longitude;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setStatusDescription(String statusDescription){
		this.statusDescription = statusDescription;
	}

	public String getStatusDescription(){
		return statusDescription;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setMethod(int method){
		this.method = method;
	}

	public int getMethod(){
		return method;
	}

	public void setPrayerMethodName(String prayerMethodName){
		this.prayerMethodName = prayerMethodName;
	}

	public String getPrayerMethodName(){
		return prayerMethodName;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setJsonMemberFor(String jsonMemberFor){
		this.jsonMemberFor = jsonMemberFor;
	}

	public String getJsonMemberFor(){
		return jsonMemberFor;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setQiblaDirection(String qiblaDirection){
		this.qiblaDirection = qiblaDirection;
	}

	public String getQiblaDirection(){
		return qiblaDirection;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setStatusValid(int statusValid){
		this.statusValid = statusValid;
	}

	public int getStatusValid(){
		return statusValid;
	}

	public void setSealevel(String sealevel){
		this.sealevel = sealevel;
	}

	public String getSealevel(){
		return sealevel;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setDaylight(int daylight){
		this.daylight = daylight;
	}

	public int getDaylight(){
		return daylight;
	}

	public void setTodayWeather(TodayWeather todayWeather){
		this.todayWeather = todayWeather;
	}

	public TodayWeather getTodayWeather(){
		return todayWeather;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	public void setMapImage(String mapImage){
		this.mapImage = mapImage;
	}

	public String getMapImage(){
		return mapImage;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"ResponeJadwal{" + 
			"country = '" + country + '\'' + 
			",status_description = '" + statusDescription + '\'' + 
			",address = '" + address + '\'' + 
			",status_code = '" + statusCode + '\'' + 
			",method = '" + method + '\'' + 
			",prayer_method_name = '" + prayerMethodName + '\'' + 
			",city = '" + city + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",query = '" + query + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",for = '" + jsonMemberFor + '\'' + 
			",link = '" + link + '\'' + 
			",qibla_direction = '" + qiblaDirection + '\'' + 
			",title = '" + title + '\'' + 
			",status_valid = '" + statusValid + '\'' + 
			",sealevel = '" + sealevel + '\'' + 
			",country_code = '" + countryCode + '\'' + 
			",daylight = '" + daylight + '\'' + 
			",today_weather = '" + todayWeather + '\'' + 
			",state = '" + state + '\'' + 
			",postal_code = '" + postalCode + '\'' + 
			",items = '" + items + '\'' + 
			",map_image = '" + mapImage + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}