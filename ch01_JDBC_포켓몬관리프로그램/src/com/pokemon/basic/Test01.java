package com.pokemon.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01 {

	public static void main(String[] args) {
		String user="jsp010930we";
		String password="jsppassword";
		String url ="jdbc:oracle:thin:@localhost:1521:xe"; //DB위치 + 서비스 이름+ 포트
		String sql="INSERT INTO pokemon VALUES(pok_seq.NEXTVAL,'이상해꽃',10,35,SYSDATE)";
		
		Connection con=null;// java.sql.Connection 인터페이스(임포트해야함)
		PreparedStatement ps=null; //java.sql.PreparedStatement
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//커넥션 생성(Test01 <->DB연결통로 생성)
		con=DriverManager.getConnection(url, user, password);
		//명령문 준비
		ps=con.prepareStatement(sql);
		
		//명령문 실행
		ps.execute();
		
		System.out.println("이상해꽃 추가 완료!");
		} catch (Exception e) {
			e.printStackTrace(); //콘솔에 빨간 에러 출력
		}finally {
			//ps, con종료
			try {
				if(ps!=null) {//ps객체가 있으면
					ps.close();//닫아라
				}
				if(con!=null) {//con객체가 있으면
					con.close();//닫아라
				}
			}catch (Exception e) {
				e.printStackTrace();
			}//try/catch 2
		}//finally
	}//main

}//class
