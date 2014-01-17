package com.khora.snitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class FragmentMainLogin extends Fragment implements View.OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_main_login, container,
				false);

		// VIew implementations
		Button btnSubmitMail = (Button) v.findViewById(R.id.btnSubmitEmail);
		TextView tvLoginMail = (TextView)v.findViewById(R.id.tvLoginMail);
		// View setClick listeners

		btnSubmitMail.setOnClickListener(this);
		tvLoginMail.setOnClickListener(this);
		return v;

	}

	// clickListener
	@Override
	public void onClick(View v) {
		int idView = v.getId();

		switch (idView) {
		case R.id.btnSubmitEmail: {

			Intent i = new Intent(getActivity(), ActivitySubmitEmail.class);
			startActivity(i);

			break;
		}
		case R.id.tvLoginMail: {
			
		}

		}

	}
}
