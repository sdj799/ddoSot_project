package com.marriage.manager;

import static com.marriage.view.AppUI.*;

import java.util.List;

import com.marriage.common.MenuInterface;
import com.marriage.member.domain.Member;

public class ManagerService implements MenuInterface {

	private final ManagerRepository managerRepository = new ManagerRepository();
	
	@Override
	public void start() {
		
		while(true) {
			showManagerMenu();
			int select = inputInteger();

			switch (select) {
			case 1:
				insertManagerData();
				break;
			case 2:
				showMenResult();
				break;
			case 3:
				showWomenResult();
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
	
	//매니저 추가 로직
	private void insertManagerData() {
		System.out.println("****** 회원 등록을 시작합니다.");
		System.out.print("* 이름 : ");
		String name = inputString();
		
		Manager newManager = new Manager();
		newManager.setManagerName(name);
		newManager.setPerformance(0);
		
		managerRepository.addManager(newManager);
	}
	
	
	//매니저별 남자회원 검색 로직
	private List<Member> searchMenMember() {
		showManagerPerformance();
		System.out.println("****** 담당 매니저 번호를 입력하세요.");
		System.out.print("* 매니저번호 : ");
		int managerNum = inputInteger();
		return managerRepository.menByManagerList(managerNum);
	}
	
	private void showMenResult() {
		List<Member> men = searchMenMember();
		
		if(!men.isEmpty()) {
			System.out.println("\n****** 남자 회원 조회 결과");
			for(Member member : men) {
				System.out.println(member);
			}
		} else {
			System.out.println("\n*** 조회 결과가 없습니다.");
		}
	}
	
	
	
	
	//매니저별 여자회원 검색 로직
	private List<Member> searchWomenMember() {
		showManagerPerformance();
		System.out.println("****** 담당 매니저 번호를 입력하세요.");
		System.out.print("* 매니저번호 : ");
		int managerNum = inputInteger();
		return managerRepository.womenByManagerList(managerNum);
	}
	
	private void showWomenResult() {
		List<Member> women = searchWomenMember();
		
		if(!women.isEmpty()) {
			System.out.println("\n****** 여자 회원 조회 결과");
			for(Member member : women) {
				System.out.println(member);
			}
		} else {
			System.out.println("\n*** 조회 결과가 없습니다.");
		}
	}
	
	//매니저별 목록 조회 로직
	private void showManagerPerformance() {
		List<Manager> managers = managerRepository.performanceList();
		
		if(!managers.isEmpty()) {
			System.out.println("\n****** 매니저 목록 조회");
			for(Manager manager : managers) {
				System.out.println(manager);
			}
		} else {
			System.out.println("\n*** 조회 결과가 없습니다.");
		}
	}
	
	
	
	
	
	

}
