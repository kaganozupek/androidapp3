package com.khora.snitch;

import com.khora.snitch.R.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class ActivitySubmitEmail extends ActionBarActivity {

	public DrawerLayout mDrawerLayout;
	public FrameLayout drawerLayout;
	public FrameLayout fragmentContainer;
	public int currentFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submit_email);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.abs_layout);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_navigation_drawer);
		drawerLayout = (FrameLayout) findViewById(R.id.left_drawer);
		fragmentContainer = (FrameLayout) findViewById(R.id.content_frame);
		
		
		// ActionBarButtonSettings
		Button ActionBarDrawerButton = (Button) findViewById(R.id.btnOpenDrawer);
		ActionBarDrawerButton.setVisibility(Button.GONE);
		Button nextBtn = (Button) findViewById(R.id.btnNextForSubmitEmailFragment);
		nextBtn.setVisibility(Button.VISIBLE);
		Button prevBtn = (Button)findViewById(R.id.btnPrevForSubmitEmailFragment);
		prevBtn.setVisibility(Button.VISIBLE);
		
		//Set First Fragment
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

				android.support.v4.app.Fragment fragment = FragmentSubmitEmail.newInstance();
				
				fragmentTransaction.replace(R.id.content_frame, fragment);
				fragmentTransaction.commit();
		currentFragment = 1;
		

	
	}

	
	public void btnNextPressedForSubmitEmailFragment(View v)
	{
		
		
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

						android.support.v4.app.Fragment fragment = FragmentSubmitEmailNext.newInstance();
						
						fragmentTransaction.replace(R.id.content_frame, fragment);
						fragmentTransaction.commit();
						currentFragment = 2;
		
		
	}
	public void btnPrevPressedForSubmitEmailFragment(View v)
	{
	
		if (currentFragment == 1 )
		{
		
		finish();
		}
		if(currentFragment == 2)
		{
			FragmentManager fragmentManager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

					android.support.v4.app.Fragment fragment = FragmentSubmitEmail.newInstance();
					
					fragmentTransaction.replace(R.id.content_frame, fragment);
					fragmentTransaction.commit();
			currentFragment = 1;
			
		}
	}
	
}
