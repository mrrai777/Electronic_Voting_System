package com.evs.service;

import java.util.ArrayList;
import java.util.Map;

import com.evs.bean.ApplicationBean;
import com.evs.bean.CandidateBean;
import com.evs.bean.ElectionBean;
import com.evs.bean.PartyBean;
import com.evs.bean.ResultBean;
import com.evs.dao.EvsAdminDao;
import com.evs.dao.EvsAdminDaoInterface;

public class EvsAdminService implements EvsAdminServiceInterface {
	private EvsAdminDaoInterface dao = null;
	@Override
	public String addElection(ElectionBean electionBean) {
		dao = new EvsAdminDao();
		return dao.addElection(electionBean);
	}

	@Override
	public ArrayList<ElectionBean> viewAllUpComingElections() {
		dao = new EvsAdminDao();
		return dao.viewAllUpComingElections();
	}

	@Override
	public ArrayList<ElectionBean> viewAllElections() {
		dao = new EvsAdminDao();
		return dao.viewAllElections();
	}

	@Override
	public String addParty(PartyBean partyBean) {
		dao = new EvsAdminDao();
		return dao.addParty(partyBean);
	}

	@Override
	public ArrayList<PartyBean> viewParty() {
		dao = new EvsAdminDao();
		return dao.viewParty();
	}

	@Override
	public String addCandidate(CandidateBean candidate) {
		dao = new EvsAdminDao();
		return dao.addCandidate(candidate);
	}

	@Override
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String election) {
		dao = new EvsAdminDao();
		return dao.viewCandidateDetailsByElectionName(election);
	}

	@Override
	public ArrayList<CandidateBean> viewCandidateDetailsByParty(String party) {
		dao = new EvsAdminDao();
		return dao.viewCandidateDetailsByParty(party);
	}

	@Override
	public ArrayList<ApplicationBean> viewAllAdminPendingApplications() {
		dao = new EvsAdminDao();
		return dao.viewAllAdminPendingApplications();
	}

	@Override
	public boolean forwardVoterIdRequest(String userId) {
		dao = new EvsAdminDao();
		return dao.forwardVoterIdRequest(userId);
	}

	@Override
	public Map<ElectionBean, ResultBean> approveElectionResult(String electionId) {
		dao = new EvsAdminDao();
		return dao.approveElectionResult(electionId);
	}

}
