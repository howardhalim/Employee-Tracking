package assignment.keycreator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class MyKeyPair {

	private KeyPairGenerator keygen;
	private KeyPair keyPair;
	
	
	public MyKeyPair () {
		try {
			keygen = KeyPairGenerator.getInstance("RSA");
			keygen.initialize(1024);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * create()
	 */
	public static void create() {
		MyKeyPair myKeyMaker = new MyKeyPair();
		//generate keypair
		myKeyMaker.keyPair = myKeyMaker.keygen.generateKeyPair();
		
		//get public key
		PublicKey pubKey = myKeyMaker.keyPair.getPublic();
		
		// get private key
		PrivateKey prvKey = myKeyMaker.keyPair.getPrivate();
		
		//view
//		System.out.println("Public key: "+Base64.getEncoder().encodeToString(pubKey.getEncoded()));
//		System.out.println("Private key: "+Base64.getEncoder().encodeToString(prvKey.getEncoded()));

		//put
		put(pubKey.getEncoded(),"KeyPair/PublicKey");
		put(prvKey.getEncoded(),"KeyPair/PrivateKey");
	}
	
	/*
	 * put()
	 */
	private static void put (byte[] keyBytes, String path) {
		File dir = new File(path);
		dir.getParentFile().mkdirs();
		try {
			Files.write(Paths.get(path), keyBytes, StandardOpenOption.CREATE);
			System.out.println("Done...");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
