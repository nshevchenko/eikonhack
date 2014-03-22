package com.example.eikonhack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;



public class MainMenuScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_screen);
		showLoadingDialog();
		//comments
		findElements();
	}

	Button analyzeButton;
	public void findElements()
	{
		analyzeButton = (Button)findViewById(R.id.analyzeButton);
		
		analyzeButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainMenuScreen.this, MenuCompanyScreen.class);
				startActivity(intent);
				finish();
			}
		});
	}
	
	public void showLoadingDialog() {
//		private ProgressDialog progress;
		//ProgressDialog.show(this, "Loading...", "Analyzing your company!");
	}
	
//	protected void onResume() {
//	    dismissLoadingDialog();
//	    super.onResume();
//	}
	
//	public void dismissLoadingDialog() {
//
//	    if (progress != null && progress.isShowing()) {
//	        progress.dismiss();
//	    }
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logo_screen, menu);
		return true;
	}

}
