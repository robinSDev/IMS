
/**
 * @author Robin Singh Devgan
 * Intern, Summer 2017
 */

package robin.IMS.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

//import com.robin.jdbc.employeesearch.core.AuditHistory;

public class ComputersDAO {
    
private Connection myConn;
	
	public ComputersDAO() throws Exception {
        Properties props = new Properties();
    	InputStream input = null;
        try {
            
            String filename;
            filename = "robin/IMS/DAO/db.properties";
    		input = getClass().getClassLoader().getResourceAsStream(filename);
		if (input == null) {
			System.out.println("Sorry, unable to find " + filename);
			return;
		}

            props.load(input);
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String dburl = props.getProperty("dburl");
            
             // connect to database
            myConn = DriverManager.getConnection(dburl, user, password);
		
            System.out.println("Employee DAO - DB connection successful to: " + dburl);
            
        } catch (FileNotFoundException ex) {    //try-catch blocks added on recommendation by this IDE
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        	
        
        }
	
	//List<Computers>, list-of-employee, where Computers is a simple class file in Computers.java
	public ResultSet getAllComputerss() throws Exception {
		Statement myStmt = null;	//create SQL statement
		ResultSet myRs = null;//A ResultSet object maintains a cursor pointing to its current row of data
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from computers order by id");
			
			return myRs;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}

}
