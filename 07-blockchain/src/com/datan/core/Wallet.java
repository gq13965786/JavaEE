package com.datan.core;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
	public PrivateKey privateKey;
	public PublicKey publicKey;
	
	//constructor
	public Wallet() {
		generateKeyPair();
	}

	public void generateKeyPair() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			// initialize the key generator and generate a keypair
			keyGen.initialize(ecSpec, random);
			KeyPair keyPair = keyGen.generateKeyPair();
			// set the public and private keys from the keyPair
			this.privateKey = keyPair.getPrivate();
			this.publicKey = keyPair.getPublic();			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
