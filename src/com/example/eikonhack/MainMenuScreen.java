package com.example.eikonhack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;



public class MainMenuScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main_menu_screen);
		ViewController.init();
		findElements();
	}

	Button analyzeButton;
	EditText editText;
	public void findElements()
	{
		analyzeButton = (Button)findViewById(R.id.analyzeButton);
		editText = (EditText) findViewById(R.id.companyNameString);

		analyzeButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ViewController.getCompany().setName(editText.getText().toString());
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
