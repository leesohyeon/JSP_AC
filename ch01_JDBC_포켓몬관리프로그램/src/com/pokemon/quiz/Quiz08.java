package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pokemon.util.MyUtil;

/*
 * 체력이 가장 강한 포켓몬의 이름, 레벨, 체력 출력 
 *   sql = "SELECT name, lv, hp FROM pokemon "
 *   	 + "WHERE hp = (SELECT MAX(hp) FROM pokemon)"
 */
public class Quiz08 {

	public static void main(String[] args) {
		Connection con=null;	//db연결통로
		PreparedStatement ps =null; //쿼리문 로켓
		ResultSet rs= null;	//쿼리문 결과를 받아올
		String sql="SELECT name,lv, hp FROM pokemon WHERE hp = (SELECT MAX(hp) FROM pokemon)";
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			System.out.println("체력이 가장 강한 포켓몬 : "+rs.getString("name"));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}
	}

}
