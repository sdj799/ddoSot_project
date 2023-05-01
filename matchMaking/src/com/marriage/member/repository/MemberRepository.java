package com.marriage.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marriage.common.DataBaseConnection;
import com.marriage.member.domain.Member;

public class MemberRepository {

	private DataBaseConnection connection = DataBaseConnection.getInstance();

	//회원 등록
	public void regToRepository(Member member) {
		String sql = "";

		if(member.getGender().equals("남")) {
			sql = "INSERT INTO men "
					+ "(id ,name, age, job, salary, manager_num) "
					+ "VALUES (men_seq.NEXTVAL, ?,?,?,?,?)";
		} else {
			sql = "INSERT INTO women "
					+ "(id ,name, age, job, salary, manager_num) "
					+ "VALUES (men_seq.NEXTVAL, ?,?,?,?,?)";
		}

		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getAge());
			pstmt.setString(3, member.getJob());
			pstmt.setInt(4, member.getSalary());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//매니저 목록 조회
	//	public void showManagerList() {
	//		String sql = "SELECT * FROM managers";
	//		
	//		try(Connection conn = connection.getConnection();
	//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	//			ResultSet rs = pstmt.executeQuery();
	//			
	//			while(rs.next()) {
	//				Manager manager = new Manager(
	//							
	//						);
	//				System.out.println(manager);
	//			}
	//			
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//		
	//	}

	//회원 검색
	public void memberList (int select) {
		String sql = "";
		if(select == 1) {
			sql = "SELECT * FROM men";
		} else {
			sql = "SELECT * FROM women";
		}
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Member member = new Member(
						"",
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
				System.out.println(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
