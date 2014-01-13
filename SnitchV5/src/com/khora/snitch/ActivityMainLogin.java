package com.khora.snitch;

import android.opengl.Visibility;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class ActivityMainLogin extends ActionBarActivity {

	public DrawerLayout mDrawerLayout;
	public FrameLayout drawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_login);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.abs_layout);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_navigation_drawer);
		drawerLayout = (FrameLayout) findViewById(R.id.left_drawer);
		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
		Button ActionBarDrawerButton = (Button) findViewById(R.id.btnOpenDrawer);
		ActionBarDrawerButton.setVisibility(Button.GONE);
		System.out.println("");
		
													

	}

	public void openDrawer() {

		mDrawerLayout.openDrawer(drawerLayout);
	}

	public void DrawerOpenClickEvent(View v) {
		
		openDrawer();

	}
}
