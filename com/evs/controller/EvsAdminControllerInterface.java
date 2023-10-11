package com.evs.controller;

public interface EvsAdminControllerInterface {

	void addElection();

	void viewAllUpComingElections();

	void viewAllElections();

	void addParty();

	void viewParty();

	void addCandidate();

	void viewCandidateDetailsByElectionName();

	void viewAllAdminPendingApplications();

	void forwardVoterIdRequest();

	void viewCandidateDetailsByParty();

	void approveElectionResult();

	void changePassword();

	void logout();

}
