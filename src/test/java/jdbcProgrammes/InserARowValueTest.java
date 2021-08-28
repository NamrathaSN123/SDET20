package jdbcProgrammes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InserARowValueTest {

	public static void main(String[] args) throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement statement = connection.createStatement();
		 int result = statement.executeUpdate("insert into student_info values('5','adi','setty','h')");
		if(result==1) {
			System.out.println("the data is added into database");
		}
		else
			System.out.println("the data is not added into database");
		connection.close();

	}

}
