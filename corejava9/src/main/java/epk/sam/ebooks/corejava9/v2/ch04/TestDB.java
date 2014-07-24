package epk.sam.ebooks.corejava9.v2.ch04;

//import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * This program tests that the database and the JDBC driver are correctly
 * configured.
 * 
 * @version 1.02 2012-06-05
 * @author Cay Horstmann
 */
public class TestDB {
	public static void main(String args[]) throws IOException {
		try {
			runTest();
		} catch (SQLException ex) {
			for (Throwable t : ex)
				t.printStackTrace();
		}
	}

	/**
	 * Runs a test by creating a table, adding a value, showing the table
	 * contents, and removing the table.
	 */
	public static void runTest() throws SQLException, IOException {

		try (Connection conn = getConnection()) {
			Statement stat = conn.createStatement();

			stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
			stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello, World!')");
			stat.executeUpdate("INSERT INTO Greetings VALUES ('Вот ещё запись!')");
			stat.executeUpdate("INSERT INTO Greetings VALUES ('Заполняем табличку!')");

			try (ResultSet result = stat.executeQuery("SELECT * FROM Greetings")) {
				while (result.next())
					System.out.println(result.getString(1));
			}
			stat.executeUpdate("DROP TABLE Greetings");
		}
	}

	/**
	 * Gets a connection from the properties specified in the file
	 * database.properties.
	 * 
	 * @return the database connection
	 */
	public static Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		//не находит файл при отладке в eclipse
//		try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
		try (InputStream in = loader.getResourceAsStream("database.properties"))
		{
			props.load(in);
		}
		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		return DriverManager.getConnection(url, username, password);
	}
}
