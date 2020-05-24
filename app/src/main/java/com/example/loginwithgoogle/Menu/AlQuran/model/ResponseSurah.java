package com.example.loginwithgoogle.Menu.AlQuran.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseSurah{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSurah{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}