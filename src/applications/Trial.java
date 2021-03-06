package applications;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;

public class Trial {
  public static void main(String[] args) throws Exception {

    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

    keyGen.initialize(512, new SecureRandom());

    KeyPair keyPair = keyGen.generateKeyPair();
    Signature signature = Signature.getInstance("SHA1withRSA");

    signature.initSign(keyPair.getPrivate(), new SecureRandom());

    byte[] message = "abc".getBytes();
    signature.update(message);

    byte[] sigBytes = signature.sign();
    signature.initVerify(keyPair.getPublic());
    signature.update(message);
    System.out.println(signature.verify(sigBytes));
  }
}