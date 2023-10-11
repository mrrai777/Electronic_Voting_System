package com.evs.controller;

import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.evs.bean.ApplicationBean;
import com.evs.bean.CandidateBean;
import com.evs.bean.ElectionBean;
import com.evs.bean.PartyBean;
import com.evs.bean.ResultBean;
import com.evs.service.EvsAdminService;
import com.evs.service.EvsAdminServiceInterface;
import com.evs.service.EvsService;

public class EvsAdminController implements EvsAdminControllerInterface {
	private EvsAdminServiceInterface service = null;

	@Override
	public void addElection() {
		String name = JOptionPane.showInputDialog("Enter Name of Election");
		String electionDate = JOptionPane.showInputDialog("Enter Election Date");
		String district = JOptionPane.showInputDialog("Enter District");
		String constituency = JOptionPane.showInputDialog("Enter Constituency");
		String countingDate = JOptionPane.showInputDialog("Enter Counting Date");

		ElectionBean electionBean = new ElectionBean();
		electionBean.setName(name);
		Date ed = Date.valueOf(electionDate);
		electionBean.setElectionDate(ed);
		electionBean.setDistrict(district);
		electionBean.setConstituency(constituency);
		ed = Date.valueOf(countingDate);
		electionBean.setCountingDate(ed);

		service = new EvsAdminService();
		String result = service.addElection(electionBean);
		if (result.equals("SUCCESS")) {
			JOptionPane.showMessageDialog(null, "Election Successfully Added");
		} else {
			JOptionPane.showMessageDialog(null, "Error in Adding Election! TRY AGAIN..");
		}
	}

