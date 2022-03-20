package assignment.crypto;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;

public class Symmetric extends Crypto {

	public Symmetric(String algorithm) {
		super(algorithm);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String encrypt(String data, Key key) throws Exception{
		String cipherTxt = null;
		//init
		cipher.init(Cipher.ENCRYPT_MODE, key);
		//encrypt
		byte[] cipherBytes = cipher.doFinal(data.getBytes());
		//convert byte[] to String
		cipherTxt = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherTxt;
	}
	@Override
	public String decrypt(String cipherTxt, Key key) throws Exception{
		//init
		cipher.init(Cipher.DECRYPT_MODE, key);
		//convert String to byte[]
		byte[] cipherBytes = Base64.getDecoder().decode(cipherTxt);
		//decrypt
		byte[] dataBytes = cipher.doFinal(cipherBytes);
		return new String(dataBytes);
	}

}
