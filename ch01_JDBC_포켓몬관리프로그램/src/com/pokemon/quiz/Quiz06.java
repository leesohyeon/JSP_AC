package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pokemon.util.MyUtil;

//��ü ���ϸ��� ���� ���
public class Quiz06 {
	public static void main(String[] args) {
		String sql="select count(*) from pokemon";
		Connection con=null;	//db�������
		PreparedStatement ps =null; //������ ����
		ResultSet rs= null;	//������ ����� �޾ƿ�
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			System.out.println("��"+rs.getInt("count(*)")+"����");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}
	}
}
