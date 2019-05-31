package daka;

import java.sql.*;
public class MyTest {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/manpowermanagesystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    private static final String DBUSER = "root";//用户名
    private static final String DBPASS = "164137";//数据库密码
	public static void main(String[] args){
		Connection ct = null;  //创建连接
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName(DBDRIVER);
			ct=DriverManager.getConnection(DBURL, DBUSER, DBPASS);	
			statement = ct.createStatement();  //默认只能向前滚动
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