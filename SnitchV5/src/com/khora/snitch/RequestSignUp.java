package com.khora.snitch;

import android.graphics.drawable.Drawable;

public class RequestSignUp {
	
	private String Name;
	private String Surname;
	private String Password;
	private Drawable ProfilePicture;
	private String Email;
	private String PhoneNumber;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Drawable getProfilePicture() {
		return ProfilePicture;
	}
	public void setProfilePicture(Drawable profilePicture) {
		ProfilePicture = profilePicture;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public RequestSignUp() {
		
	}
	
	
	
}
