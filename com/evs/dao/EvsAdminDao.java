package com.evs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.evs.bean.ApplicationBean;
import com.evs.bean.CandidateBean;
import com.evs.bean.ElectionBean;
import com.evs.bean.PartyBean;
import com.evs.bean.ResultBean;
import com.evs.util.DBUtil;

public class EvsAdminDao implements EvsAdminDaoInterface {
	private static Connection connect = null;
	private PreparedStatement ps = null;

	@Override
	public String addElection(ElectionBean electionBean) {
		connect = DBUtil.getConnection();
		String result = null;

		try {
			ps = connect.prepareStatement("select ecount from number");
			ResultSet rs = ps.executeQuery();
			String eid = electionBean.getConstituency().substring(0, 2);
			if (rs.next()) {
				int tmp = rs.getInt(1);
				eid += String.valueOf(tmp);
			}
			ps = connect.prepareStatement("update number set ecount = ecount+1");
			ps.executeUpdate();
			ps = connect.prepareStatement("insert into evs_tbl_election values(?,?,?,?,?,?)");
			ps.setString(1, eid);
			ps.setString(2, electionBean.getName());
			ps.setDate(3, electionBean.getElectionDate());
			ps.setString(4, electionBean.getDistrict());
			ps.setString(5, electionBean.getConstituency());
			ps.setDate(6, electionBean.getCountingDate());

			int i = ps.executeUpdate();
			if (i > 0) {
				result = "SUCCESS";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<ElectionBean> viewAllUpComingElections() {
		connect = DBUtil.getConnection();
		ArrayList<ElectionBean> elections = null;
		try {
			String sql = " select * from evs_tbl_election where electionndate > DATE(now())";
			ps = connect.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
			elections = new ArrayList<>();
			while (rs.next()) {
				ElectionBean eb = new ElectionBean();
				eb.setElectionId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setElectionDate(rs.getDate(3));
				eb.setDistrict(rs.getString(4));
				eb.setConstituency(rs.getString(5));
				eb.setCountingDate(rs.getDate(6));
				elections.add(eb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elections;
	}

	@Override
	public ArrayList<ElectionBean> viewAllElections() {
		connect = DBUtil.getConnection();
		ArrayList<ElectionBean> elections = null;
		try {
			String sql = " select * from evs_tbl_election";
			ps = connect.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
			elections = new ArrayList<>();
			while (rs.next()) {
				ElectionBean eb = new ElectionBean();
				eb.setElectionId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setElectionDate(rs.getDate(3));
				eb.setDistrict(rs.getString(4));
				eb.setConstituency(rs.getString(5));
				eb.setCountingDate(rs.getDate(6));
				elections.add(eb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elections;
	}

	@Override
	public String addParty(PartyBean partyBean) {
		connect = DBUtil.getConnection();
		String result = null;
		try {
			ps = connect.prepareStatement("select pcount from number");
			ResultSet rs = ps.executeQuery();
			String pid = partyBean.getName().substring(0, 2);
			if (rs.next()) {
				int tmp = rs.getInt(1);
				pid += String.valueOf(tmp);
			}
			ps = connect.prepareStatement("update number set pcount = pcount+1");
			ps.executeUpdate();
			ps = connect.prepareStatement("insert into  evs_tbl_party values(?,?,?,?)");
			ps.setString(1, pid);
			ps.setString(2, partyBean.getName());
			ps.setString(3, partyBean.getLeader());
			ps.setString(4, partyBean.getSymbol());

			int i = ps.executeUpdate();
			if (i > 0)
				result = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<PartyBean> viewParty() {
		connect = DBUtil.getConnection();
		ArrayList<PartyBean> party = null;
		try {
			String sql = " select * from evs_tbl_party";
			ps = connect.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
			party = new ArrayList<>();
			while (rs.next()) {
				PartyBean eb = new PartyBean();
				eb.setPartyId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setLeader(rs.getString(3));
				eb.setSymbol(rs.getString(4));

				party.add(eb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return party;

	}

	@Override
	public String addCandidate(CandidateBean candidate) {
		connect = DBUtil.getConnection();
		String result = null;
		try {
			ps = connect.prepareStatement("select ccount from number");
			ResultSet rs = ps.executeQuery();
			String eid = candidate.getName().substring(0, 2);
			if (rs.next()) {
				int tmp = rs.getInt(1);
				eid += String.valueOf(tmp);
			}
			ps = connect.prepareStatement("update number set ccount = ccount+1");
			ps.executeUpdate();
			ps = connect.prepareStatement("insert into  evs_tbl_candidate values(?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, eid);
			ps.setString(2, candidate.getName());
			ps.setString(3, candidate.getElectionId());
			ps.setString(4, candidate.getPartyId());
			ps.setString(5, candidate.getDistrict());
			ps.setString(6, candidate.getConstituency());
			ps.setDate(7, candidate.getDateOfBirth());
			ps.setString(8, candidate.getMobileNo());
			ps.setString(9, candidate.getAddress());
			ps.setString(10, candidate.getEmailId());
			int i = ps.executeUpdate();
			if (i > 0)
				result = "SUCCESS";
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String election) {
		connect = DBUtil.getConnection();
		ArrayList<CandidateBean> candidateList = null;
		try {
			String sql = " select cd.candidateid, cd.name, cd.electionid, cd.partyid"
					+ ", cd.district, cd.constituency, cd.dateofbirth, cd.mobileno, cd."
					+ "address, cd.emailid from evs_tbl_candidate cd left join evs_tbl_"
					+ "election e on e.electionid = cd.electionid where e.name = ?";
			ps = connect.prepareStatement(sql);

			ps.setString(1, election);
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
	public ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId) {
		connect = DBUtil.getConnection();
		ArrayList<CandidateBean> candidateList = null;
		try {
			String sql = " select cd.candidateid, cd.name, cd.electionid, cd.partyid"
					+ ", cd.district, cd.constituency, cd.dateofbirth, cd.mobileno, cd."
					+ "address, cd.emailid from evs_tbl_candidate cd left join evs_tbl_"
					+ "election e on e.electionid = cd.electionid where cd.partyid = ?";
			ps = connect.prepareStatement(sql);

			ps.setString(1, partyId);
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
	public boolean forwardVoterIdRequest(String userId) {
		connect = DBUtil.getConnection();
		try {
			ps = connect.prepareStatement("update evs_tbl_application set passedstatus = 2 where userId = ?");
			ps.setString(1, userId);
			int count = ps.executeUpdate();
			if (count > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<ApplicationBean> viewAllAdminPendingApplications() {
		connect = DBUtil.getConnection();
		ArrayList<ApplicationBean> pending = null;
		try {
			ps = connect.prepareStatement("Select * from evs_tbl_application where passedstatus = 1");
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

	@Override
	public Map<ElectionBean, ResultBean> approveElectionResult(String electionId) {
		connect = DBUtil.getConnection();
		Map<ElectionBean, ResultBean> mp = null;
		try {
			ps = connect.prepareStatement("select r.electionid, r.candidateid, r.votecount, e.name, "
					+ " e.constituency from evs_tbl_result r join evs_tbl_election e where "
					+ "r.electionid = e.electionid and e.electionid = ?");
			ps.setString(1, electionId);

			ResultSet rs = ps.executeQuery();
			mp = new HashMap<>();
			while (rs.next()) {
				ElectionBean eb = new ElectionBean();
				ResultBean rb = new ResultBean();
				eb.setName(rs.getString(4));
				eb.setConstituency(rs.getString(5));
				rb.setElectionId(rs.getString(1));
				rb.setCandidateId(rs.getString(2));
				rb.setVoteCount(rs.getInt(3));
				mp.put(eb, rb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mp;
	}

}
