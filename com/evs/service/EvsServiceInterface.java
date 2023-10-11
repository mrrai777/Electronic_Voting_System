package com.evs.service;

import com.evs.bean.CredentialsBean;
import com.evs.bean.ProfileBean;

public interface EvsServiceInterface {

	String loginService(CredentialsBean login);
	String registerationService(ProfileBean profileBean);
}
