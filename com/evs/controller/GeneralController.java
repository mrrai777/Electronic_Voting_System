package com.evs.controller;

import javax.swing.JOptionPane;

import java.sql.Date;
import com.evs.bean.CredentialsBean;
import com.evs.bean.ProfileBean;
import com.evs.service.EvsService;
import com.evs.service.EvsServiceInterface;

public class GeneralController implements GeneralControllerInterface {
	private EvsServiceInterface service = null;
	@Override
	public String registerationController() {
		String userId = JOptionPane.showInputDialog("Enter Three Digit User ID");
		String password = JOptionPane.showInputDialog("Enter your Password");
		String firstName = JOptionPane.showInputDialog("Enter First Name");
		String lastName = JOptionPane.showInputDialog("Enter Last Name");
		String dateOfBirth = JOptionPane.showInputDialog("Enter Date of Birth in YYYY-MM-DD format");
		String gender = JOptionPane.showInputDialog("Enter your gender");
		String street = JOptionPane.showInputDialog("Enter Street");
		String location = JOptionPane.showInputDialog("Enter Location");
		String city = JOptionPane.showInputDialog("Enter City");
		String state = JOptionPane.showInputDialog("Enter State");
		String pincode = JOptionPane.showInputDialog("Enter Pincode");
		String mobile = JOptionPane.showInputDialog("Enter Mobile Number");
		String emailId = JOptionPane.showInputDialog("Enter your Email");
		Date dob = Date.valueOf(dateOfBirth);
		
		ProfileBean profileBean = new ProfileBean();
		
		profileBean.setUserId(userId);
		profileBean.setFirstName(firstName);
		profileBean.setLastName(lastName);
		profileBean.setDateOfBirth(dob);
		profileBean.setGender(gender);
		profileBean.setStreet(street);
		profileBean.setLocation(location);
		profileBean.setCity(city);
		profileBean.setState(state);
		profileBean.setPinCode(pincode);
		profileBean.setMobileNo(mobile);
		profileBean.setEmailId(emailId);
		profileBean.setPassword(password);
		
		service = new EvsService();	
		
		return service.registerationService(profileBean);
	}
	
	@Override
	public String loginController() {
		
		String userId = JOptionPane.showInputDialog("Enter your User ID");
		String password = JOptionPane.showInputDialog("Enter your Password");
		
		CredentialsBean login = new CredentialsBean();
		login.setUserId(userId);
		login.setPassword(password);
		
		service = new EvsService();	
		String result = service.loginService(login);
		
		return result;
	}

}
