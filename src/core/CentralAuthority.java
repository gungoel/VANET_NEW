package core;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class CentralAuthority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CentralAuthority c=new CentralAuthority();
		//KeyPair k=c.generateKeyPair();
		//	System.out.println("Private key "+k.getPrivate());
		//System.out.println("Public Key "+k.getPublic());

	}
	public KeyPair generateKeys() throws Exception
	{
		KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
		keygen.initialize(512);
		KeyPair keyPair = keygen.generateKeyPair();
		return keyPair;
	}

	/*public KeyPair generateKeyPair()
	{
		KeyPair keys=null;
		try {
			KeyPairGenerator k=KeyPairGenerator.getInstance("RSA");
			k.initialize(2048);
			keys = k.generateKeyPair();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keys;
		KeyPairGenerator keyPairGenerator;
		KeyPair keyPair=null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048); //1024 used for normal securities
			 keyPair = keyPairGenerator.generateKeyPair();
			//PublicKey publicKey = keyPair.getPublic();
			//PrivateKey privateKey = keyPair.getPrivate();
			System.out.println("Public Key - " + keyPair.getPublic());
			System.out.println("Private Key - " + keyPair.getPrivate());



			//Pullingout parameters which makes up Key
			System.out.println("\n------- PULLING OUT PARAMETERS WHICH MAKES KEYPAIR----------\n");
			KeyFactory keyFactory;

			keyFactory = KeyFactory.getInstance("RSA");

			RSAPublicKeySpec rsaPubKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
			RSAPrivateKeySpec rsaPrivKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Cipher cipher = Cipher.getInstance("RSA");
		catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

return keyPair;
	}*/

}
