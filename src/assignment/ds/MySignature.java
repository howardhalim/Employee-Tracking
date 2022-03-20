package assignment.ds;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class MySignature {

	private Signature signr;
	private KeyPairGenerator keygen;
	private KeyPair keyPair;
	{
		try {
			keygen = KeyPairGenerator.getInstance("RSA");
			keyPair = keygen.generateKeyPair();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MySignature() {
		super();
		try {
			signr = Signature.getInstance("SHA256WithRSA");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public PublicKey getPublicKey(){
            return keyPair.getPublic();
        }
	/*
	 * sign()
	 */
	public String sign(String data) throws Exception{
		signr.initSign(keyPair.getPrivate());
		signr.update(data.getBytes());
		return Base64.getEncoder().encodeToString(signr.sign());
	}
        /*
         * verify()
         */
        public boolean verify(String data, String signature, PublicKey pub) throws Exception{
		signr.initVerify(pub);
		signr.update(data.getBytes());
		return signr.verify(Base64.getDecoder().decode(signature));
	}
}
