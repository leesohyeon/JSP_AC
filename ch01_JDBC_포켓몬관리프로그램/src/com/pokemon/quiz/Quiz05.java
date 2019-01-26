package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import com.pokemon.util.MyUtil;

/*
 * 검색키워드 입력받고 , 이름에 해당 키워드가 포함된 포켓몬들의 이름, 레벨, 번호 출력
 * ex)츄 -->라이츄 , 피카츄, 피츄 의 모든 정보
 */
public class Quiz05 {

	public static void main(String[] args) {
		Connection con=null;	//db연결통로
		PreparedStatement ps =null; //쿼리문 로켓
		ResultSet rs= null;	//쿼리문 결과를 받아올
		
		Scanner sc=new Scanner(System.in);
		System.out.print("검색 키워드 : ");
		String keyword=sc.next();
		String sql="SELECT name,lv,num FROM pokemon where name like '%"+keyword+"%'";
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			System.out.println("NUM\t\tNAME\t\tLV");
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t\t");
				System.out.print(rs.getString("name")+"\t\t");
				System.out.print(rs.getInt("lv")+"\t\t");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}
	}

}
