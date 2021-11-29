package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConexion {
	
	private static final String HOST = "localhost";
	private static final String DB = "sisco_ms";
    private static final String USER = "root";
    private static final String PASSWORD = "N4rv4ez/";
	private static final String URL = "jdbc:mysql://"+HOST+":3306/"+DB+"?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

	public Connection  conectar() {
		
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(URL, USER, PASSWORD);
			
		}catch(Exception e) {
			System.out.print("Se produjo el error "+e);
		}
		
		return con;
	}
	
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
	

}
