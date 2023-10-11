package com.evs.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.evs.bean.ApplicationBean;
import com.evs.service.EvsEoService;
import com.evs.service.EvsEoServiceInterface;
import com.evs.service.EvsService;

public class EvsEoController implements EvsEoControllerInterface {
	EvsEoServiceInterface eo = null;

	@Override
	public void generateVoterId() {
		eo = new EvsEoService();

		String userId = JOptionPane.showInputDialog("Enter Voter's User Id");
//		String status = JOptionPane.showInputDialog("Enter Application Status");
		String result = eo.generateVoterId(userId);
		if (result.equals("Already")) {
			JOptionPane.showMessageDialog(null, "User " + userId + " Voter ID is Already Created");
		} else {
			JOptionPane.showMessageDialog(null, result);
		}
	}

	@Override
	public void viewAllVoterIdApplications() {
		eo = new EvsEoService();

		ArrayList<ApplicationBean> application = new ArrayList<>();
		application = eo.viewAllVoterIdApplications();
		Iterator<ApplicationBean> it = application.iterator();
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
