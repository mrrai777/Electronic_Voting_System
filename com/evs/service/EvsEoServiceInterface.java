package com.evs.service;

import java.util.ArrayList;

import com.evs.bean.ApplicationBean;

public interface EvsEoServiceInterface {

	String generateVoterId(String userId);

	ArrayList<ApplicationBean> viewAllVoterIdApplications();

}
