package com.evs.bean;

import java.sql.Date;

public class ElectionBean {
	private String electionId;
	private String name;
	private Date electionDate;
	private String district;
	private String constituency;
	private Date countingDate;

	public String getElectionId() {
		return electionId;
	}

	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
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

	public Date getCountingDate() {
		return countingDate;
	}

	public void setCountingDate(Date countingDate) {
		this.countingDate = countingDate;
	}

	@Override
	public String toString() {
		return "[electionId=" + electionId + " || name=" + name + " || electionDate=" + electionDate
				+ " || district=" + district + " || constituency=" + constituency + " || countingDate=" + countingDate + "]";
	}

}
