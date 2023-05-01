package com.marriage.member.service;

import static com.marriage.view.AppUI.*;

import com.marriage.common.MenuInterface;
import com.marriage.member.domain.Member;
import com.marriage.member.repository.MemberRepository;

public class MemberService implements MenuInterface {
	
	private final MemberRepository memberRepository = new MemberRepository();

	@Override
	public void start() {

		while(true) {
			showMemberMenu();
			int select = inputInteger();

			switch (select) {
			case 1:
				register();
				break;
			case 2:
				showMemberList();
				break;
			case 3:
				showModifyMemberMenu();
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

	// 회원 등록 로직
	private void register() {
		System.out.println("****** 회원 등록을 시작합니다.");
		System.out.print("* 이름 : ");
		String name = inputString();
		System.out.print("* 성별 : ");
		String gender = inputString();
		System.out.print("* 나이 : ");
		int age = inputInteger();
		System.out.print("* 직업 : ");
		String job = inputString();
		System.out.print("* 연봉 : ");
		int salary = inputInteger();
		
		Member member = new Member();
		member.setName(name);
		member.setGender(gender);
		member.setAge(age);
		member.setJob(job);
		member.setSalary(salary);
		
		memberRepository.regToRepository(member);
		
	}
	
	// 회원 조회 로직
	private void showMemberList() {
		System.out.println("*** 성별을 선택 하세요.");
		System.out.println("[ 1. 남성 | 2. 여성 ]");
		System.out.print(">>> ");
		int select = inputInteger();		
		memberRepository.memberList(select);
		
	}
	
	// 회원 정보 삭제 로직
	private void showModifyMemberMenu() {
		System.out.println("*************** 회원 정보 삭제 ***************");
		System.out.println("*** 성별을 선택 하세요.");
		System.out.println("[ 1. 남성 | 2. 여성 ]");
		System.out.print(">>> ");
		int select = inputInteger();	
		memberRepository.memberList(select);
		System.out.println("*** 삭제할 회원의 아이디를 입력해 주세요.");
		System.out.print(">>> ");
		String id = inputString();
		memberRepository.modifyMemberInfo(id, select);
	}


}
