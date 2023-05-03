package com.marriage.main;

import static com.marriage.view.AppUI.*;

public class Main {	

	public static void main(String[] args) {
		
		AppController appController = new AppController();
		showDraw();
		while(true) {
			showMainMenu();
			int selectNum = inputInteger();
			appController.selectMainMenu(selectNum);
		}
		

	}

}
