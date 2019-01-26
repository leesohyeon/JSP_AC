package com.pokemon.quiz;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * 포켓몬 이름을 입력받고 정보 수정
 *  새 체력과 세 레벨을 입력받고 이들 정보로 DB수정
 */
public class Quiz03 {

	public static void main(String[] args) {
		String user="jsp010930we";
		String password="jsppassword";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc= new Scanner(System.in);
		System.out.print("입력할 포켓몬의 이름을 입력해주세요 :");
		String name=sc.next();
		System.out.print("변경할 포켓몬의 체력을 입력해주세요 :");
		int hp=sc.nextInt();
		System.out.print("변경할 포켓몬의 레벨을 입력해주세요 :");
		int level=sc.nextInt();
		String sql="UPDATE pokemon SET hp="+hp+",lv="+level+"where name='"+name+"'";
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection(url, user, password); 
			
			ps=con.prepareStatement(sql);
			
			ps.execute();
			
			System.out.println("수정 완료");
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
