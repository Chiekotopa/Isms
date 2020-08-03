package org.agoncal.sample.jaxrs.jwt.util;

import java.security.MessageDigest;
import java.util.Base64;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

public class PasswordUtils {

	private static final String ALGO_CHIFFREMENT = "SHA-256";
    // ======================================
    // =          Business methods          =
    // ======================================

/*    public static String digestPassword(String plainTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainTextPassword.getBytes("UTF-8"));
            byte[] passwordDigest = md.digest();
            return new String(Base64.getEncoder().encode(passwordDigest));
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }*/
    
    public static String digestPassword(String plainTextPassword) {
        try {
    		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
    		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
    		passwordEncryptor.setPlainDigest(true);
    		
    		return passwordEncryptor.encryptPassword(plainTextPassword);
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }
    
	public String cryptedPassword(String toCrypt) {
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(true);
		
		return passwordEncryptor.encryptPassword(toCrypt);
		
	}
}