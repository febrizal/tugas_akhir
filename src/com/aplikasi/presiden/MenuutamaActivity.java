package com.aplikasi.presiden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuutamaActivity extends Activity {

	Button Presiden;
	Button Wakil;
	Button Tentang;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuutama);

		Presiden=(Button)findViewById(R.id.button1);
		Presiden.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),PresidenActivity.class);
				startActivity(i);
				
		
			}
			
		
		});
		Wakil=(Button)findViewById(R.id.button2);
		Wakil.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),WakilActivity.class);
				startActivity(i);
			}
		});
	
	Tentang=(Button)findViewById(R.id.button4);
	Tentang.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(),TentangActivity.class);
			startActivity(i);
		}
	});
	
	}
	
	
	

}
