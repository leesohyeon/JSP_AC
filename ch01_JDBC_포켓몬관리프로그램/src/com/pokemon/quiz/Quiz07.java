package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.pokemon.util.MyUtil;

/*
 * 포켓몬의 번호를 입력받아 해당 포켓몬을 삭제
 * 삭제 했다면 : "삭제 완료"
 * 삭제 못했다면 : "삭제 실패"
 */
public class Quiz07 {

	public static void main(String[] args) {
		Connection con=null;	//db연결통로
		PreparedStatement ps =null; //쿼리문 로켓
		int rs= 0;	//쿼리문 결과를 받아올
		
		Scanner sc= new Scanner(System.in);
		System.out.print("삭제할 포켓몬의 번호를 입력해주세요 :");
		int num=sc.nextInt();
		String sql="DELETE FROM pokemon WHERE num="+num;
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeUpdate();
			if(rs!=0) System.out.println("삭제 완료!");
			else System.out.println("삭제 실패");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}

	}

}
