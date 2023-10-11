package com.evs.bean;

import java.sql.Date;

public class CandidateBean {
	private String candidateId;
	private String name;
	private String electionId;
	private String partyId;
	private String district;
	private String constituency;
	private Date dateOfBirth;
	private String mobileNo;
	private String address;
	private String emailId;

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getElectionId() {
		return electionId;
	}

	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "[candidateId=" + candidateId + " || name=" + name + " || electionId=" + electionId
				+ " || partyId=" + partyId + " || district=" + district + " || constituency=" + constituency
				+ " || dateOfBirth=" + dateOfBirth + " || mobileNo=" + mobileNo + " || address=" + address + " || emailId="
				+ emailId + "]";
	}

}
