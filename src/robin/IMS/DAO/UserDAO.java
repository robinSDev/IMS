package robin.IMS.DAO;

import robin.IMS.core.User;
import robin.IMS.encryptUtils.PasswordUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Robin
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
    
    private User convertRowToUser(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String lastName = myRs.getString("last_name");
		String firstName = myRs.getString("first_name");
		String email = myRs.getString("email");
                System.out.println(lastName);
		boolean admin = myRs.getBoolean("is_admin");
		User tempUser = new User(id, lastName, firstName, email, admin);
		
		return tempUser;
	}
	
	public List<User> getUsers(boolean admin, int userId) throws Exception {
		List<User> list = new ArrayList<User>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			
			String sql = null;
			
			if (admin) {
				// get all users
				sql = "select * from users order by last_name";
			}
			else {
				// only the current user
				sql = "select * from users where id=" + userId + " order by last_name";
			}
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				User tempUser = convertRowToUser(myRs);
				list.add(tempUser);
                                
			}

			return list;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}	
	
	public void addUser(User theUser) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into users"
					+ " (first_name, last_name, email, is_admin, password)"
					+ " values (?, ?, ?, ?, ?)");
			
			// set params
			myStmt.setString(1, theUser.getFirstName());
			myStmt.setString(2, theUser.getLastName());
			myStmt.setString(3, theUser.getEmail());
			myStmt.setBoolean(4, theUser.isAdmin());
			
			// encrypt password
			String encryptedPassword = PasswordUtils.encryptPassword(theUser.getPassword());
			myStmt.setString(5, encryptedPassword);
			
			// execute SQL
			myStmt.executeUpdate();				
		}
		finally {
			DAOUtils.close(myStmt);
		}
		
	}
		
	
	public void updateUser(User theUser) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update users"
					+ " set first_name=?, last_name=?, email=?, is_admin=?"
					+ " where id=?");
			
			// set params
			myStmt.setString(1, theUser.getFirstName());
			myStmt.setString(2, theUser.getLastName());
			myStmt.setString(3, theUser.getEmail());
			myStmt.setBoolean(4, theUser.isAdmin());
			myStmt.setInt(5, theUser.getId());
			
			// execute SQL
			myStmt.executeUpdate();

		}
		finally {
			DAOUtils.close(myStmt);
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
               PreparedStatement pst = myConn.prepareStatement("Select * from users where first_name=? and password=?");
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

	private String getEncrpytedPassword(int id) throws Exception {
		String encryptedPassword = null;
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select password from users where id=" + id);
			
			if (myRs.next()) {
				encryptedPassword = myRs.getString("password");
			}
			else {
				throw new Exception("User id not found: " + id);
			}

			return encryptedPassword;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}		
	}

	public void changePassword(User user) throws Exception {

		// get plain text password
		String plainTextPassword = user.getPassword();
		
		// encrypt the password
		String encryptedPassword = PasswordUtils.encryptPassword(plainTextPassword);
		
		// update the password in the database
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update users"
					+ " set password=?"
					+ " where id=?");
			
			// set params
			myStmt.setString(1, encryptedPassword);
			myStmt.setInt(2, user.getId());
			
			// execute SQL
			myStmt.executeUpdate();

		}
		finally {
			DAOUtils.close(myStmt);
		}		

	}	
}   
