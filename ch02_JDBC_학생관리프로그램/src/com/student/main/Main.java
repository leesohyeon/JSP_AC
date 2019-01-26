package com.student.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.student.util.MyUtil;

public class Main {

	void insert() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("학생을 새로 입력합니다");
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.next();
		System.out.print("국어점수 : ");
		String korean = sc.next();
		System.out.print("영어점수 : ");
		String english = sc.next();
		System.out.print("수학점수 : ");
		String math = sc.next();
		
		String sql = "insert into student values(stu.nextval,'"+name+"',"+korean+","+english+","+math+",sysdate)";
		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.close(con, ps);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
