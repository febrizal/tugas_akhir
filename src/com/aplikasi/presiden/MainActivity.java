package com.aplikasi.presiden;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   
        
        Thread timer = new Thread (){
	   public void run() {
		try {
			sleep (4000);
			}catch(InterruptedException e){
				e.printStackTrace();
				
			}finally{
				Intent i = new Intent(MainActivity.this , MenuutamaActivity.class );
				startActivity(i);
				finish();
			}
		    }
      
	 };
   timer.start();
    }

     
}
