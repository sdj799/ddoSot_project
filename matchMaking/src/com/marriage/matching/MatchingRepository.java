package com.marriage.matching;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.marriage.common.DataBaseConnection;
import com.marriage.manager.Manager;
import com.marriage.member.domain.Member;

public class MatchingRepository {

	private DataBaseConnection connection = DataBaseConnection.getInstance();

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

	public void searchMenID(Manager m) {
		String sql = "";
		sql = "SELECT * FROM men WHERE manager_id =" + m.getManagerId() + ";";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				Member men = new Member(
						rs.getString("gender"),
						rs.getString("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("phone_number"),
						rs.getString("job"),
						rs.getInt("salary"),
						rs.getString("grade"),
						rs.getInt("count"),
						rs.getString("partener_id")
						);
				System.out.println(men);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
