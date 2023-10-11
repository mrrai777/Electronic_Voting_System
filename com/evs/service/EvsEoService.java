package com.evs.service;

import java.util.ArrayList;

import com.evs.bean.ApplicationBean;
import com.evs.dao.EvsEoDao;
import com.evs.dao.EvsEoDaoInterface;

public class EvsEoService implements EvsEoServiceInterface {
	private EvsEoDaoInterface eo = null;

	@Override
	public String generateVoterId(String userId) {
		eo = new EvsEoDao();
		return eo.generateVoterId(userId);
	}

	@Override
	public ArrayList<ApplicationBean> viewAllVoterIdApplications() {
		eo = new EvsEoDao();
		return eo.viewAllVoterIdApplications();
	}

}
