package assignment.crypto;

import java.security.Key;

import javax.crypto.Cipher;

public abstract class Crypto {
	
	protected Cipher cipher;
	public Crypto(String algorithm) {
		try {
			cipher = Cipher.getInstance(algorithm);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public abstract String encrypt(String data, Key key) throws Exception;
	public abstract String decrypt(String cipherTxt, Key key) throws Exception;
	
}
