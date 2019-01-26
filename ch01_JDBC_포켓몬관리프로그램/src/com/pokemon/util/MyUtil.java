package com.pokemon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyUtil {
	
	//자동으로 커넥션을 생성해서 이를 리턴하는 메소드
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		String user="jsp010930we";
		String password="jsppassword";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(url, user, password); 
		return con;
	}
	//다른 곳의 con,ps를 대신 닫아주는 메소드
	public static void close(Connection con , PreparedStatement ps) {
		try {
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
