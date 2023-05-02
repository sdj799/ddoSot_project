package com.marriage.main;

import com.marriage.common.MenuInterface;
<<<<<<< HEAD
import com.marriage.matching.MatchingService;
=======
import com.marriage.manager.ManagerService;
>>>>>>> 578f62de7467ecff4618fb2a678345a9f0ca2836
import com.marriage.member.service.MemberService;

public class AppController {

	private MenuInterface service;
	
	public void selectMainMenu(int selectNum) {		
		
		switch (selectNum) {
		case 1:
			service = new MemberService();			
			break;
		case 2:
			service = new MatchingService();
			break;
		case 3:
			service = new ManagerService();
			break;
		case 4:
			System.out.println("*** 프로그램을 종료합니다. ***");
			System.exit(0);
		default:
			System.out.println("*** 잘못된 입력입니다.");
		}
		
		service.start();
		
	}	

}
