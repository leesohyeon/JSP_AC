package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Quiz01 {

	public static void main(String[] args) {
		String user="jsp010930we";
		String password="jsppassword";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String sql="delete pokemon where num=1";
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection(url, user, password);
			
			ps=con.prepareStatement(sql);
			ps.execute();
			
			System.out.println("1번 삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
