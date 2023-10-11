package com.evs.bean;

public class EOBean {
	private String electoralOfficerId;
	private String constituency;

	public String getElectoralOfficerId() {
		return electoralOfficerId;
	}

	public void setElectoralOfficerId(String electoralOfficerId) {
		this.electoralOfficerId = electoralOfficerId;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	@Override
	public String toString() {
		return "[electoralOfficerId=" + electoralOfficerId + " || constituency=" + constituency + "]";
	}

}
