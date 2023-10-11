package com.evs.service;

import com.evs.bean.CredentialsBean;
import com.evs.bean.ProfileBean;
import com.evs.dao.EvsDao;
import com.evs.dao.EvsDaoInterface;

public class EvsService implements EvsServiceInterface {
	private EvsDaoInterface dao = null;

	@Override
	public String loginService(CredentialsBean login) {

		dao = new EvsDao();
		return dao.loginDao(login);

	}

	@Override
	public String registerationService(ProfileBean profileBean) {
		dao = new EvsDao();
		return dao.registerationDao(profileBean);
	}

	public boolean logout(String userId) {
		dao = new EvsDao();
		return dao.logoutDAO(userId);
	}

	public boolean changePassword(String userId, String oldPass, String newPass) {
		dao = new EvsDao();
		return dao.changePassword(userId, oldPass, newPass);
	}

}
