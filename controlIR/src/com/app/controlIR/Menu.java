package com.app.controlIR;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends Activity implements CompoundButton.OnCheckedChangeListener{
	private String[] rooms = new String[] {"Living Room", "Bedroom", "Kitchen", "Dining Room"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		ListView listviewSettings = (ListView)findViewById(R.id.listSettings);
		
		String[] settings = getResources().getStringArray(R.array.settings_array);
		ArrayAdapter<String> settingsAdapter = new ArrayAdapter<String>(this, R.layout.settings_list_item, settings);
		listviewSettings.setAdapter(settingsAdapter);
		
		ImageButton btnRoomRefresh = (ImageButton)findViewById(R.id.btnRoomRefresh);
		btnRoomRefresh.setVisibility(View.VISIBLE);
		btnRoomRefresh.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//TODO Auto-generated method stub
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundColor(android.graphics.Color.rgb(0, 112, 187));
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundDrawable(null);
                    return true;
                }
                return false;
			}
		});
		
		TextView labelRoomName = (TextView)findViewById(R.id.textRoomName);
		labelRoomName.setVisibility(View.VISIBLE);
		
		Spinner spinnerRooms = (Spinner)findViewById(R.id.spinnerRoomSelect);
		spinnerRooms.setVisibility(View.GONE);
		
		ArrayAdapter<String> roomsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rooms);
		spinnerRooms.setAdapter(roomsAdapter);
		
		SlidingDrawer drawerHome = (SlidingDrawer)findViewById(R.id.drawerHome);
		
		drawerHome.open();
		
		Button btnActions = (Button)findViewById(R.id.btnActions);		
		btnActions.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//TODO Auto-generated method stub
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundColor(android.graphics.Color.rgb(0, 112, 187));
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundDrawable(null);
                    return true;
                }
                return false;
			}
		});
		
		Button btnRemotes = (Button)findViewById(R.id.btnRemotes);
		btnRemotes.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//TODO Auto-generated method stub
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundColor(android.graphics.Color.rgb(0, 112, 187));
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundDrawable(null);
                    return true;
                }
                return false;
			}
		});
		
		
        Switch switchToggleGPS = (Switch) findViewById(R.id.switchToggleGPS);
        if (switchToggleGPS != null) {
        	switchToggleGPS.setOnCheckedChangeListener(this);
        }		
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(isChecked == true){
			ImageButton btnRoomRefresh = (ImageButton)findViewById(R.id.btnRoomRefresh);
			btnRoomRefresh.setVisibility(View.VISIBLE);
			
			TextView labelRoomName = (TextView)findViewById(R.id.textRoomName);
			labelRoomName.setVisibility(View.VISIBLE);
			
			Spinner spinnerRooms = (Spinner)findViewById(R.id.spinnerRoomSelect);
			spinnerRooms.setVisibility(View.GONE);
		}
		else{
			ImageButton btnRoomRefresh = (ImageButton)findViewById(R.id.btnRoomRefresh);
			btnRoomRefresh.setVisibility(View.GONE);
			
			TextView labelRoomName = (TextView)findViewById(R.id.textRoomName);
			labelRoomName.setVisibility(View.GONE);
			
			Spinner spinnerRooms = (Spinner)findViewById(R.id.spinnerRoomSelect);
			spinnerRooms.setVisibility(View.VISIBLE);
		}
	}
	
	public void onHomeBtnClicked(View v) {
	    // Do something when the button is clicked
	    Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
	}
}