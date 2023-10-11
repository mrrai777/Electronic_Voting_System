package com.evs.ui;

import javax.swing.JOptionPane;

import com.evs.controller.EvsEoController;
import com.evs.controller.EvsEoControllerInterface;
import com.evs.controller.EvsAdminController;
import com.evs.controller.EvsAdminControllerInterface;
import com.evs.controller.EvsVoterController;
import com.evs.controller.EvsVoterControllerInterface;
import com.evs.controller.GeneralController;
import com.evs.controller.GeneralControllerInterface;

public class Main {
	public static void main(String[] args) {
		String conti = "Y";
		while (conti.equals("Y")) {
			String choice = JOptionPane.showInputDialog("New User Press 1\nExisting User Press 2");

			GeneralControllerInterface gc = new GeneralController();

			if (choice.equals("1")) {
				String result = gc.registerationController();
				if (result.equals("SUCCESS"))
					JOptionPane.showMessageDialog(null, "Successfully Registered");
				else
					JOptionPane.showMessageDialog(null, "Try Again");
			} else if (choice.equals("2")) {
				String ret = gc.loginController();
				switch (ret) {
				case "A":
					String tmp1 = "0";
					while (!tmp1.equals("13")) {
						String adminChoice = JOptionPane.showInputDialog(
								"Press : \n" + "1 for Adding Election \n2 for View all Upcomming Elections"
										+ "\n3 for View all Elections \n4 for Add New Party"
										+ "\n5 for View all Party \n6 for Add Candidate \n7 for "
										+ "View Candidate details by Election name \n8 for View all "
										+ "Admin pending applications \n9 for Forward Voter Id Request"
										+ "\n10 for View Candidate Details by PartyId \n11"
										+ " for Approve Election Result" + "\n12 for Changing Password\n13 for Logout");
						EvsAdminControllerInterface admin = new EvsAdminController();
						switch (adminChoice) {
						case "1":
							admin.addElection();
							break;
						case "2":
							admin.viewAllUpComingElections();
							break;
						case "3":
							admin.viewAllElections();
							break;
						case "4":
							admin.addParty();
							break;
						case "5":
							admin.viewParty();
							break;
						case "6":
							admin.addCandidate();
							break;
						case "7":
							admin.viewCandidateDetailsByElectionName();
							break;
						case "8":
							admin.viewAllAdminPendingApplications();
							break;
						case "9":
							admin.forwardVoterIdRequest();
							break;
						case "10":
							admin.viewCandidateDetailsByParty();
							break;
						case "11":
							admin.approveElectionResult();
							break;
						case "12":
							admin.changePassword();
							break;
						case "13":
							admin.logout();
							break;
						default:
							JOptionPane.showMessageDialog(null, "Wrong Choice");
						}
						tmp1 = adminChoice;
					}
					break;
				case "E":
					String tmp2 = "0";
					while (!tmp2.equals("4")) {
						String eochoice = JOptionPane.showInputDialog(
								"Press : \n1 to Generate VoterID" + "\n2 for View all VoterID Applications"
										+ "\n3 for Changing Password \n4 for Logging Out");

						EvsEoControllerInterface eo = new EvsEoController();
						switch (eochoice) {
						case "1":
							eo.generateVoterId();
							break;
						case "2":
							eo.viewAllVoterIdApplications();
							break;
						case "3":
							eo.changePassword();
							break;
						case "4":
							eo.logout();
							break;
						default:
							JOptionPane.showMessageDialog(null, "Wrong Choice");
						}
						tmp2 = eochoice;
					}
					break;
				case "V":
					String tmp3 = "0";
					while (!tmp3.equals("8")) {
						String vo = JOptionPane.showInputDialog("Press : \n1 to Cast Vote \n2 to View"
								+ " all Candidates \n3 to View Election Results \n4 to Request VoterId\n"
								+ "5 to View Generated VoterId \n6 to View all Elections List \n7 for "
								+ "Changing Password \n8 for Logging Out");

						EvsVoterControllerInterface voter = new EvsVoterController();

						switch (vo) {
						case "1":
							voter.castVote();
							break;
						case "2":
							voter.viewAllCandidates();
							break;
						case "3":
							voter.viewElectionResult();
							break;
						case "4":
							voter.requestVoterId();
							break;
						case "5":
							voter.viewGeneratedVoterId();
							break;
						case "6":
							voter.viewAllElections();
							break;
						case "7":
							voter.changePassword();
							break;
						case "8":
							voter.logout();
							break;
						default:
							JOptionPane.showMessageDialog(null, "Wrong Option");
							break;
						}
						tmp3 = vo;
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "You have entered Wrong Choice");
				}
			} else {
				JOptionPane.showMessageDialog(null, "You have entered wrong Choice");
			}
			conti = JOptionPane.showInputDialog("To continue press y\nTo Stop press other key");
			conti = conti.toUpperCase();
		}
	}
}
