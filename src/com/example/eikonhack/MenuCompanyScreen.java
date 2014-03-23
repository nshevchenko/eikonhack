package com.example.eikonhack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MenuCompanyScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.menu_company_screen);

		findElements();
		applyValues();
	}

	Button analyzeButton;
	TextView companyName, companyIndustry, arrow ;
	ExpandableTextView companySummary;
	
	Button moveR, moveL;
	View line, newsByDateButton;
	ImageView graph;
	boolean touching = false;
	
	
	public void findElements()
	{
		newsByDateButton = (View)findViewById(R.id.newsByDateButton);
		line = (View)findViewById(R.id.dynamicBar);
		companyName = (TextView)findViewById(R.id.nameCompany);
		companyIndustry = (TextView)findViewById(R.id.industryCompany);
		companySummary = (ExpandableTextView)findViewById(R.id.summmaryText);
		arrow = (TextView)findViewById(R.id.summmaryOpenClose);  
		graph = (ImageView)findViewById(R.id.graph);
		View layout = (View)findViewById(R.id.relativeGraph);
		addTouchListener(layout);
		
		newsByDateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
//				ViewController.getCompany().setName(editText.getText().toString());
				Intent intent = new Intent(MenuCompanyScreen.this, NewsVisualizerScreen.class);
				startActivity(intent);
			}
		});
	}
	
	public void addTouchListener(View layout)
	{
		layout.setOnTouchListener(new OnTouchListener() {
		    public boolean onTouch(View v, MotionEvent event) {
		       
		    	move(event.getRawX());
		        
		        if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
		        	touching = false;
			    }
		        return true;
		    }
		    
		});
	}
	
	float startPosL;
	float startPos;
	float startPosR;
	ViewGroup.MarginLayoutParams graphData;
	
	public void move(float position)
	{
		
		graphData = (ViewGroup.MarginLayoutParams) graph.getLayoutParams();
		if(!touching)
		{
			startPos = position;
			startPosL = graphData.leftMargin;
			startPosR = graphData.rightMargin;
			touching = true;
		}
		float delta = startPos - position;
		
		if(graphData.leftMargin <= -1518 && delta > 0)
			delta = 0;
		else if(graphData.rightMargin<-1518 && delta < 0)
			delta = 0;
		else 
		{	
			delta = startPos - position;
			graphData.setMargins((int)startPosL-((int)delta), graphData.topMargin, (int)startPosR+(int)delta, graphData.bottomMargin);
			graph.requestLayout();
			updateDate();
		}
	}
	
	public void updateDate()
	{

		double total = graphData.leftMargin -240;
		int unit = (int)(-total/56);
		TextView newsTitle = (TextView)findViewById(R.id.newsTitle);
		String date = "" + unit +"/03/2014";
		if(unit<10)
			date = "0" + unit +"/03/2014";
		newsTitle.setText("News by date : " + date);
		
	}
	
	public void applyValues()
	{
		arrow.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
                ExpandableTextView exp = (ExpandableTextView)findViewById(R.id.summmaryText);
                
                if(exp.click())
                	arrow.setText(Html.fromHtml("&#9660;"));
                else
                	arrow.setText(Html.fromHtml("&#9650;"));
            }
		});
		
		companyName.setText(ViewController.getCompany().getName());

		ViewController.getCompany().setIndustry("Networking");
		companyIndustry.setText(ViewController.getCompany().getIndustry());
		
		String text = "Facebook is an online social networking service. Its name comes from a colloquialism for the directory given to students at some American universities.[5] Facebook was founded on February 4, 2004 by Mark Zuckerberg with his college roommates and fellow Harvard University students Eduardo Saverin, Andrew McCollum, Dustin Moskovitz and Chris Hughes.[6] The founders had initially limited the website's membership to Harvard students, but later expanded it to colleges in the Boston area, the Ivy League, and Stanford University. It gradually added support for students at various other universities before it opened to high-school students, and eventually to anyone aged 13 and over. Facebook now allows anyone who claims to be at least 13 years old to become a registered user of the website";
		companySummary.setText(text);
	}


}