	@Override
	public void viewAllUpComingElections() {

		service = new EvsAdminService();
		ArrayList<ElectionBean> election = new ArrayList<>();
		election = service.viewAllUpComingElections();
		if (election == null) {
			JOptionPane.showMessageDialog(null, "No Elections Record Found");
			System.exit(0);
		}
		Iterator<ElectionBean> it = election.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);
	}

	@Override
	public void viewAllElections() {
		service = new EvsAdminService();
		ArrayList<ElectionBean> election = new ArrayList<>();
		election = service.viewAllUpComingElections();
		if (election == null) {
			JOptionPane.showMessageDialog(null, "No Upcoming Elections");
			System.exit(0);
		}
		Iterator<ElectionBean> it = election.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);

	}

	@Override
	public void addParty() {
		String name = JOptionPane.showInputDialog("Enter Name of Party");
		String leader = JOptionPane.showInputDialog("Enter the Leader Name");
		String symbol = JOptionPane.showInputDialog("Enter the Symbol of Party");

		PartyBean partyBean = new PartyBean();
		partyBean.setName(name);
		partyBean.setLeader(leader);
		partyBean.setSymbol(symbol);

		service = new EvsAdminService();
		String result = service.addParty(partyBean);

		if (result.equals("SUCCESS")) {
			JOptionPane.showMessageDialog(null, "Election Successfully Added");
		} else {
			JOptionPane.showMessageDialog(null, "Error in Adding Election! TRY AGAIN..");
		}

	}

	@Override
	public void viewParty() {
		service = new EvsAdminService();
		ArrayList<PartyBean> party = new ArrayList<>();
		party = service.viewParty();
		Iterator<PartyBean> it = party.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);
	}

	@Override
	public void addCandidate() {
		String name = JOptionPane.showInputDialog("Enter Name of Candidate");
		String electionId = JOptionPane.showInputDialog("Enter Election Id");
		String partyId = JOptionPane.showInputDialog("Enter Party Id");
		String district = JOptionPane.showInputDialog("Enter District");
		String constituency = JOptionPane.showInputDialog("Enter Constituency");
		String dob = JOptionPane.showInputDialog("Enter Date of Birth");
		String mobileNo = JOptionPane.showInputDialog("Enter Date of Birth in YYYY-MM-DD format");
		String address = JOptionPane.showInputDialog("Enter Address ");
		String emailId = JOptionPane.showInputDialog("Enter your EmailId");

		CandidateBean candidate = new CandidateBean();
		candidate.setName(name);
		candidate.setElectionId(electionId);
		candidate.setPartyId(partyId);
		candidate.setDistrict(district);
		candidate.setConstituency(constituency);
		candidate.setDateOfBirth(Date.valueOf(dob));
		candidate.setMobileNo(mobileNo);
		candidate.setAddress(address);
		candidate.setEmailId(emailId);

		service = new EvsAdminService();
		String result = service.addCandidate(candidate);

		if (result.equals("SUCCESS"))
			JOptionPane.showMessageDialog(null, "Candidate Successfully Added :)");
		else
			JOptionPane.showMessageDialog(null, "Error in Adding Candidate! TRY AGAIN...");

	}

	@Override
	public void viewCandidateDetailsByElectionName() {
		String election = JOptionPane.showInputDialog("Enter the Election Name to View ");
		service = new EvsAdminService();
		ArrayList<CandidateBean> candidate = new ArrayList<>();
		candidate = service.viewCandidateDetailsByElectionName(election);
		Iterator<CandidateBean> it = candidate.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);

	}

	@Override
	public void viewAllAdminPendingApplications() {
		service = new EvsAdminService();
		ArrayList<ApplicationBean> application = new ArrayList<>();
		application = service.viewAllAdminPendingApplications();
		Iterator<ApplicationBean> it = application.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next().toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);
	}

	@Override
	public void forwardVoterIdRequest() {
		String userId = JOptionPane.showInputDialog("Enter Your User ID");
		service = new EvsAdminService();
		boolean result = service.forwardVoterIdRequest(userId);

		if (result) {
			JOptionPane.showMessageDialog(null, "Forwarded");
		} else {
			JOptionPane.showMessageDialog(null, "Not Forwarded");
		}
	}

	@Override
	public void viewCandidateDetailsByParty() {
		String party = JOptionPane.showInputDialog("Enter the Party ID to View ");
		service = new EvsAdminService();
		ArrayList<CandidateBean> candidate = new ArrayList<>();
		candidate = service.viewCandidateDetailsByParty(party);
		Iterator<CandidateBean> it = candidate.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);
	}

	@Override
	public void approveElectionResult() {
		service = new EvsAdminService();
		String electionId = JOptionPane.showInputDialog("Enter the Election ID ");
		Map<ElectionBean, ResultBean> result = new HashMap<>();
		result = service.approveElectionResult(electionId);
		String res = "";

		for (Map.Entry<ElectionBean, ResultBean> mp : result.entrySet()) {
			String s1 = mp.getKey().getName();
			String s2 = mp.getKey().getConstituency();
			String s3 = mp.getValue().getCandidateId();
			String s4 = mp.getValue().getElectionId();
			int s5 = mp.getValue().getVoteCount();
			;

			res = res + s4 + s1 + s2 + s3 + s5 + "\n";

		}

		JOptionPane.showMessageDialog(null, res);
	}

	@Override
	public void changePassword() {
		EvsService es = new EvsService();
		String userId = JOptionPane.showInputDialog("Enter UserId");
		String oldPass = JOptionPane.showInputDialog("Enter Current Password");
		String newPass = JOptionPane.showInputDialog("Enter New Password");

		boolean result = es.changePassword(userId, oldPass, newPass);

		if (result) {
			JOptionPane.showMessageDialog(null, "Password Successfully Changed");
		} else {
			JOptionPane.showMessageDialog(null, "Unsuccessfull");
		}

	}

	@Override
	public void logout() {
		EvsService es = new EvsService();
		String userId = JOptionPane.showInputDialog("Enter UserId");
		boolean result = es.logout(userId);

		if (result) {
			JOptionPane.showMessageDialog(null, "Logout Successfull");
		} else {
			JOptionPane.showMessageDialog(null, "Logout Unsuccessfull");
		}
	}

}
