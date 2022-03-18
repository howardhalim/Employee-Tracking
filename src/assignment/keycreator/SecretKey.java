package assignment.keycreator;

import java.security.Key;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

public class SecretKey {
	private static final String ALGORITHM = "AES";
	
	private final static String SECRET_CHARS = "thisis@symmetr!ccrypt0system";
	
	public static Key create() {
		
		return new SecretKeySpec( Arrays.copyOf(SECRET_CHARS.getBytes(), 16), ALGORITHM);
	}
}
