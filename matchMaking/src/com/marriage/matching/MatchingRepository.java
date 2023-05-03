package com.marriage.matching;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marriage.common.DataBaseConnection;
import com.marriage.member.domain.Member;

import static com.marriage.view.AppUI.*;

public class MatchingRepository {

	private DataBaseConnection connection = DataBaseConnection.getInstance();

	//매칭을 DB에 추가하는 로직
	public void addMatching(int managerNum, String menId, String womenId) {
		String sql = "INSERT INTO matching (match_num, men_id, women_id, manager_num) "
				+ "VALUES(matching_seq.NEXTVAL, ?, ?, ?)";

		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, menId);
			pstmt.setString(2, womenId);
			pstmt.setInt(3, managerNum);
			if(pstmt.executeUpdate() == 1) {
				System.out.println("\n*** 매칭이 정상 등록되었습니다.");
			} else {
				System.out.println("\n*** 매칭 등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// 매니저 아이디를 받아서 검색해주는 로직
	public boolean searchId(int managerNum, boolean gender) {
		String sql = "";
		boolean flag = false;
		if(gender) {
			sql = "SELECT * FROM men WHERE partner_id IS NULL AND manager_num = ? AND count > 0";
		} else {
			sql = "SELECT * FROM women WHERE partner_id IS NULL AND manager_num = ? AND count > 0";
		}
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, managerNum);
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
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} return flag;
	}
	
	// 매칭된 리스트를 보여주는 메서드
	public boolean showMatchingList() {
        String sql = "SELECT * FROM matching WHERE married IS NULL";
        boolean flag = false;
        try (Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();){
            while(rs.next()) {
                Matching mat = new Matching(
                        rs.getInt("match_num"),
                        rs.getString("men_id"),
                        rs.getString("women_id"),
                        rs.getInt("manager_num")
                        );
                System.out.println(mat);
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
	
//	//같은 등급으로 매칭
//	public void searchgrade(Member mem) {
//		String sql = "";
//		String grade = mem.getGrade();
//		
//		if(mem.getId().charAt(0) == 'A') {
//			sql = "SELECT * FROM women WHERE grade = '" + grade + "'" ;
//		} else {
//			sql = "SELECT * FROM men WHERE grade = '" + grade + "'";
//		} 
//		try (Connection conn = connection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();) {
//			while(rs.next()) {
//				if(rs.getString("partner_id") == null) { //파트너가 없는 사람만 보기
//				Member men = new Member(
//						"",
//						rs.getString("id"),
//						rs.getString("name"),
//						rs.getInt("age"),
//						rs.getString("job"),
//						rs.getInt("salary"),
//						rs.getString("grade"),
//						rs.getInt("count"),
//						rs.getString("partner_id"),
//						rs.getInt("manager_num")
//						);
//				System.out.println(men);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	//파트너 아이디를 추가해주는 메서드
	public void addPart(String menId , String womenId) {
		String sql1 = "UPDATE men SET partner_id = ? WHERE id = ?";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql1);) {
			pstmt.setString(1, womenId);
			pstmt.setString(2, menId);
			if(pstmt.executeUpdate() == 1) {
				System.out.println("\n*** 파트너가 정상 등록되었습니다.");
			} else {
				System.out.println("\n*** 파트너 등록에 실패하였습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		String sql2 = "UPDATE women SET partner_id = ? WHERE id = ?";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql2);) {
			pstmt.setString(1, menId);
			pstmt.setString(2, womenId);
			if(pstmt.executeUpdate() == 1) {
				System.out.println("\n*** 파트너가 정상 등록되었습니다.");
			} else {
				System.out.println("\n*** 파트너 등록에 실패하였습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 매칭 객체를 받아오는 메서드
	public Matching selectMatching(int selectNum) {
		Matching matching = new Matching();
		String sql = "SELECT * FROM matching WHERE match_num = ?";
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, selectNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				matching = new Matching(
						rs.getInt("match_num"),
						rs.getString("men_id"),
						rs.getString("women_id"),
						rs.getInt("manager_num")
						);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return matching;
	}
	
	// 매칭 삭제
	public void deleteMatching(Matching delMat) {
		String sql1 = "DELETE FROM matching WHERE match_num = ?";
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql1)) {
			pstmt.setInt(1, delMat.getMatchNo());
			if(pstmt.executeUpdate() == 1) {
				System.out.println("\n*** 매칭이 정상적으로 취소 되었습니다.");
			} else {
				System.out.println("\n*** 매칭 취소에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql2 = "UPDATE men SET partner_id = NULL WHERE id = ?";
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setString(1, delMat.getMenNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql3 = "UPDATE women SET partner_id = NULL WHERE id = ?";
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql3)) {
			pstmt.setString(1, delMat.getWomenNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 아이디를 받아 맴버를 찾는 메서드
//	public Member searchMember() {
//		System.out.println("아이디를 입력하세요");
//		System.out.print(">>>");
//		String id = inputString();
//		String sql = "";
//		Member mem = new Member();
//		if(id.charAt(0) == 'A') {
//			sql = "SELECT * FROM men WHERE id = '" + id + "'";
//		} else {
//			sql = "SELECT * FROM women WHERE id = '" + id + "'" ;
//		}
//		try (Connection conn = connection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();) {
//				while(rs.next()) {
//				mem = new Member(
//						"",
//						rs.getString("id"),
//						rs.getString("name"),
//						rs.getInt("age"),
//						rs.getString("job"),
//						rs.getInt("salary"),
//						rs.getString("grade"),
//						rs.getInt("count"),
//						rs.getString("partner_id"),
//						rs.getInt("manager_num")
//						);
//				}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(mem);
//		return mem;
//	}
	// 결혼 확정 메서드
	public void marry(int i) {
        String sql = "UPDATE matching SET married = ? WHERE match_num = ? AND married IS NULL";
        try (Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, "O");
            pstmt.setInt(2, i);
            if(pstmt.executeUpdate() == 1) {
                System.out.println("\n### 결혼을 확정합니다");
            } else {
                System.out.println("\n### 결혼등록에 실패하였습니다.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
