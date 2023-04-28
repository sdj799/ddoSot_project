package com.marriage.matching;

import com.marriage.member.domain.Member;

public class MatchingGrade {

	// 등급을 매겨주는 로직
	public static void matchingGrade(Member mem) {
		int point = 0;
		// 나이 기준 점수
		if(mem.getAge()<= 38 && mem.getAge() >= 28) { // 28~38 +3점
			point += 3;
		} else if(mem.getAge() <=43 || mem.getAge() >= 23) {// 23~43 +2점
			point += 2;
		} else if(mem.getAge() <=46 || mem.getAge() <= 20) { //43~46, 20~23 +1점 나머지 0점
			point += 1;
		}
		// 연봉 기준 점수
		if(mem.getSalary() <= 20000000) {
			point += 1;
		} else if(mem.getSalary() <= 30000000) {
			point += 2;
		} else if(mem.getSalary() <= 50000000) {
			point += 3;
		} else if(mem.getSalary() <= 70000000) {
			point += 4;
		} else if(mem.getSalary() <= 100000000) {
			point += 5;
		} else {point +=6;}
		// 점수기준 나중에 더 추가
		
		// 등급 설정
		if(point <= 2) {
			mem.setGrade("브론즈");
		} else if(point <= 4) {
			mem.setGrade("실버");
		} else if(point <= 6) {
			mem.setGrade("골드");
		} else if(point <= 8) {
			mem.setGrade("플레티넘");
		} else {
			mem.setGrade("다이아");
		}
	}
}
