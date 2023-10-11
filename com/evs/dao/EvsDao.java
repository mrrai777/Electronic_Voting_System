package com.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.evs.bean.CredentialsBean;
import com.evs.bean.ProfileBean;
import com.evs.util.DBUtil;

public class EvsDao implements EvsDaoInterface {
	private static Connection connect = null;
	private PreparedStatement ps = null;

	@Override
	public String loginDao(CredentialsBean login) {
		connect = DBUtil.getConnection();
		String i = null;
		try {
			ps = connect.prepareStatement("select * from evs_tbl_user_credentials where userid=? and password=?");
			ps.setString(1, login.getUserId());
			ps.setString(2, login.getPassword());

			ResultSet res = ps.executeQuery();
			if (res.next()) {
				i = res.getString("userType");
				PreparedStatement ps1 = connect
						.prepareStatement("update evs_tbl_user_credentials  set loginstatus=? where userid=?");
				ps1.setInt(1, 1);
				ps1.setString(2, login.getUserId());
				ps1.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean logoutDAO(String userId) {
		connect = DBUtil.getConnection();
		boolean i = false;
		try {
			ps = connect.prepareStatement("update evs_tbl_user_credentials  set loginstatus=? where userid=?");
			ps.setInt(1, 0);
			ps.setString(2, userId);

			int i1 = ps.executeUpdate();
			if (i1 > 0) {
				i = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean changePassword(String userId, String oldPass, String newPassword) {
		connect = DBUtil.getConnection();
		boolean i = false;
		try {
			ps = connect
					.prepareStatement("update evs_tbl_user_credentials set password=? where userid=? and password=?");
			ps.setString(1, newPassword);
			ps.setString(2, userId);
			ps.setString(3, oldPass);

			int i1 = ps.executeUpdate();
			if (i1 > 0) {
				i = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public String registerationDao(ProfileBean profileBean) {
		connect = DBUtil.getConnection();

		try {

			ps = connect.prepareStatement("insert into evs_tbl_User_Credentials values(?,?,?,?)");
			String tmp = "US-" + profileBean.getUserId();
			ps.setString(1, tmp);
			ps.setString(2, profileBean.getPassword());
			ps.setString(3, "V");
			ps.setInt(4, 0);

			int i1 = ps.executeUpdate();
			if (i1 > 0) {
				PreparedStatement ps = connect
						.prepareStatement("insert into evs_tbl_user_profile values(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, tmp);
				ps.setString(2, profileBean.getFirstName());
				ps.setString(3, profileBean.getLastName());
				ps.setDate(4, profileBean.getDateOfBirth());
				ps.setString(5, profileBean.getGender());
				ps.setString(6, profileBean.getStreet());
				ps.setString(7, profileBean.getLocation());
				ps.setString(8, profileBean.getCity());
				ps.setString(9, profileBean.getState());
				ps.setString(10, profileBean.getPinCode());
				ps.setString(11, profileBean.getMobileNo());
				ps.setString(12, profileBean.getEmailId());

				int i2 = ps.executeUpdate();
				ps.close();
				if (i2 > 0) {
					return "SUCCESS";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
