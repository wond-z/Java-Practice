package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://192.168.1.5:3306/family?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT%2B8";
	private static String user = "root";
	private static String password = "root";
	
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			System.out.println("尝试连接...");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
//            if(!conn.isClosed()) {
//            	System.out.println("Succeeded connecting to the Database!");
//            }
//            Statement statement = conn.createStatement();
//            
//            String sql = "select * from peiple";
//            
//            ResultSet rs = statement.executeQuery(sql);
//            
//            while(rs.next()) {
//            	
//            }
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
//	try {
//		Class.forName(driver);
//		Connection conn = DriverManager.getConnection(url, user, password);
//	}
}
