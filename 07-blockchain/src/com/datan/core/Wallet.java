package com.datan.core;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.HashMap;
import java.util.Map;

import com.datan.test.TestChain;

public class Wallet {
	public PrivateKey privateKey;
	public PublicKey publicKey;
	
	public HashMap<String, TransactionOutput> UTXOs = new HashMap<String, TransactionOutput>();
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
	
	// returns balance and stores the UTXO's owned by this wallet in this OTXOs
	public float getBalance() {
		float total = 0;
		for( Map.Entry<String, TransactionOutput> item: TestChain.UTXOs.entrySet()) {
			
		}
		return total;
	}
	// generates and returns a new transaction from this wallet
	public Transaction sendFunds(PublicKey _receiver, float value) {
		
		
		
		
		Transaction newTransaction = new Transaction(publicKey, _receiver, value, inputs);
		return newTransaction;
	}
}
