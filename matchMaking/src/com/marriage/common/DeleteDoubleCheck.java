package com.marriage.common;

import static com.marriage.view.AppUI.*;

public class DeleteDoubleCheck {
	
	public static int deleteDoubleCheck() {
		System.out.println("*** 정말로 삭제하시겠습니까? ***");
		System.out.print("[Y/N]>>> ");
		String check = inputString();
		if(check.equals("Y") || check.equals("y")) {
			return 1;
		} else if(check.equals("N") || check.equals("n")){
			return 2;
		} else return 3;
	}
	
	public static int doubleCheck() {
		System.out.println("*** 정말로 결혼하시겠습니까? ***");
		System.out.print("[Y/N]>>> ");
		String check = inputString();
		if(check.equals("Y") || check.equals("y")) {
			return 1;
		} else if(check.equals("N") || check.equals("n")){
			return 2;
		} else return 3;
	}
}
