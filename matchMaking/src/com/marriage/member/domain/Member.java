package com.marriage.member.domain;

public class Member {
	
	private String gender;
	private String id;
	private String name;
	private int age;
	private String job;
	private int salary;
	private String grade;
	private int count;
	private String partnerId;
	private int managerNum;
	
	public Member() {}

	public Member(String gender, String id, String name, int age, String job, int salary,
			String grade, int count, String partnerId, int managerNum) {
		super();
		this.gender = gender;
		this.id = id;
		this.name = name;
		this.age = age;
		this.job = job;
		this.salary = salary;
		this.grade = grade;
		this.count = count;
		this.partnerId = partnerId;
		this.managerNum = managerNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public int getManagerNum() {
		return managerNum;
	}

	public void setManagerNum(int managerNum) {
		this.managerNum = managerNum;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", age=" + age + ", job=" + job
				+ ", salary=" + salary + ", grade=" + grade + ", count=" + count + ", partnerId=" + partnerId
				+ ", managerNum=" + managerNum + "]";
	}
	
	

}