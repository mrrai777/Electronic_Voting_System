package com.evs.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.evs.bean.CandidateBean;
import com.evs.bean.ElectionBean;
import com.evs.bean.ResultBean;
import com.evs.service.EvsService;
import com.evs.service.EvsVoterService;
import com.evs.service.EvsVoterServiceInterface;

public class EvsVoterController implements EvsVoterControllerInterface {
	private EvsVoterServiceInterface voter = null;

	@Override
	public void castVote() {
		voter = new EvsVoterService();
		String userId = JOptionPane.showInputDialog("Enter User Id ");
		String electionId = JOptionPane.showInputDialog("Enter Election Id ");
		String candidateId = JOptionPane.showInputDialog("Enter Candidate Id ");

		String result = voter.castVote(userId, electionId, candidateId);
		if (result.equals("SUCCESS")) {
			JOptionPane.showMessageDialog(null, "Vote Casted Successfully");
		} else {
			JOptionPane.showMessageDialog(null, "Unsuccessfull!! TRY AGAIN...");
		}
	}

	@Override
	public void viewAllCandidates() {
		voter = new EvsVoterService();
		String electionName = JOptionPane.showInputDialog("Enter Election name");
		String constituency = JOptionPane.showInputDialog("Enter Constituency ");

		ArrayList<CandidateBean> candidates = new ArrayList<>();
		candidates = voter.viewAllCandidates(electionName, constituency);
		Iterator<CandidateBean> it = candidates.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);

	}

	@Override
	public void viewElectionResult() {
		voter = new EvsVoterService();
		ArrayList<ResultBean> candidates = new ArrayList<>();
		candidates = voter.viewElectionResult();
		Iterator<ResultBean> it = candidates.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);

	}

	@Override
	public void requestVoterId() {
		voter = new EvsVoterService();
		String userId = JOptionPane.showInputDialog("Enter Your UserId");

		String result = voter.requestVoterId(userId);
		if (result.equals("SUCCESS")) {
			JOptionPane.showMessageDialog(null, "Successfully Requested for VoterID :)");
		} else if (result.equals("else")) {
			JOptionPane.showMessageDialog(null, "Already Requested !...");
		} else {
			JOptionPane.showMessageDialog(null, "ERROR in Requesting !! TRY AGAIN...");
		}

	}

	@Override
	public void viewGeneratedVoterId() {
		String userId = JOptionPane.showInputDialog("Enter Your UserId");
		String constituency = JOptionPane.showInputDialog("Enter Your Constituency");

		voter = new EvsVoterService();
		String result = voter.viewGeneratedVoterId(userId, constituency);

		if (result != (null)) {
			JOptionPane.showMessageDialog(null, result);
		} else {
			JOptionPane.showMessageDialog(null, "Voter Id not Generated Yet! TRY AGAIN LATER...");
		}

	}

	@Override
	public void viewAllElections() {
		voter = new EvsVoterService();

		ArrayList<ElectionBean> candidates = new ArrayList<>();
		candidates = voter.viewAllElections();
		Iterator<ElectionBean> it = candidates.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next() + "\n";
		}
		JOptionPane.showMessageDialog(null, result);

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
