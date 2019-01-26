package com.pokemon.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pokemon.util.MyUtil;

//���ϸ��� ��� �׸��� ���� ���� ������ ��ȸ
public class Test02 {

	public static void main(String[] args) {
		Connection con=null;	//db�������
		PreparedStatement ps =null; //������ ����
		ResultSet rs= null;	//������ ����� �޾ƿ�
		String sql="SELECT * FROM pokemon ORDER BY lv DESC";
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			boolean bool = rs.next();
			while(rs.next()) {
				System.out.println("���ϸ� 1���� �߰�");
				String pName=rs.getString("name");
				int pLevel=rs.getInt("lv");
				int pHp=rs.getInt("hp");
				int pNum=rs.getInt("num");
				
				System.out.println("�̸� : "+pName);
				System.out.println("ü�� : "+pHp);
				System.out.println("���� : "+pLevel);
				System.out.println("��ȣ : "+pNum);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}

	}

}
