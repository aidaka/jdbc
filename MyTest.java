package daka;

import java.sql.*;
public class MyTest {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/manpowermanagesystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    private static final String DBUSER = "root";//�û���
    private static final String DBPASS = "164137";//���ݿ�����
	public static void main(String[] args){
		Connection ct = null;  //��������
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName(DBDRIVER);
			ct=DriverManager.getConnection(DBURL, DBUSER, DBPASS);	
			statement = ct.createStatement();  //Ĭ��ֻ����ǰ����
			rs = statement.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println(rs.getString("title"));

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ct != null){
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
	}
}