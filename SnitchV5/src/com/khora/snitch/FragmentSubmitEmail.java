package com.khora.snitch;

import javax.crypto.spec.IvParameterSpec;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FragmentSubmitEmail extends Fragment implements
		View.OnClickListener {

	public ImageView imgAvatar;
	public EditText etNameSurname;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.fragment_submit_email,
				container, false);
		// View Implementations

		imgAvatar = (ImageView) fragmentView.findViewById(R.id.ivAvatar);
		etNameSurname = (EditText) fragmentView
				.findViewById(R.id.etNameSurname);

		// Actionbar Settings
		Button prevBtn = (Button) getActivity().findViewById(
				R.id.btnPrevForSubmitEmailFragment);
		Button nextBtn = (Button) getActivity().findViewById(
				R.id.btnNextForSubmitEmailFragment);
		Button finishBtn = (Button) getActivity().findViewById(
				R.id.btnFinishForSubmitEmailNextFragment);

		prevBtn.setVisibility(View.VISIBLE);
		nextBtn.setVisibility(View.VISIBLE);
		finishBtn.setVisibility(View.GONE);

		// View On Click Events

		imgAvatar.setOnClickListener(this);
		// Initialize Views for Instance State

		if (ActivitySubmitEmail.signUpRequest.getProfilePicture() != null) {
			imgAvatar.setImageDrawable(ActivitySubmitEmail.signUpRequest
					.getProfilePicture());
		}
		if (ActivitySubmitEmail.signUpRequest.getSurname() == null) {

		} else {
			etNameSurname.setText(ActivitySubmitEmail.signUpRequest.getName()
					+ " " + ActivitySubmitEmail.signUpRequest.getSurname());
		}
		return fragmentView;
	}

	@Override
	public void onDestroy() {

		// ***In here code save the instances
		super.onDestroy();

		// Parsing Name And Surname
		try
		{
		String NameSurname = etNameSurname.getText().toString();
		String[] Splitted = NameSurname.split(" ");
		// Get Name
		String Name = "";
		if (Splitted.length > 0) {
			for (int i = 0; i < Splitted.length - 1; i++) {
				Name += Splitted[i] + " ";

			}
			
			// Get Surname
			String Surname = Splitted[Splitted.length - 1];
			
			Surname = Surname.trim();
			Name = Name.trim();
			ActivitySubmitEmail.signUpRequest.setSurname(Surname);
			ActivitySubmitEmail.signUpRequest.setName(Name);
			
			
		}
		ActivitySubmitEmail.signUpRequest.setProfilePicture(imgAvatar
				.getDrawable());
		
		}catch(Exception ex)
		{
			System.out.println("");
			
		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		// Image Selection

		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			Uri selectedImage = data.getData();

			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getActivity().getContentResolver().query(
					selectedImage, filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			imgAvatar.setImageBitmap(BitmapFactory.decodeFile(picturePath));
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent, "Select Picture"),
				20);

	}

	public static Fragment newInstance() {
		FragmentSubmitEmail mFrgment = new FragmentSubmitEmail();
		return mFrgment;
	}

}
