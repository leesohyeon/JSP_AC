package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import com.pokemon.util.MyUtil;

/*
 * �˻�Ű���� �Է¹ް� , �̸��� �ش� Ű���尡 ���Ե� ���ϸ���� �̸�, ����, ��ȣ ���
 * ex)�� -->������ , ��ī��, ���� �� ��� ����
 */
public class Quiz05 {

	public static void main(String[] args) {
		Connection con=null;	//db�������
		PreparedStatement ps =null; //������ ����
		ResultSet rs= null;	//������ ����� �޾ƿ�
		
		Scanner sc=new Scanner(System.in);
		System.out.print("�˻� Ű���� : ");
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
