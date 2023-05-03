package com.marriage.matching;

public class Matching {

	private int matchNo;
	private String menNum;
	private String womenNum;
	private int managerNum;
	
	public Matching() {}
	
	public Matching(int matchNo, String menNum, String womenNum, int managerNum) {
		super();
		this.matchNo = matchNo;
		this.menNum = menNum;
		this.womenNum = womenNum;
		this.managerNum = managerNum;
	}
	public int getMatchNo() {
		return matchNo;
	}

	public void setMatchNo(int matchNo) {
		this.matchNo = matchNo;
	}

	public String getMenNum() {
		return menNum;
	}

	public void setMenNum(String menNum) {
		this.menNum = menNum;
	}

	public String getWomenNum() {
		return womenNum;
	}

	public void setWomenNum(String womenNum) {
		this.womenNum = womenNum;
	}

	public int getManagerNum() {
		return managerNum;
	}

	public void setManagerNum(int managerNum) {
		this.managerNum = managerNum;
	}

	@Override
	public String toString() {
		return "매칭번호: " + matchNo + "\t남자번호: " + menNum + "\t여자번호: " + womenNum + "\t매니저번호: "
				+ managerNum;
	}
	
	
	
}
