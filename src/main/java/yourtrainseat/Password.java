package yourtrainseat;

/**
 * Class to create safe passwords
 */

import lombok.Setter;
import org.tinylog.Logger;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Password {

    @Setter
    private String password;

    private String secretPassword = null;

    public Password() {
    }


    /**
     * Creating hashed password from password
     */
    private void setSecretPassword() throws NoSuchAlgorithmException {
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

    public String getSecretPassword() throws NoSuchAlgorithmException {
        setSecretPassword();
        return secretPassword;
    }
}
