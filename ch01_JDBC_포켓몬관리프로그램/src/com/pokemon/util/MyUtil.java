package com.pokemon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyUtil {
	
	//�ڵ����� Ŀ�ؼ��� �����ؼ� �̸� �����ϴ� �޼ҵ�
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		String user="jsp010930we";
		String password="jsppassword";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(url, user, password); 
		return con;
	}
	//�ٸ� ���� con,ps�� ��� �ݾ��ִ� �޼ҵ�
	public static void close(Connection con , PreparedStatement ps) {
		try {
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
