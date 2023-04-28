package com.marriage.member.service;

import static com.marriage.view.AppUI.inputInteger;
import static com.marriage.view.AppUI.showMemberMenu;

import com.marriage.common.MenuInterface;

public class MemberService implements MenuInterface {

	@Override
	public void start(int select) {

		switch (select) {
		case 1:
			showMemberMenu();
			select = inputInteger();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		default:
			System.out.println("*** 잘못된 입력입니다.");
		}
		
	}

	

}
