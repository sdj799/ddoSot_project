package com.marriage.matching;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.marriage.common.DataBaseConnection;
import com.marriage.member.domain.Member;

import static com.marriage.view.AppUI.*;

public class MatchingRepository {

	private DataBaseConnection connection = DataBaseConnection.getInstance();

	//매칭을 DB에 추가하는 로직
	public void addMatching(Matching mat) {
		System.out.println("repository: " + mat);
		String sql = "INSERT INTO users (match_num, men_id, women_id, manager_num) "
				+ "VALUES(matching_seq.NEXTVAL, ?, ?, ?)";

		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, mat.getMenNum());
			pstmt.setString(2, mat.getWomenNum());
			pstmt.setInt(3, mat.getManagerNum());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 매니저 아이디를 받아서 검색해주는 로직 남자 검색
	public void searchMenID(int i) {
		String sql = "";
		sql = "SELECT * FROM men WHERE manager_id =" + i ;
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				Member men = new Member(
						rs.getString("gender"),
						rs.getString("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("job"),
						rs.getInt("salary"),
						rs.getString("grade"),
						rs.getInt("count"),
						rs.getString("grade"),
						rs.getInt("managerNum")
						);
				System.out.println(men);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 여성 검색
	public void searchWomenID(int i) {
		String sql = "";
		sql = "SELECT * FROM women WHERE manager_id =" + i;
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				Member men = new Member(
						rs.getString("gender"),
						rs.getString("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("job"),
						rs.getInt("salary"),
						rs.getString("grade"),
						rs.getInt("count"),
						rs.getString("grade"),
						rs.getInt("managerNum")
						);
				System.out.println(men);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//파트너 아이디를 추가해주는 메서드
	public void addPart(String id , String ptid) {
		String sql = "";
		if(id.charAt(0) == 'A') {
			sql = "UPDATE partner_id = ? FROM men WHERE id = ?";
		} else {
			sql = "UPDATE partner_id = ? FROM women WHERE id = ?";
		} 
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, ptid);
			pstmt.setString(2, id);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 매칭 삭제
	public void deleteMatching() {
		int delMatNum = inputInteger();
		String sql = "DELETE FROM matching WHERE match_num =" + delMatNum;
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			if(pstmt.executeUpdate() == 1) {
				System.out.println("\n### 매칭이 취소 되었습니다.");
			} else {
				System.out.println("\n### 검색한 매칭이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
