package com.datan.core;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
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
			TransactionOutput UTXO = item.getValue();
			if( UTXO.isMine(publicKey)) {
				UTXOs.put(UTXO.id,UTXO);
				total += UTXO.value;
			}
		}
		return total;
	}
	// generates and returns a new transaction from this wallet
	public Transaction sendFunds(PublicKey _receiver, float value) {
		if(getBalance() < value) {// get balance and check funds
			System.out.println("#Not Enough funds to send transaction. Transaction Discarded");
			return null;			
		}
		// create array list of inputs
		ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
		
		float total = 0;
		for(Map.Entry<String, TransactionOutput> item: UTXOs.entrySet()) {
			TransactionOutput UTXO = item.getValue();
			total += UTXO.value;
			inputs.add(new TransactionInput(UTXO.id));
			if( total > value) break;
		}
		Transaction newTransaction = new Transaction(publicKey, _receiver, value, inputs);
		newTransaction.generateSignature(privateKey);
		
		for(TransactionInput input: inputs) {
			UTXOs.remove(input.transactionOutputId);
		}
		return newTransaction;
	}
}
