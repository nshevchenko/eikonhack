package com.example.eikonhack;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;



public class MenuCompanyScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.menu_company_screen);
		showLoadingDialog();
		//comments
		findElements();
	}

	Button analyzeButton;
	public void findElements()
	{
		TextView companyName = (TextView)findViewById(R.id.nameCompany);
		companyName.setText(ViewController.getCompany().getName());
		TextView companyIndustry = (TextView)findViewById(R.id.industryCompany);
		companyIndustry.setText(ViewController.getCompany().getIndustry());
		
//		analyzeButton = (Button)findViewById(R.id.analyzeButton);
		
//		analyzeButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				finish();
//			}
//		});
	}


	public void showLoadingDialog() {
		//ProgressDialog.show(this, "Loading...", "Analyzing your company!");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logo_screen, menu);
		return true;
	}

}
