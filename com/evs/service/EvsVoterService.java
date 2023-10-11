package com.evs.service;

import java.util.ArrayList;

import com.evs.bean.CandidateBean;
import com.evs.bean.ElectionBean;
import com.evs.bean.ResultBean;
import com.evs.dao.EvsVoterDao;
import com.evs.dao.EvsVoterDaoInterface;

public class EvsVoterService implements EvsVoterServiceInterface {
	private EvsVoterDaoInterface voter = null;
	@Override
	public String castVote(String userId, String electionId, String candidateId) {
		voter = new EvsVoterDao();
		return voter.castVote(userId, electionId, candidateId);
	}

	@Override
	public ArrayList<CandidateBean> viewAllCandidates(String electionName, String constituency) {
		voter = new EvsVoterDao();
		return voter.viewAllCandidates(electionName, constituency);
	}

	@Override
	public ArrayList<ResultBean> viewElectionResult() {
		voter = new EvsVoterDao();
		return voter.viewElectionResult();
	}

	@Override
	public ArrayList<ElectionBean> viewAllElections() {
		voter = new EvsVoterDao();
		return voter.viewAllElections();
	}

	@Override
	public String requestVoterId(String userId) {
		voter = new EvsVoterDao();
		return voter.requestVoterId(userId);
	}

	@Override
	public String viewGeneratedVoterId(String userId, String constituency) {
		voter = new EvsVoterDao();
		return voter.viewGeneratedVoterId(userId, constituency);
	}

}
