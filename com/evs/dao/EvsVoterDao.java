package com.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.evs.bean.CandidateBean;
import com.evs.bean.ElectionBean;
import com.evs.bean.ResultBean;
import com.evs.util.DBUtil;

public class EvsVoterDao implements EvsVoterDaoInterface {
	private static Connection con = null;
	private PreparedStatement ps = null;

	@Override
	public String castVote(String userId, String electionId, String candidateId) {
		con = DBUtil.getConnection();
		String sql = "update evs_tbl_result set votecount = votecount+1 where " + "electionId = ? and candidateId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, electionId);
			ps.setString(2, candidateId);

			int i = ps.executeUpdate();
			if (i > 0)
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CandidateBean> viewAllCandidates(String electionName, String constituency) {
		con = DBUtil.getConnection();
		ArrayList<CandidateBean> candidateList = null;
		String sql = " select cd.candidateid, cd.name, cd.electionid, cd.partyid"
				+ ", cd.district, cd.constituency, cd.dateofbirth, cd.mobileno, cd."
				+ "address, cd.emailid from evs_tbl_candidate cd join evs_tbl_"
				+ "election e on e.electionid = cd.electionid where cd.name = ? and cd.constituency=?";
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, electionName);
			ps.setString(2, constituency);
			ResultSet rs = null;
			rs = ps.executeQuery();

			candidateList = new ArrayList<>();
			while (rs.next()) {
				CandidateBean cd = new CandidateBean();
				cd.setCandidateId(rs.getString(1));
				cd.setName(rs.getString(2));
				cd.setElectionId(rs.getString(3));
				cd.setPartyId(rs.getString(4));
				cd.setDistrict(rs.getString(5));
				cd.setConstituency(rs.getString(6));
				cd.setDateOfBirth(rs.getDate(7));
				cd.setMobileNo(rs.getString(8));
				cd.setAddress(rs.getString(9));
				cd.setEmailId(rs.getString(10));
				candidateList.add(cd);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return candidateList;
	}

	@Override
	public ArrayList<ResultBean> viewElectionResult() {
		con = DBUtil.getConnection();
		ArrayList<ResultBean> result = new ArrayList<>();
		try {
			ps = con.prepareStatement("Select * from evs_tbl_result");
			ResultSet rs = null;
			rs = ps.executeQuery();
			while (rs.next()) {
				ResultBean rbean = new ResultBean();
				rbean.setSerialNo(rs.getInt(1));
				rbean.setElectionId(rs.getString(2));
				rbean.setCandidateId(rs.getString(3));
				rbean.setVoteCount(rs.getInt(4));
				result.add(rbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ElectionBean> viewAllElections() {
		con = DBUtil.getConnection();
		ArrayList<ElectionBean> election = new ArrayList<>();
		try {
			String sql = " select * from evs_tbl_election";
			ps = con.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
			election = new ArrayList<>();
			while (rs.next()) {
				ElectionBean eb = new ElectionBean();
				eb.setElectionId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setElectionDate(rs.getDate(3));
				eb.setDistrict(rs.getString(4));
				eb.setConstituency(rs.getString(5));
				eb.setCountingDate(rs.getDate(6));

				election.add(eb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return election;
	}

	@Override
	public String requestVoterId(String userId) {
		con = DBUtil.getConnection();
		try {
			ps = con.prepareStatement("select count(*) from evs_tbl_application where userId = ?");
			ps.setString(1, userId);
			ResultSet r = ps.executeQuery();
			int count = 0;
			while (r.next()) {
				count++;
			}
			if(count > 1) {
				return "else";
			}
			ps.close();
			ps = con.prepareStatement("select city from evs_tbl_user_profile where userId = ?");
			ps.setString(1, userId);
			ResultSet rs = null;
			rs = ps.executeQuery();
			String city = "";
			if (rs.next())
				rs.getString(1);
			ps = con.prepareStatement("insert into evs_tbl_application values(?,?,?,?,?)");
			ps.setString(1, userId);
			ps.setString(2, city);
			ps.setInt(3, 1);
			ps.setInt(4, 0);
			ps.setString(5, null);
			int i = ps.executeUpdate();
			if (i > 0) {
				return "SUCCESS";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String viewGeneratedVoterId(String userId, String constituency) {
		con = DBUtil.getConnection();
		try {
			ps = con.prepareStatement("select voterid from evs_tbl_application where userId = ? and constituency = ?");
			ps.setString(1, userId);
			ps.setString(2, constituency);
			ResultSet rs = null;
			rs = ps.executeQuery();
			if (rs.next()) {
				String s = rs.getString(1);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
