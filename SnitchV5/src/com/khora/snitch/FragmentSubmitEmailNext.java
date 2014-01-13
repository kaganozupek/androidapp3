package com.khora.snitch;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentSubmitEmailNext extends Fragment {
	
	private ImageView imgAvatar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.fragment_submit_email_next, container,false);
		//View Implementations
		
		
		
		
		
		
		
		return fragmentView;
	}
	
	
	
	public static Fragment newInstance() {
		FragmentSubmitEmailNext mFrgment = new FragmentSubmitEmailNext();
		return mFrgment;
	}


}
