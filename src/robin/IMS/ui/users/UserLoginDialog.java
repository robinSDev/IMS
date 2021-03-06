
/**
 * @author Robin Singh Devgan
 * Intern, Summer 2017
 */

package robin.IMS.ui.users;

import java.awt.event.KeyEvent;
import robin.IMS.DAO.UserDAO;
import javax.swing.JOptionPane;
import robin.IMS.IMS_App.IMS_APP;
import robin.IMS.items.AddUser;


/**
 *
 * @author Robin Singh Devgan
 */
public class UserLoginDialog extends javax.swing.JDialog {
    
    public UserLoginDialog(){
    java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                initComponents();
               addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                setVisible(true);
            }
        });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ID_Label = new javax.swing.JLabel();
        password_Label = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        Login = new javax.swing.JButton();
        loginField = new javax.swing.JTextField();
        addUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome to IMS, Please Login!");

        ID_Label.setText("User Name");

        password_Label.setText("Password");

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        addUser.setText("Add New User");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_Label)
                            .addComponent(ID_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(loginField)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(Login)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_Label)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password_Label)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login)
                    .addComponent(addUser))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        Login();
    }//GEN-LAST:event_LoginActionPerformed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            Login();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        // TODO add your handling code here:
        AddUser a = new AddUser();
    }//GEN-LAST:event_addUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID_Label;
    private javax.swing.JButton Login;
    private javax.swing.JButton addUser;
    private javax.swing.JTextField loginField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel password_Label;
    // End of variables declaration//GEN-END:variables

    private void Login() {
        try {
		String loginID = loginField.getText();
		// get the password
		String pswd = new String(passwordField.getPassword());
                System.out.println(loginID);
		
		// check the user's password against the encrypted version in the database
		boolean isValidPassword;
                UserDAO us = new UserDAO();
                isValidPassword = us.validate_login(loginID, pswd);
                System.out.println(isValidPassword);

		if (isValidPassword) {
			// hide the login window
			setVisible(false);
                        IMS_APP frame = new IMS_APP();
			frame.setVisible(true);
			}
		else {
			// show error message
                        JOptionPane.showMessageDialog(this, "Invalid login", "Invalid Login",
					JOptionPane.ERROR_MESSAGE);
		}
		}
		catch (Exception exc) {
		JOptionPane.showMessageDialog(this, "Error during login", "Error",
				JOptionPane.ERROR_MESSAGE);			
		}
    }
    
}
