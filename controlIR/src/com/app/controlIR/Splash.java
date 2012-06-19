package com.app.controlIR;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle splashInstanceState) {
        super.onCreate(splashInstanceState);
        setContentView(R.layout.splash);
        Thread loader = new Thread(){
        	public void run(){
        		try{
        			sleep(2000);
        		}
        		catch(InterruptedException e){
        			e.printStackTrace();
        		}
        		finally{
        			Intent intentHome = new Intent("android.intent.action.MENU");
        			startActivity(intentHome);
        		}
        		
        	}
        };
        loader.start();
    }
}
