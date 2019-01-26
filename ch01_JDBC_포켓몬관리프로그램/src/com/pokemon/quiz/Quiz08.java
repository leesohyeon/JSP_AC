package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pokemon.util.MyUtil;

/*
 * ü���� ���� ���� ���ϸ��� �̸�, ����, ü�� ��� 
 *   sql = "SELECT name, lv, hp FROM pokemon "
 *   	 + "WHERE hp = (SELECT MAX(hp) FROM pokemon)"
 */
public class Quiz08 {

	public static void main(String[] args) {
		Connection con=null;	//db�������
		PreparedStatement ps =null; //������ ����
		ResultSet rs= null;	//������ ����� �޾ƿ�
		String sql="SELECT name,lv, hp FROM pokemon WHERE hp = (SELECT MAX(hp) FROM pokemon)";
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			System.out.println("ü���� ���� ���� ���ϸ� : "+rs.getString("name"));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}
	}

}
