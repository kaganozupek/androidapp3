package com.khora.snitch;

import javax.crypto.spec.IvParameterSpec;

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
import android.webkit.WebView.FindListener;
import android.widget.ImageView;

public class FragmentSubmitEmail extends Fragment implements View.OnClickListener {
	
	private ImageView imgAvatar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.fragment_submit_email, container,false);
		//View Implementations
		
		imgAvatar = (ImageView) fragmentView.findViewById(R.id.ivAvatar);
		
		
		//View On Click Events
		
		imgAvatar.setOnClickListener(this);
		
		
		
		
		
		
		return fragmentView;
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		 Uri selectedImage = data.getData();
         String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
         Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                 filePathColumn, null, null, null);
         cursor.moveToFirst();
 
         int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
         String picturePath = cursor.getString(columnIndex);
         cursor.close();
         
         imgAvatar.setImageBitmap(BitmapFactory.decodeFile(picturePath));
         
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent, "Select Picture"), 20);
		
		
		
	}
	
	public static Fragment newInstance() {
		FragmentSubmitEmail mFrgment = new FragmentSubmitEmail();
		return mFrgment;
	}
	

}
