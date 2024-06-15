package db_example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		DBUtils dbUtils = new DBUtils();
		
		try {
			@SuppressWarnings("static-access")
			Connection connection = dbUtils.getConnection();
			java.sql.Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "";
			@SuppressWarnings("unused")
			ResultSet resultSet = statement.executeQuery(sql);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
