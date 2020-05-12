package yourtrainseat;

/**
 * Class to create safe passwords
 */

import lombok.Getter;
import org.tinylog.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class Password {

    private String password;

    @Getter
    private String secretPassword = null;

    public Password(String password) {
        this.password = password;
    }

    /**
     * Returns a salt for a hashing algorithm
     *
     * @return a salt
     */
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    /**
     * Creating hashed password from password
     */
    private void setSecretPassword() throws NoSuchAlgorithmException {
        byte[] salt = getSalt();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("-1");
            messageDigest.update(salt);
            byte[] bytes = messageDigest.digest(this.password.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            this.secretPassword = stringBuilder.toString();
        } catch (NoSuchAlgorithmException exception) {
            Logger.error("No such algorithm" + exception);
        }
    }
}
