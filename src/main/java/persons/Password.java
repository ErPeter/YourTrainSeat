package persons;

import lombok.Setter;
import org.tinylog.Logger;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class to create safe passwords.
 */
public class Password {

    @Setter
    private String password;

    private String secretPassword = null;

    /**
     * Setter method.
     * This method hashes the password field with MD5 and sets the secretPassword to the hashed value
     */
    private void setSecretPassword() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            this.secretPassword =myHash;
        } catch (NoSuchAlgorithmException exception) {
            Logger.error("No such algorithm" + exception);
        }
    }

    /**
     * Simple getter method to get the secret password.
     * @return the secret password
     */
    public String getSecretPassword() {
        setSecretPassword();
        return secretPassword;
    }
}
