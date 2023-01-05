package src.main.test.java;

import chaturbateteam.userid_rest_api.Classes.MD5;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import static org.junit.Assert.assertEquals;

public class MD5Test {

    @Test
    public void givenPassword_whenHashing_thenVerifying() throws NoSuchAlgorithmException{
        String hash = "91F4FEB16E220A0A5A500B8344865BBF";
        String password = "IloveJava";
        System.out.println(MD5.Translate_to_MD5_HASH(password));
        assertEquals(MD5.Translate_to_MD5_HASH(password),hash);
    }
}
