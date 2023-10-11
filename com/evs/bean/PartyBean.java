package com.evs.bean;

public class PartyBean {
	private String partyId;
	private String name;
	private String leader;
	private String symbol;

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "[partyId=" + partyId + " || name=" + name + " || leader=" + leader + " || symbol=" + symbol + "]";
	}

}
