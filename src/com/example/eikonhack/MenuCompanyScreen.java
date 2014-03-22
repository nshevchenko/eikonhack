package com.example.eikonhack;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;



public class MenuCompanyScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.menu_company_screen);
		showLoadingDialog();
		//comments
		findElements();
	}

	Button analyzeButton;
	TextView companyName, companyIndustry, arrow;
	ExpandableTextView companySummary;
	
	public void findElements()
	{
		companyName = (TextView)findViewById(R.id.nameCompany);
		companyName.setText(ViewController.getCompany().getName());

		companyIndustry = (TextView)findViewById(R.id.industryCompany);
		ViewController.getCompany().setIndustry("Networking");
		companyIndustry.setText(ViewController.getCompany().getIndustry());
		
		companySummary = (ExpandableTextView)findViewById(R.id.summmaryText);
		String text = "Facebook is an online social networking service. Its name comes from a colloquialism for the directory given to students at some American universities.[5] Facebook was founded on February 4, 2004 by Mark Zuckerberg with his college roommates and fellow Harvard University students Eduardo Saverin, Andrew McCollum, Dustin Moskovitz and Chris Hughes.[6] The founders had initially limited the website's membership to Harvard students, but later expanded it to colleges in the Boston area, the Ivy League, and Stanford University. It gradually added support for students at various other universities before it opened to high-school students, and eventually to anyone aged 13 and over. Facebook now allows anyone who claims to be at least 13 years old to become a registered user of the website";
		companySummary.setText(text);
		
		arrow = (TextView)findViewById(R.id.summmaryOpenClose);
	       
		arrow.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
                ExpandableTextView exp = (ExpandableTextView)findViewById(R.id.summmaryText);
                
                if(exp.click())
                	arrow.setText("U+25B2");
                else
                	arrow.setText("&#x25BC");
            }
		});
		
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
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.logo_screen, menu);
//		return true;
//	}

}
