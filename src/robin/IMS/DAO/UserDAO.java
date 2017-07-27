
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Robin Singh Devgan
 * Intern, Summer 2017
 */


public class UserDAO {
    
    private Connection myConn;
    
    /**
     *A data access object to be used by this software for accessing 'User' schema in the database
     * @throws Exception
     */
    public UserDAO() throws Exception {
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

	/**
	 * Return true if user's password is authenticated.
	 * 
     * @param username
     * @param password
	 * @return
	 */
	public boolean validate_login(String username, String password) {
            System.out.println("Here0!");
            try{
                System.out.println("Here1!");
               PreparedStatement pst = myConn.prepareStatement("Select * from users where userName=? and password=?");
               pst.setString(1, username); 
               pst.setString(2, password);
               ResultSet rs = pst.executeQuery();
               System.out.println("Here!");
               return rs.next();            
           }
           catch(Exception e){
               e.printStackTrace();
               return false;
           }       
    }	
}   
