package java_0623_3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DbConn {
	
 private static Connection dbConn;
 
 public static Connection getConnection() {
	 if(dbConn == null) {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pwd = "tiger";
			//oracle jdbc 드라이버를 로드합니다. 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbConn = DriverManager.getConnection(url, user, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	 }
	 return dbConn; //dbconn 객체가 반환되어 사용자에게 데이터베이스 연결을 제공
 }//getConnection()
 	public static Connection getConnection(String url, String user, String pwd) {
 		if(dbConn != null) {
 			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url, user, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
 		}
 		return dbConn;
 	}
 	public static void dbClose() {
 		if(dbConn != null) {
 			try {
				if(dbConn.isClosed()) dbConn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
 		}
 		dbConn = null;
 	}
 	public static void dbClose(PreparedStatement ps, Connection conn) {
 		try {
			if(conn != null) conn.close();
			if(ps != null) ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
 		conn = null; ps = null;
 	}
 	public static void dbClose(ResultSet rs, Statement st, Connection conn) {
 		try {
			if(st != null)  st.close();
			if(conn != null) conn.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
 		conn = null; st = null; rs = null;
 	}
 	public static void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) {
 		try {
			if(rs != null) rs.close();
			if(conn != null) conn.close();
			if(ps != null) ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
 		rs = null; conn = null; ps= null;
 	}
}
