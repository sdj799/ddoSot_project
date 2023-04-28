package com.marriage.manager;

public class Manager {

	private int managerId;
	private String managerName;
	private int performance;
	
	public Manager() {}

	public Manager(int managerId, String managerName, int performance) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.performance = performance;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
		return "Manager [매니저번호: " + managerId + ", 매니저이름: " + managerName + ", 실적: " + performance
				+ "]";
	}
	
	
}

