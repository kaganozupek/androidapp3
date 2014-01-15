package com.khora.snitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

public class GeneralStaticFunctions {
	

	
	public static int convertDiptoPix(int dip, Context x) {
		float scale = x.getResources().getDisplayMetrics().density;
		return (int) ((dip - 0.5f) / scale);
	}
	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {

		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		return sb.toString();

	}

	public static Bundle checkLogin(final String email, final String password) {
		HttpClient client = new DefaultHttpClient();
		Bundle resultBnd = new Bundle();
		String Request = "";
		JSONObject requestObject = new JSONObject();
		try {
			requestObject.put("RequestType", "LoginRequest");
			requestObject.put("email", "kubra_tugsal@hotmail.com");
			requestObject.put("password", "qaz123");
			String url = "http://94.122.121.242/AdminPage/api/mobileHttpHandle/LoginRequest";
			Request = requestObject.toString();
			HttpPost post = new HttpPost(url);
			StringEntity se = new StringEntity(requestObject.toString());

			post.setEntity(se);

			post.setHeader("Content-type", "application/json");

			HttpResponse response = client.execute(post);
			InputStream stream = response.getEntity().getContent();
			String resultString = convertStreamToString(stream);
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			ModelUser user = gson.fromJson(resultString, ModelUser.class);

		
			String jsonObject = gson.toJson(user);
		
			
			resultBnd.putString("LoggedUser", jsonObject);
			resultBnd.putString("resultCode", "SUCCESS");
		

		} catch (Exception e) {
			
			resultBnd.putString("resultCode", "FAILED");
			

		}
		return resultBnd ;
	}


}
