package com.marriage.main;

import static com.marriage.view.AppUI.*;

public class AppController {

	public void selectMainMenu(int selectNum) {		
		
		int select;
		
		switch (selectNum) {
		case 1:
			showMemberMenu();
			select = inputInteger();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			System.out.println("*** 프로그램을 종료합니다. ***");
			System.exit(0);
		default:
			System.out.println("*** 잘못된 입력입니다.");
		}
		
	}	

}
