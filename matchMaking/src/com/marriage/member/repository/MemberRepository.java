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
//		public void showManagerList() {
//			String sql = "SELECT * FROM managers";
//			
//			try(Connection conn = connection.getConnection();
//					PreparedStatement pstmt = conn.prepareStatement(sql)) {
//				ResultSet rs = pstmt.executeQuery();
//				
//				while(rs.next()) {
//					Manager manager = new Manager(
//								
//							);
//					System.out.println(manager);
//				}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}

	//회원 검색
	public void memberList (int select) {
		System.out.println("*************** 회원 리스트 ***************");
		String sql = "";
		if(select == 1) {
			sql = "SELECT * FROM men";
		} else if(select == 2) {
			sql = "SELECT * FROM women";
		} else {
			System.out.println("잘못된 입력입니다.");
			return;
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

	public void modifyMemberInfo(String id, int select) {
		String sql = "";
		if(select == 1) {
			sql = "DELETE FROM men WHERE id = ?";
		} else if(select == 2) {
			sql = "DELETE FROM women WHERE id = ?";
		} else {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			if(pstmt.executeUpdate() == 1) {
				System.out.println("\n*** 회원정보가 정상 삭제되었습니다.");
			} else {
				System.out.println("\n*** 검색한 회원의 회원번호로만 삭제가 가능합니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
