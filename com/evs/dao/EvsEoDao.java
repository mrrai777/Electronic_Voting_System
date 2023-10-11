package com.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.evs.bean.ApplicationBean;
import com.evs.util.DBUtil;

public class EvsEoDao implements EvsEoDaoInterface {
	private static Connection connect = null;
	private PreparedStatement ps = null;

	@Override
	public String generateVoterId(String userId) {
		connect = DBUtil.getConnection();
		String voterId = null;
		try {
			ps = connect.prepareStatement("select passedstatus from evs_tbl_application where userid = ?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next() && rs.getInt(1) == 3) {
				return "Already";
			} else {
				ps = connect.prepareStatement(
						"select upper(left(firstname,2)), upper(left(city,2)) from evs_tbl_user_profile where userid = ?");
				ps.setString(1, userId);
				rs = null;
				rs = ps.executeQuery();
				if (rs.next()) {
					voterId = rs.getString(1);
					voterId = voterId + rs.getString(2);
				}

				ps = connect.prepareStatement("Select count from number");
				rs = null;
				rs = ps.executeQuery();
				if (rs.next()) {
					int i = rs.getInt(1);
					voterId += String.valueOf(i);
				}
				ps = connect.prepareStatement("update number set count = count+1");
				ps.executeUpdate();

				ps = connect.prepareStatement(
						"update evs_tbl_application set passedstatus = ?, approvedstatus = ?, voterid = ? where userid = ?");
				ps.setInt(1, 3);
				ps.setInt(2, 1);
				ps.setString(3, voterId);
				ps.setString(4, userId);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voterId;
	}

	@Override
	public ArrayList<ApplicationBean> viewAllVoterIdApplications() {
		connect = DBUtil.getConnection();
		ArrayList<ApplicationBean> pending = null;
		try {
			ps = connect.prepareStatement("Select * from evs_tbl_application where passedstatus = 2");
			ResultSet rs = ps.executeQuery();
			pending = new ArrayList<>();
			while (rs.next()) {
				ApplicationBean ab = new ApplicationBean();
				ab.setUserId(rs.getString(1));
				ab.setConstituency(rs.getString(2));
				ab.setPassedStatus(rs.getInt(3));
				ab.setApprovedStatus(rs.getInt(4));
				pending.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pending;
	}

}
