package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pokemon.util.MyUtil;

//전체 포켓몬의 개수 출력
public class Quiz06 {
	public static void main(String[] args) {
		String sql="select count(*) from pokemon";
		Connection con=null;	//db연결통로
		PreparedStatement ps =null; //쿼리문 로켓
		ResultSet rs= null;	//쿼리문 결과를 받아올
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			System.out.println("총"+rs.getInt("count(*)")+"마리");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}
	}
}
