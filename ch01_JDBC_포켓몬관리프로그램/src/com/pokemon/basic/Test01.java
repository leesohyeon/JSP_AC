package com.pokemon.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01 {

	public static void main(String[] args) {
		String user="jsp010930we";
		String password="jsppassword";
		String url ="jdbc:oracle:thin:@localhost:1521:xe"; //DB��ġ + ���� �̸�+ ��Ʈ
		String sql="INSERT INTO pokemon VALUES(pok_seq.NEXTVAL,'�̻��ز�',10,35,SYSDATE)";
		
		Connection con=null;// java.sql.Connection �������̽�(����Ʈ�ؾ���)
		PreparedStatement ps=null; //java.sql.PreparedStatement
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Ŀ�ؼ� ����(Test01 <->DB������� ����)
		con=DriverManager.getConnection(url, user, password);
		//��ɹ� �غ�
		ps=con.prepareStatement(sql);
		
		//��ɹ� ����
		ps.execute();
		
		System.out.println("�̻��ز� �߰� �Ϸ�!");
		} catch (Exception e) {
			e.printStackTrace(); //�ֿܼ� ���� ���� ���
		}finally {
			//ps, con����
			try {
				if(ps!=null) {//ps��ü�� ������
					ps.close();//�ݾƶ�
				}
				if(con!=null) {//con��ü�� ������
					con.close();//�ݾƶ�
				}
			}catch (Exception e) {
				e.printStackTrace();
			}//try/catch 2
		}//finally
	}//main

}//class
