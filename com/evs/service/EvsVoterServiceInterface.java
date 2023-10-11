package com.evs.service;

import java.util.ArrayList;

import com.evs.bean.CandidateBean;
import com.evs.bean.ElectionBean;
import com.evs.bean.ResultBean;

public interface EvsVoterServiceInterface {

	String castVote(String userId, String electionId, String candidateId);

	ArrayList<CandidateBean> viewAllCandidates(String electionName, String constituency);

	ArrayList<ResultBean> viewElectionResult();

	ArrayList<ElectionBean> viewAllElections();

	String requestVoterId(String userId);

	String viewGeneratedVoterId(String userId, String constituency);

}
