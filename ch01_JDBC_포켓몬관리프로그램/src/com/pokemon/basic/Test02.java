package com.pokemon.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pokemon.util.MyUtil;

//포켓몬의 모든 항목으 레벨 많은 순으로 조회
public class Test02 {

	public static void main(String[] args) {
		Connection con=null;	//db연결통로
		PreparedStatement ps =null; //쿼리문 로켓
		ResultSet rs= null;	//쿼리문 결과를 받아올
		String sql="SELECT * FROM pokemon ORDER BY lv DESC";
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			boolean bool = rs.next();
			while(rs.next()) {
				System.out.println("포켓몬 1마리 발견");
				String pName=rs.getString("name");
				int pLevel=rs.getInt("lv");
				int pHp=rs.getInt("hp");
				int pNum=rs.getInt("num");
				
				System.out.println("이름 : "+pName);
				System.out.println("체력 : "+pHp);
				System.out.println("레벨 : "+pLevel);
				System.out.println("번호 : "+pNum);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}

	}

}
