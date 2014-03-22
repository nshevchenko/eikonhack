package com.example.eikonhack;

public class ViewController {

	private static Company company;
	
	public static Company getCompany()
	{
		return company;
	}
	
	public static void init()
	{
		if(company == null)
			company = new Company();
	}
}
