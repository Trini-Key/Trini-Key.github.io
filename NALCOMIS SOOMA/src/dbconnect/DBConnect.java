package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sooma", "root", "");
			st = con.createStatement();

		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}

	public void getUserData() {
		try {
			String query = "select * from users";
			rs = st.executeQuery(query);
			System.out.println("Records from Database");

			while (rs.next()) {
				String name = rs.getString("name");
				String age = rs.getString("age");
				System.out.println("Name: " + name + " Age: " + age);
			}
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	public boolean getUserName(String uName) {
		try {
			String query = "select username from users where username = " + "\'" + uName + "\'";
			rs = st	.executeQuery(query);
			if(uName.equals(rs)) {
				System.out.println("this works!");
			}
			return true;
		}catch(Exception e) {
			System.out.print("Error username not recognized: " + e);
			return false;
		}		
	}
	
	public boolean getUserPword(String pWord) {
		try {
			String query = "select username from users where username = " + "\'" + pWord + "\'";
			rs = st	.executeQuery(query);
			if(pWord.equals(rs)) {
				System.out.println("this works!");
			}
			return true;
		}catch(Exception e) {
			System.out.print("Error inccorect password try again: " + e);
			return false;
		}		
	}
}