package com.example.eikonhack;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;

public class LogoScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo_screen);
		showLoadingDialog();
		//comments
	}

	private ProgressDialog progress;



	public void showLoadingDialog() {
		ProgressDialog.show(this, "Loading...", "Analyzing your company!");
	}
	
	protected void onResume() {
	    dismissLoadingDialog();
	    super.onResume();
	}
	
	public void dismissLoadingDialog() {

	    if (progress != null && progress.isShowing()) {
	        progress.dismiss();
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logo_screen, menu);
		return true;
	}

}
