package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * �̸��� �Է� �ް� �ش� ���ϸ� ����
 */
public class Quiz04 {

	public static void main(String[] args) {
		String user="jsp010930we";
		String password="jsppassword";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc= new Scanner(System.in);
		System.out.print("������ ���ϸ��� �̸��� �Է����ּ��� :");
		String name=sc.next();
		String sql="DELETE FROM pokemon WHERE name='"+name+"'";
		
	Connection con=null;
	PreparedStatement ps=null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con=DriverManager.getConnection(url, user, password); 
		
		ps=con.prepareStatement(sql);
		
		ps.execute();
		
		System.out.println("���� �Ϸ�");
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	}	

}
