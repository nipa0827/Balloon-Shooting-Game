package game;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Score_Database {

	final private String dbName = "score.db";
	final private String url = "jdbc:sqlite:db_file/" + dbName;
	final private String level_1_score = "level_1";
	final private String level_2_score = "level_2";
	final private String level_3_score = "level_3";

	private Connection connect() {
		// SQLite connection string

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void createNewDatabase() {

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out
						.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void create_New_Table_For_Level_1() {
		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + level_1_score + " (\n"
				+ "	id integer PRIMARY KEY,\n" + "	score integer\n" + ");";

		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert_level_1_score(int score) {
		String sql = "INSERT INTO " + level_1_score + " (score) VALUES(?)";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, score);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int get_Level_1_score() {
		String sql = "SELECT id, score FROM " + level_1_score + "";
		
		int score=0,count=0;

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				count++;
				if(count==2){
					score = rs.getInt("score");
					break;
				}
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return score;
	}
	
	public void update_level_1_score(int id, int score) {
		String sql = "UPDATE " + level_1_score + " SET score = ? " + "WHERE id = ?";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setInt(1, score);
			pstmt.setInt(2, id);
			// update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void create_New_Table_For_Level_2() {
		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + level_2_score + " (\n"
				+ "	id integer PRIMARY KEY,\n" + "	score integer\n" + ");";

		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert_level_2_score(int score) {
		String sql = "INSERT INTO " + level_2_score + " (score) VALUES(?)";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, score);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int get_Level_2_score() {
		String sql = "SELECT id, score FROM " + level_2_score + "";
		
		int score=0,count=0;

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				count++;
				if(count==1){
					score = rs.getInt("score");
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return score;
	}
	
	public void update_level_2_score(int id, int score) {
		String sql = "UPDATE " + level_2_score + " SET score = ? " + "WHERE id = ?";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setInt(1, score);
			pstmt.setInt(2, id);
			// update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void create_New_Table_For_Level_3() {
		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + level_3_score + " (\n"
				+ "	id integer PRIMARY KEY,\n" + "	score integer\n" + ");";

		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert_level_3_score(int score) {
		String sql = "INSERT INTO " + level_3_score + " (score) VALUES(?)";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, score);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int get_Level_3_score() {
		String sql = "SELECT id, score FROM " + level_3_score + "";
		
		int score=0,count=0;

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				count++;
				if(count==1){
					score = rs.getInt("score");
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return score;
	}
	
	public void update_level_3_score(int id, int score) {
		String sql = "UPDATE " + level_3_score + " SET score = ? " + "WHERE id = ?";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			
			pstmt.setInt(1, score);
			pstmt.setInt(2, id);
			
			// update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	
}