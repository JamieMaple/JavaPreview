package entry;

import java.sql.*;

class Main {
	static final String USER = "root";
	static final String PASS = "root";
	static final String DB_URL = "jdbc:mysql://localhost/test";
	public static void main(String[] args) {
		Connection conn;
		Statement statement;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = conn.createStatement();
			String sql = "SELECT id, first, last, age from Employees";
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");
				
				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", First: " + first);
				System.out.println(", Last: " + last);
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException error) {
			error.printStackTrace();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
}

