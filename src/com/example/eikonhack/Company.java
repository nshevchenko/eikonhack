package com.example.eikonhack;

public class Company {
	
	private String name,industry, summary;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setIndustry(String industry){
		this.industry = industry;
	}
	
	public void setSummary(String summary){
		this.summary = summary;
	}
	
	public String getName(){
		return name;
	}
	
	public String getIndustry(){
		return industry;
	}
	
	public String getSummary(){
		return summary;
	}
}
