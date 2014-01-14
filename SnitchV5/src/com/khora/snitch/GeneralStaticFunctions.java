package com.khora.snitch;

import java.util.ArrayList;

import android.content.Context;
import android.widget.LinearLayout;

public class GeneralStaticFunctions {
	

	
	public static int convertDiptoPix(int dip, Context x) {
		float scale = x.getResources().getDisplayMetrics().density;
		return (int) ((dip - 0.5f) / scale);
	}

}
