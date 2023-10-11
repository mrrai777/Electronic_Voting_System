package com.evs.dao;

import java.util.ArrayList;

import com.evs.bean.ApplicationBean;

public interface EvsEoDaoInterface {

	String generateVoterId(String userId);

	ArrayList<ApplicationBean> viewAllVoterIdApplications();

}
