package com.marriage.matching;

import static com.marriage.view.AppUI.*;

import static com.marriage.common.DeleteDoubleCheck.*;
import com.marriage.common.MenuInterface;
import com.marriage.member.repository.MemberRepository;

public class MatchingService implements MenuInterface {	
	
	private final MemberRepository memberRepository = new MemberRepository();
	private final MatchingRepository matchingRepository = new MatchingRepository();

	@Override
	public void start() {
		while(true) {
			showMatchingMenu();
			int select = inputInteger();

			switch (select) {
			case 1:
				matchingByManager();
				break;
			case 2:
				cancelMatching();
				break;
			case 3:
				SuccessMarry();
				break;		
			case 4:
				return;
			default:
				System.out.println("*** 잘못된 입력입니다.");
			}
			System.out.println("\n====== 계속 진행하시려면 ENTER를 누르세요 ======");
			inputString();
			
		}

	}
	
	//매니저별로 매칭하는 메서드
	private void matchingByManager() {
		memberRepository.showManagerList();
		System.out.println("*** 매니저를 선택해 주세요.");
		System.out.print(">>> ");
		int selectManagerNum = inputInteger();
		
		System.out.println("*************** 남성 리스트 ***************");
		if(!matchingRepository.searchId(selectManagerNum, true)) {
			System.out.println("매니저가 가지고 있는 남성리스트가 없습니다.");
			System.out.println("남자회원을 먼저 추가해주세요.");
			return;
		}
		System.out.println("*** 매칭할 남성의 아이디를 선택해 주세요.");
		System.out.print(">>> ");
		String selectMenId = inputString();
		if(!memberRepository.searchById(selectMenId, true)) {
			System.out.println("아이디를 확인해주세요");
			return;
		}
		System.out.println("*************** 여성 리스트 ***************");
		if(!matchingRepository.searchId(selectManagerNum, false)) {
			System.out.println("매니저가 가지고 있는 여성리스트가 없습니다.");
			System.out.println("여성회원을 먼저 추가해주세요.");
			return;
		}
		System.out.println("*** 매칭할 여성의 아이디를 선택해 주세요.");
		System.out.print(">>> ");
		String selectWomenId = inputString();
		if(!memberRepository.searchById(selectWomenId, false)) {
			System.out.println("아이디를 확인해주세요");
			return;
		};
		
		matchingRepository.addMatching(selectManagerNum, selectMenId, selectWomenId);
		matchingRepository.addPart(selectMenId, selectWomenId);
		
	}
	
	//매칭 취소하는 메서드
	private void cancelMatching() {
		System.out.println("*************** 매칭 기록 ***************");
		if(!matchingRepository.showMatchingList()) {
			System.out.println("*** 현재 매칭중인 커플이 없습니다.");
			return;
		};
		System.out.println("*** 취소할 매칭 기록의 번호를 선택해 주세요.");
		System.out.print(">>> ");
		int selectNum = inputInteger();
		int checkNum = deleteDoubleCheck();
		if(checkNum == 2) {
            System.out.println("*** 매칭삭제를 취소합니다.");
            return;
        } else if(checkNum == 3) {
            System.out.println("*** 잘못된 입력입니다.");
            return;
        }
		matchingRepository.deleteMatching(matchingRepository.selectMatching(selectNum));
		
	}
	
	//결혼을 확정하는 메서드
	private void SuccessMarry() {
		System.out.println("*************** 매칭 기록 ***************");
		if(!matchingRepository.showMatchingList()) {
			System.out.println("*** 현재 매칭중인 커플이 없습니다.");
			return;
		};
		System.out.println("*** 결혼을 확정할 매칭 기록의 번호를 선택해 주세요.");
		System.out.print(">>> ");
		int selectNum = inputInteger();
		int checkNum = doubleCheck();
		if(checkNum == 2) {
            System.out.println("*** 결혼을 취소합니다.");
            return;
        } else if(checkNum == 3) {
            System.out.println("*** 잘못된 입력입니다.");
            return;
        }
		matchingRepository.marry(selectNum);
	}

}
