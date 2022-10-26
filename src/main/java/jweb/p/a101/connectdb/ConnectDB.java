package jweb.p.a101.connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	public static Connection getConnection() {
		
		String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=JWEB.P.A101;";
		String USER_NAME = "sa";
		String PASSWORD = "dangnam";
		Connection conn = null;
		try {
			
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				System.out.println("Kết nối thành công!");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		catch( SQLException e)
		{
			System.out.println(e);
		}
			return conn;
		}

	public static void CloseConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getConnection();
	}
}
