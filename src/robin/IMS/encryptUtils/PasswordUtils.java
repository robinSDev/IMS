package robin.IMS.encryptUtils;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordUtils {

	private static final StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
	
	/**
	 * Encrypts (digests) a password. 
	 * 
	 * @param data - the password to be encrypted. 
	 * @return
	 */
	public static String encryptPassword(String data) {
		
		String result = passwordEncryptor.encryptPassword(data);

		return result;
	}
	
	/**
	 * Checks an un-encrypted (plain) password against an encrypted one (a digest) to see if they match. 
	 * 
	 * @param plainText
	 * @param encryptedPassword
	 * @return true if passwords match, false if not.
	 */
	public static boolean checkPassword(String plainText, String encryptedPassword) {
		
		return passwordEncryptor.checkPassword(plainText, encryptedPassword);
	}
	
}
