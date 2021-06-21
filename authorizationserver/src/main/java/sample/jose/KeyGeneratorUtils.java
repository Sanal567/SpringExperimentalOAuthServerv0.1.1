package sample.jose;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyGeneratorUtils {

    private KeyGeneratorUtils() {

    }

    static SecretKey generateSecretKey() {
        SecretKey hmacKey = null;

        try {
            hmacKey = KeyGenerator.getInstance("HmacSha256").generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hmacKey;
    }

    static KeyPair generateRsaKey() {
        KeyPair keyPair = null;

        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return keyPair;
    }
}
