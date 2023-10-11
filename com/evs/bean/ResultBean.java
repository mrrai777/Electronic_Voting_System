package com.evs.bean;

public class ResultBean {
	private int serialNo;
	private String electionId;
	private String candidateId;
	private int voteCount;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getElectionId() {
		return electionId;
	}

	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	@Override
	public String toString() {
		return "[serialNo=" + serialNo + " || electionId=" + electionId + " || candidateId=" + candidateId
				+ " || voteCount=" + voteCount + "]";
	}

}
