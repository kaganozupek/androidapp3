package com.khora.snitch;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.ToggleButton;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class ViewCustonToggle extends ToggleButton implements OnClickListener {

	public ViewCustonToggle(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}


	public AnimationDrawable goOn;
	public AnimationDrawable goOff;
	
	@Override
	protected void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
	
		goOn = (AnimationDrawable) getResources().getDrawable(R.drawable.switch_on_animation);
		goOff = (AnimationDrawable) getResources().getDrawable(R.drawable.switch_off_animation);
		this.setOnClickListener(this);
		if (isChecked()) {

			setBackgroundResource(R.drawable.switch_20027);

		} else {
			setBackgroundResource(R.drawable.switch_20000);

		}

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (isChecked()) {
			setBackground(goOn);
			goOn.stop();
			goOn.start();

		} else {
			setBackground(goOff);
			goOff.stop();
			goOff.start();

		}
	
		
		
	}
	
	

}
