package com.student.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.student.util.MyUtil;

public class Main {
	Connection con;
	PreparedStatement ps ;
	ResultSet rs;
	String sql;
	void Insert() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("학생을 새로 입력합니다");
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.next();
		System.out.print("국어점수 : ");
		int korean = sc.nextInt();
		System.out.print("영어점수 : ");
		int english = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		int avg=(math+english+korean)/3;
		String grade;
		if (avg>=90) grade="A";
		else if (avg>=80) grade="B";
		else if (avg>=70) grade="C";
		else if (avg>=60) grade="D";
		else grade="F";
		String sql = "insert into student values(stu.nextval,'"+name+"',"+korean+","+english+","+math+","+avg+",'"+grade+"',sysdate)";
		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement(sql);
			if(1==ps.executeUpdate()) {
			System.out.println("입력 완료");
			}else System.out.println("입력 실패");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.close(con, ps);
		}
	}

	void Check(Boolean orderedByNum) {
		
		String sql = "SELECT * FROM student ORDER BY"+(orderedByNum ?" num asc" : " avg DESC");
		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("번호\t이름\t국어\t영어\t수학\t등급\t평균\t등록일자");
			while(rs.next()) {
			System.out.println(rs.getInt("num")+"번 \t"+rs.getString("name")+"\t"+rs.getInt("korean")
			+"\t"+rs.getInt("english")+"\t"+rs.getInt("math")+"\t"+rs.getString("grade")+"\t"+rs.getInt("avg")+"점\t"+rs.getString("regdate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.close(con, ps);
		}
	}

	
	void Search() {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("번호 입력 : ");
		int Snum=sc.nextInt();
		String sql = "SELECT * FROM student WHERE num="+Snum;
		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getInt("num")+"번  ");
			System.out.println("이름 : "+rs.getString("name"));
			System.out.println("국어 : "+rs.getInt("korean")+"점");
			System.out.println("영어 : "+rs.getInt("english")+"점");
			System.out.println("수학 : "+rs.getInt("math")+"점");
			System.out.println("학점 : "+rs.getString("grade"));
			System.out.println("총점 : "+rs.getInt("avg")+"점" );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.close(con, ps);
		}
	}
	
	void First() {
		
		String sql = "SELECT * FROM student WHERE avg=(select max(avg) from student)";
		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			System.out.println("1등 학생 >");
			System.out.println(rs.getInt("num")+"번  ");
			System.out.println("이름 : "+rs.getString("name"));
			System.out.println("국어 : "+rs.getInt("korean")+"점");
			System.out.println("영어 : "+rs.getInt("english")+"점");
			System.out.println("수학 : "+rs.getInt("math")+"점");
			System.out.println("학점 : "+rs.getString("grade"));
			System.out.println("총점 : "+rs.getInt("avg")+"점" );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.close(con, ps);
		}
	}
	
	void Delete() {
	
		Scanner sc= new Scanner(System.in);
		System.out.println("이름을 입력해주세요 : ");
		String name=sc.next();
		int num=0;
		String sql1 = "SELECT name,num FROM student WHERE name ='"+name+"'";

		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getInt("num")+"번  "+"\t"+rs.getString("name"));
			
			System.out.println("삭제할 학생의 번호를 입력해주세요 : ");
			num=sc.nextInt();
			
			String sql2 = "DELETE FROM student WHERE num="+num;
			ps = con.prepareStatement(sql2);
			if(1== ps.executeUpdate()) {
				System.out.println("삭제 완료");
			}else System.out.println("삭제 실패");
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("오류");
		} finally {
			MyUtil.close(con, ps);
		}
	}
	public static void main(String[] args) {

		Scanner sc= new Scanner (System.in);
		while(true) {
		System.out.println("=======학생 관리 프로그램=======");
		System.out.println("1. 학생 추가");
		System.out.println("2. 모든 학생 보기 (성적순)");
		System.out.println("3. 모든 학생 보기 (번호순)");
		System.out.println("4. 학생 검색");
		System.out.println("5. 1등 학생 보기");
		System.out.println("6. 학생 삭제");
		System.out.println("0. 종료");
		int sel=sc.nextInt();
		Main m=new Main();
		if(sel==1) m.Insert();
		else if(sel==2) m.Check(false);
		else if(sel==3)	m.Check(true);
		else if(sel==4)m.Search();
		else if(sel==5)m.First();
		else if(sel==6) m.Delete();
		else if(sel==0) break;
		else {
			System.out.println("번호를 잘못 입력하셨습니다 \n 다시 입력해 주세요");
			continue;
			}
		}
	}

}
