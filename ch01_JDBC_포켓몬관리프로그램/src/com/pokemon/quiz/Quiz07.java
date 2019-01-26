package com.pokemon.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.pokemon.util.MyUtil;

/*
 * ���ϸ��� ��ȣ�� �Է¹޾� �ش� ���ϸ��� ����
 * ���� �ߴٸ� : "���� �Ϸ�"
 * ���� ���ߴٸ� : "���� ����"
 */
public class Quiz07 {

	public static void main(String[] args) {
		Connection con=null;	//db�������
		PreparedStatement ps =null; //������ ����
		int rs= 0;	//������ ����� �޾ƿ�
		
		Scanner sc= new Scanner(System.in);
		System.out.print("������ ���ϸ��� ��ȣ�� �Է����ּ��� :");
		int num=sc.nextInt();
		String sql="DELETE FROM pokemon WHERE num="+num;
		
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeUpdate();
			if(rs!=0) System.out.println("���� �Ϸ�!");
			else System.out.println("���� ����");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps);
		}

	}

}
