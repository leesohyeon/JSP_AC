package com.pokemon.quiz;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * ���ϸ� �̸��� �Է¹ް� ���� ����
 *  �� ü�°� �� ������ �Է¹ް� �̵� ������ DB����
 */
public class Quiz03 {

	public static void main(String[] args) {
		String user="jsp010930we";
		String password="jsppassword";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc= new Scanner(System.in);
		System.out.print("�Է��� ���ϸ��� �̸��� �Է����ּ��� :");
		String name=sc.next();
		System.out.print("������ ���ϸ��� ü���� �Է����ּ��� :");
		int hp=sc.nextInt();
		System.out.print("������ ���ϸ��� ������ �Է����ּ��� :");
		int level=sc.nextInt();
		String sql="UPDATE pokemon SET hp="+hp+",lv="+level+"where name='"+name+"'";
		
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
