package com.marriage.view;

import java.util.Scanner;

public class AppUI {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String inputString() {
		return sc.nextLine();
	}
	
	public static int inputInteger() {
		int num = 0;
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			System.out.println("정수로 입력해 주세요.");
		} finally {
			sc.nextLine();
		}
		
		return num;
	}
	
	public static void showDraw() {
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⠀⠀⢀⣾⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⠀⠀⠘⢿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⠀⠀⠀⢸⣿⣯⡁⠀결혼혀Duo♥ ⢀⣤⣤⣄⡀⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣷⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⠀⠀⠀⣻⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢿⣿⡟⠁⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣧⠙⠳⢀⣀⡀⠀⠀⠀⠀⠀⣀⣾⣿⣇⠀⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⡀⠀⠀⠙⠿⢦⣤⣄⣠⣾⣿⣿⣿⣿⠀⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⡅⠀⠀⠀⠀⠀⠈⠙⠋⠁⣿⣿⣿⣿⠀⠀⠀⠀⠀\r\n"
				+ "  ⠀⠀⠀⠉⠉⢹⣿⠉⢹⣿⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀  ⠀⠀⠀⢸⣿⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣿⣿⣿⡿⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀  ⠀⢸⣿⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⣾⡿⠿⠛⣿⣿⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀  ⠀⣼⡇⠀⣸⡟⠀⠀⠀⠀⠀⠀⠀⠀⢹⡇⠀⠀⢿⣿⠀⠀⠀⢀⡀⠀\r\n"
				+ "⠀⠀⠀⠀  ⠀⢿⣧⣄⢿⣧⡀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠸⣿⣦⣴⡾⠛⣧⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠚⠃⠀⠀⠀⠉⠉⠁⠀⠀⠁⠀");
	}
	
	// 메인 메뉴 콘솔
	public static void showMainMenu() {
		System.out.println("*************** 전체 관리 메뉴 ***************");
		System.out.println("1. 회원 관리");
		System.out.println("2. 매칭 관리");
		System.out.println("3. 매니저 정보 관리");
		System.out.println("4. 프로그램 종료");
		System.out.println("********************************************");
		System.out.print(">>> ");
	}
	
	// 회원 정보 관리 콘솔
	public static void showMemberMenu() {
		System.out.println("*************** 회원 관리 메뉴 ***************");
		System.out.println("1. 회원 등록");
		System.out.println("2. 회원 전체 검색");
		System.out.println("3. 회원 정보 삭제");
		System.out.println("4. 돌아가기");
		System.out.println("*******************************************");
		System.out.print(">>> ");
	}
	
	// 매칭 관리 콘솔
	public static void showMatchingMenu() {
		System.out.println("*************** 매칭 메뉴 ***************");
		System.out.println("1. 매니저별 매칭");
		System.out.println("2. 매칭 취소");
		System.out.println("3. 결혼 확정");
		System.out.println("4. 돌아가기");
		System.out.println("*******************************************");
		System.out.print(">>> ");
	}
	// 매니저 정보 관리 콘솔
	public static void showManagerMenu() {
		System.out.println("*************** 매니저 관리 메뉴 ***************");
		System.out.println("1. 신규매니저 등록");
		System.out.println("2. 매니저별 남자회원 검색");
		System.out.println("3. 매니저별 여자회원 검색");
		System.out.println("4. 돌아가기");
		System.out.println("*******************************************");
		System.out.print(">>> ");
	}

}
