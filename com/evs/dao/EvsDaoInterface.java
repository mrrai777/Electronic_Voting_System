package com.evs.dao;

import com.evs.bean.CredentialsBean;
import com.evs.bean.ProfileBean;

public interface EvsDaoInterface {

	String loginDao(CredentialsBean login);
	String registerationDao(ProfileBean profileBean);
	boolean logoutDAO(String userId);
	boolean changePassword(String userId, String oldPass, String newPass);
}