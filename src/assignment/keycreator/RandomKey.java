package assignment.keycreator;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class RandomKey {
	private static final String ALGORITHM = "AES";
	
	
	
	public static Key create() {
		
		try {
			KeyGenerator gen = KeyGenerator.getInstance(ALGORITHM);
			gen.init(128,new SecureRandom());
			return gen.generateKey();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
