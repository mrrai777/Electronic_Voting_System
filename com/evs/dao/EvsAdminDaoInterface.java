package com.evs.dao;

import java.util.ArrayList;
import java.util.Map;

import com.evs.bean.ApplicationBean;
import com.evs.bean.CandidateBean;
import com.evs.bean.ElectionBean;
import com.evs.bean.PartyBean;
import com.evs.bean.ResultBean;

public interface EvsAdminDaoInterface {

	String addElection(ElectionBean electionBean);

	ArrayList<ElectionBean> viewAllUpComingElections();

	ArrayList<ElectionBean> viewAllElections();

	String addParty(PartyBean partyBean);

	ArrayList<PartyBean> viewParty();

	String addCandidate(CandidateBean candidate);

	ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String election);

	ArrayList<CandidateBean> viewCandidateDetailsByParty(String party);

	ArrayList<ApplicationBean> viewAllAdminPendingApplications();

	boolean forwardVoterIdRequest(String userId);

	public Map<ElectionBean, ResultBean> approveElectionResult(String electionId);

}
