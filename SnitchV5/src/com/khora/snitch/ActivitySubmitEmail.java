package com.khora.snitch;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.khora.snitch.R.layout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ActivitySubmitEmail extends ActionBarActivity {

	public DrawerLayout mDrawerLayout;
	public FrameLayout drawerLayout;
	public FrameLayout fragmentContainer;
	public int currentFragment;
	public static RequestSignUp signUpRequest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.abs_layout);
		setContentView(R.layout.activity_submit_email);
		
		// Navigation Drawer Settings
		mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_navigation_drawer);
		drawerLayout = (FrameLayout) findViewById(R.id.left_drawer);
		// Fragment Container Settings
		fragmentContainer = (FrameLayout) findViewById(R.id.content_frame);

		// ActionBarButtonSettings
		Button ActionBarDrawerButton = (Button) findViewById(R.id.btnOpenDrawer);
		ActionBarDrawerButton.setVisibility(Button.GONE);

		// Initialize Request Veriable
		signUpRequest = new RequestSignUp();

		// Set First Fragment
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		android.support.v4.app.Fragment fragment = FragmentSubmitEmail
				.newInstance();

		fragmentTransaction.replace(R.id.content_frame, fragment);
		fragmentTransaction.commit();
		currentFragment = 1;

	}

	public void btnNextPressedForSubmitEmailFragment(View v) {

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		android.support.v4.app.Fragment fragment = FragmentSubmitEmailNext
				.newInstance();

		fragmentTransaction.replace(R.id.content_frame, fragment);
		fragmentTransaction.commit();
		currentFragment = 2;

	}

	public void btnPrevPressedForSubmitEmailFragment(View v) {

		if (currentFragment == 1) {

			finish();
		}
		if (currentFragment == 2) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();

			android.support.v4.app.Fragment fragment = FragmentSubmitEmail
					.newInstance();

			fragmentTransaction.replace(R.id.content_frame, fragment);
			fragmentTransaction.commit();
			currentFragment = 1;

		}
	}

	@SuppressWarnings("unused")
	public void btnFinishPressedForSubmitEmailFragment(View v) {
		// Saved Instances Again
		
		
		
		String FailNameSurname = "Lütfen Adınızı ve Soyadınızı Birer boşluk bırakarak yazınız";
		String FailPassword = "Lütfen şifrenizi Türkçe karakter kullanmadan ve en az 6 hane olacak şekilde yazın";
		String FailEmail = "Mail adresi geçerli değil. Lütfen uygun bir mail adresi yazın";
		boolean isFailNameSurname, isFailPassword, isFailEmail;
		signUpRequest.setEmail(FragmentSubmitEmailNext.Email.getText()
				.toString());
		signUpRequest.setPassword(FragmentSubmitEmailNext.Password.getText()
				.toString());
		signUpRequest.setPhoneNumber(FragmentSubmitEmailNext.PhoneNumber
				.getText().toString());

		
		if (signUpRequest.getSurname().equals("")
				|| signUpRequest.getName().equals(""))

			isFailNameSurname = true;

		else
			isFailNameSurname = false;
		if (signUpRequest.getPassword().equals(""))
			isFailPassword = true;
		else
			isFailPassword = false;
		if (signUpRequest.getEmail().equals("") || !isEmailValid(signUpRequest.getEmail()))
			isFailEmail = true;
		else 
			isFailEmail = false;
		
		//Şifre türkçe karakter içeriyor mu onu kontrol et
		
		
		if(isFailEmail || isFailNameSurname || isFailPassword)
		{
			VievCustomDialog dialog = new VievCustomDialog(ActivitySubmitEmail.this);
			
			TextView tvWarning = (TextView) dialog.findViewById(R.id.tvWarning);
			String warning="";
			if(isFailNameSurname)
			{
				warning += "  - " + FailNameSurname + "\n\n";
				
			}
			if(isFailEmail)
			{
				warning += "  - " + FailEmail + "\n\n";
				
			}
			if(isFailPassword)
			{
				warning += "  - " + FailPassword + "\n\n";
				
			}
			tvWarning.setText(warning);
			dialog.show();
			
			
		}
		else
		{
			//Success
			
		}
		
		
		

	}

	public static boolean isEmailValid(String email) {
		boolean isValid = false;

		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}


}

