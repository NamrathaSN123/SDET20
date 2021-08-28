package jdbcProgrammes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteARowFromTableTest {

	public static void main(String[] args) throws Throwable  {
		Connection connection = null;
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
	        Statement statement = connection.createStatement();
	        int result = statement.executeUpdate("Delete from student_info where regno='5'");
	        if(result==1) {
	        	System.out.println("the data is deleted ");
	        }
	        else
	        	System.out.println("the data is not deleted");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			connection.close();
		}
		
		
		
		
		
		
	}

}
