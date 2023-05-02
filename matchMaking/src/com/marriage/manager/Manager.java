package com.marriage.manager;

public class Manager {

	private int managerNum;
	private String managerName;
	private int performance;
	
	public Manager() {}

	public Manager(int managerNum, String managerName, int performance) {
		super();
		this.managerNum = managerNum;
		this.managerName = managerName;
		this.performance = performance;
	}

<<<<<<< HEAD
	public int getManagerNum() {
=======
	public int getManagerId() {
>>>>>>> 080b759dc639b413b4718648df71fd3e22ced7cb
		return managerNum;
	}

	public void setManagerId(int managerNum) {
		this.managerNum = managerNum;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}

	@Override
	public String toString() {
		return "Manager [매니저번호: " + managerNum + ", 매니저이름: " + managerName + ", 실적: " + performance
				+ "]";
	}
	
	
}

