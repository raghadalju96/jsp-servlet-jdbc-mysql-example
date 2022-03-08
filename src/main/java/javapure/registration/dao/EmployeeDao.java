package javapure.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javapure.registration.model.Employee;

public class EmployeeDao {
	
	
    public int registerEmployee(Employee employee) throws ClassNotFoundException {

    String INSERT_USERS_SQL = "INSERT INTO employee" +
    "(id, first_name, last_name, username, password, address, contact) VALUES" +
    		"(?,?,?,?,?,?,?);";
    
    int result = 0;
    
   // com.mysql.cj.jdbc.Driver
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    try(Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?allowPublicKeyRetrieval=true&useSSL=false", "root", "lolo1818");
    
    		

    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
        System.out.println("Connected to MySQL database");

    	
    	preparedStatement.setInt(1, 3);
    	preparedStatement.setString(2, employee.getFirstName());
    	preparedStatement.setString(3, employee.getLastName());
    	preparedStatement.setString(4, employee.getUsername());
    	preparedStatement.setString(5, employee.getPassword());
    	preparedStatement.setString(6, employee.getAddress());
    	preparedStatement.setString(7, employee.getContact());
    	
    	
        System.out.println(preparedStatement);

        result = preparedStatement.executeUpdate();
   
    	
    }
    catch(SQLException e) {
    	printSQLException(e);
    }
    return result;
    	
    	
    	
    }
    
    private void printSQLException(SQLException ex) {
    	
    	for(Throwable e: ex) {
    		
    		if(e instanceof SQLException ) {
    			e.printStackTrace(System.err);
    			System.err.println("SQLState: "+ ((SQLException) e).getSQLState());
    			System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
    			System.err.println("Message: " + ((SQLException) e).getMessage());
    			
    			 Throwable t = ex.getCause();
                 while (t != null) {
                     System.out.println("Cause: " + t);
                     t = t.getCause();
                 }
    		
    			
    		}
    	}
    }
	

}