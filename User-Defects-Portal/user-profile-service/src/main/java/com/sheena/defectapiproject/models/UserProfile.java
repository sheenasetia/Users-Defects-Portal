package com.sheena.defectapiproject.models;

import java.util.List;

public class UserProfile {

	private Users userInfo;
	private List<Defect> userDefects;
	
	public UserProfile() {
		super();
		
	}
	public UserProfile(Users userInfo, List<Defect> userDefects) {
		super();
		this.userInfo = userInfo;
		this.userDefects = userDefects;
	}
	public Users getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Users userInfo) {
		this.userInfo = userInfo;
	}
	public List<Defect> getDef() {
		return userDefects;
	}
	public void setDef(List<Defect> userDefects) {
		this.userDefects = userDefects;
	}
	
}
