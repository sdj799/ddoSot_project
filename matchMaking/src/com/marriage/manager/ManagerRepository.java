package com.marriage.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.marriage.common.DataBaseConnection;
import com.marriage.member.domain.Member;

public class ManagerRepository {

	private DataBaseConnection connection = DataBaseConnection.getInstance();

	//신규 매니저 등록
	public void addManager(Manager newManager) {
		String sql = "INSERT INTO manager " 
				+ "(manager_num, name, performance) " 
				+ "VALUES(manager_seq.NEXTVAL, ?, ?)";


		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, newManager.getManagerName());
			pstmt.setInt(2, newManager.getPerformance());

			if(pstmt.executeUpdate()==1) {
				System.out.println("신규매니저 등록에 성공하였습니다.");
			} else {
				System.out.println("신규매니저 등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	//매니저별 담당 남자회원 조회
	public List<Member> menByManagerList(int managerNum) {
		List<Member> menList = new ArrayList<>();
		String sql = "";
		sql = "SELECT * FROM men WHERE manager_num = ?";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, managerNum);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Member man = new Member(
						"M",
						rs.getString("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("job"),
						rs.getInt("salary"),
						rs.getString("grade"),
						rs.getInt("count"),
						rs.getString("partner_id"),
						rs.getInt("manager_num")
						);
				menList.add(man);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return menList;
	}

	//매니저별 담당 여자회원 조회
	public List<Member> womenByManagerList(int managerNum) {
		List<Member> womenList = new ArrayList<>();
		String sql = "SELECT * FROM women WHERE manager_num = ?";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, managerNum);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Member man = new Member(
						"F",
						rs.getString("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("job"),
						rs.getInt("salary"),
						rs.getString("grade"),
						rs.getInt("count"),
						rs.getString("partner_id"),
						rs.getInt("manager_num")
				);
				womenList.add(man);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return womenList;
	}


	//매니저별 실적 조회
	public List<Manager> performanceList() {
		List<Manager> performList = new ArrayList<>();
		String sql = "SELECT * FROM manager";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Manager manager = new Manager(
					rs.getInt("manager_num"),
					rs.getString("name"),
					rs.getInt("performance")
				);
				performList.add(manager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return performList;
	}
	
	
	
	


}
