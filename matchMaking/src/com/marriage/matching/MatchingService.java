package com.marriage.matching;

import com.marriage.common.DataBaseConnection;
import com.marriage.common.MenuInterface;
import com.marriage.member.service.MemberService;

import static com.marriage.view.AppUI.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MatchingService implements MenuInterface {

	private DataBaseConnection connection = DataBaseConnection.getInstance();

	MatchingRepository matRep = new MatchingRepository();
	MemberService memSer = new MemberService();

	int i = 0; //  매니저 아이디
	String grade = ""; // 등급
	String gender = ""; // 성별

	@Override
	public void start() {
		while(true) {
			String id = inputId();
			logIn(id);
//			if(grade == "") continue; //잘못 입력했을때 다시 입력
			showMatchingMenu();
			int select = inputInteger();

			switch (select) {
			case 1:
				String ptid = "";
				if(gender.equals("m")) {
					matRep.searchMenID(i);
					System.out.print("매칭할 상대의 아이디를 입력해주세요: ");
					ptid= inputString();
				} else {
					matRep.searchWomenID(i);
					System.out.print("매칭할 상대의 아이디를 입력해주세요: ");
					ptid = inputString();
				}
				Matching mat = new Matching(1, id, ptid, i);
				matRep.addMatching(mat);
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:	return;
			default:
				System.out.println("*** 잘못된 입력입니다.");

				System.out.println("\n====== 계속 진행하시려면 ENTER를 누르세요 ======");
				inputString();
			}
		}

	}

	// 회원 번호 입력 로직
	public static String inputId() {
		System.out.println("회원님의 아이디를 입력하세요");
		System.out.print(">>>");
		return inputString();

	}

	// 아이디를 받아서 로그인 하는 매서드
	public void logIn(String id) {
		String sql = "";
		if(id.charAt(0) == 'A') {
			sql = "SELECT * FROM men WHERE id = " +"'"+id+"'";
			gender = "m";
		} else if(id.charAt(0) == 'B') {
			sql = "SELECT * FROM women WHERE id = " +"'"+id+"'";
			gender = "w";
		} else {
			System.out.println("잘못 입력하셨습니다");
			return;
		}

		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				i = rs.getInt("manager_num");
				grade = rs.getString("grade");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
