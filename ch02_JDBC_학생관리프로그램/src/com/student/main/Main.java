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
		System.out.println("�л��� ���� �Է��մϴ�");
		System.out.print("�̸��� �Է����ּ��� : ");
		String name = sc.next();
		System.out.print("�������� : ");
		int korean = sc.nextInt();
		System.out.print("�������� : ");
		int english = sc.nextInt();
		System.out.print("�������� : ");
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
			System.out.println("�Է� �Ϸ�");
			}else System.out.println("�Է� ����");
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
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t���\t���\t�������");
			while(rs.next()) {
			System.out.println(rs.getInt("num")+"�� \t"+rs.getString("name")+"\t"+rs.getInt("korean")
			+"\t"+rs.getInt("english")+"\t"+rs.getInt("math")+"\t"+rs.getString("grade")+"\t"+rs.getInt("avg")+"��\t"+rs.getString("regdate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.close(con, ps);
		}
	}

	
	void Search() {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("��ȣ �Է� : ");
		int Snum=sc.nextInt();
		String sql = "SELECT * FROM student WHERE num="+Snum;
		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getInt("num")+"��  ");
			System.out.println("�̸� : "+rs.getString("name"));
			System.out.println("���� : "+rs.getInt("korean")+"��");
			System.out.println("���� : "+rs.getInt("english")+"��");
			System.out.println("���� : "+rs.getInt("math")+"��");
			System.out.println("���� : "+rs.getString("grade"));
			System.out.println("���� : "+rs.getInt("avg")+"��" );
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
			System.out.println("1�� �л� >");
			System.out.println(rs.getInt("num")+"��  ");
			System.out.println("�̸� : "+rs.getString("name"));
			System.out.println("���� : "+rs.getInt("korean")+"��");
			System.out.println("���� : "+rs.getInt("english")+"��");
			System.out.println("���� : "+rs.getInt("math")+"��");
			System.out.println("���� : "+rs.getString("grade"));
			System.out.println("���� : "+rs.getInt("avg")+"��" );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.close(con, ps);
		}
	}
	
	void Delete() {
	
		Scanner sc= new Scanner(System.in);
		System.out.println("�̸��� �Է����ּ��� : ");
		String name=sc.next();
		int num=0;
		String sql1 = "SELECT name,num FROM student WHERE name ='"+name+"'";

		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getInt("num")+"��  "+"\t"+rs.getString("name"));
			
			System.out.println("������ �л��� ��ȣ�� �Է����ּ��� : ");
			num=sc.nextInt();
			
			String sql2 = "DELETE FROM student WHERE num="+num;
			ps = con.prepareStatement(sql2);
			if(1== ps.executeUpdate()) {
				System.out.println("���� �Ϸ�");
			}else System.out.println("���� ����");
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("����");
		} finally {
			MyUtil.close(con, ps);
		}
	}
	public static void main(String[] args) {

		Scanner sc= new Scanner (System.in);
		while(true) {
		System.out.println("=======�л� ���� ���α׷�=======");
		System.out.println("1. �л� �߰�");
		System.out.println("2. ��� �л� ���� (������)");
		System.out.println("3. ��� �л� ���� (��ȣ��)");
		System.out.println("4. �л� �˻�");
		System.out.println("5. 1�� �л� ����");
		System.out.println("6. �л� ����");
		System.out.println("0. ����");
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
			System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ� \n �ٽ� �Է��� �ּ���");
			continue;
			}
		}
	}

}
