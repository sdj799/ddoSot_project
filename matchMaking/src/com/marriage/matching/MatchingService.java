package com.marriage.matching;

import com.marriage.common.MenuInterface;
import com.marriage.member.domain.Member;
import com.marriage.member.service.MemberService;

import static com.marriage.view.AppUI.*;



public class MatchingService implements MenuInterface {



	MatchingRepository matRep = new MatchingRepository();
	MemberService memSer = new MemberService();

	int i = 0; //  매니저 아이디
	String grade = ""; // 등급
	String gender = ""; // 성별
	

	@Override
	public void start() {
		Member loginMem = matRep.searchMember();
		while(true) {
//			if(loginMem.getId() == null) {
//				System.out.println("아이디를 확인해주세요");
//				continue;
//			}
			showMatchingMenu();
			int select = inputInteger();

			switch (select) {
			case 1:
				selectPart1(loginMem);
				break;
			case 2:
				selectPart2(loginMem);
				break;
			case 3:
				matRep.deleteMatching(loginMem);
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


	
	// 매칭할 상대를 선택하는 매서드
	public void selectPart1(Member mem) {
		String id = mem.getId();
		String ptid = "";
		if(gender.equals("m")) {
			matRep.searchMenID(mem);
			System.out.print("매칭할 상대의 아이디를 입력해주세요: ");
			ptid= inputString();
		} else {
			matRep.searchWomenID(mem);
			System.out.print("매칭할 상대의 아이디를 입력해주세요: ");
			ptid = inputString();
		}
		
		Matching mat = new Matching(1, id, ptid, mem.getManagerNum());
		matRep.addMatching(mat); // 매칭 db 저장
		matRep.addPart(id , ptid);
		matRep.addPart(ptid, mem.getId()); // 파트너 id 저장
	}
	public void selectPart2(Member mem) {
		String id = mem.getId();
		String ptid = "";
		
			matRep.searchgrade(mem);
			System.out.print("매칭할 상대의 아이디를 입력해주세요: ");
			ptid= inputString();
		
		Matching mat = new Matching(1, id, ptid, mem.getManagerNum());
		matRep.addMatching(mat); // 매칭 db 저장
		matRep.addPart(id , ptid);
		matRep.addPart(ptid, mem.getId()); // 파트너 id 저장
	}

}
