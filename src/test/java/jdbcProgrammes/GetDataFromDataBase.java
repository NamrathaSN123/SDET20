package jdbcProgrammes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetDataFromDataBase {

	public static void main(String[] args) throws Throwable {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery("select * from student_info");
    while(result.next()) {
    	System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+ result.getString(3)+"\t"+ result.getString(4));
    }
    
    connection.close();
    
	}

}
