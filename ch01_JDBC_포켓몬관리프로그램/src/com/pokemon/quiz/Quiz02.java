package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		String user="jsp010930we";
		String password="jsppassword";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc= new Scanner(System.in);
		System.out.print("입력할 포켓몬의 이름을 입력해주세요 :");
		String name=sc.next();
		System.out.print("입력할 포켓몬의 체력을 입력해주세요 :");
		int hp=sc.nextInt();
		String sql="INSERT INTO pokemon(name,hp) VALUES('"+name+"',"+hp+")";
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection(url, user, password);
			
			ps=con.prepareStatement(sql);
			
			ps.execute();
			
			System.out.println("포켓몬 입력 완료");
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

