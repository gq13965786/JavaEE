package com.datan.core;

import java.security.*;
import java.util.ArrayList;

import com.datan.test.TestChain;
import com.datan.util.StringUtil;

public class Transaction {
	
	public String transactionId;
	public PublicKey sender;
	public PublicKey receiver;
	public float value;
	public byte[] signature;
	
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	
	private static int sequence = 0;
	
	// Constructor:
	public Transaction(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.receiver = to;
		this.value = value;
		this.inputs = inputs;
	}
	// this calculates the transaction hash (which will be used as its id) 
	private String calculateHash() {
		sequence++;
		return StringUtil.applySha256(
				StringUtil.getStringFromKey(sender) +
				StringUtil.getStringFromKey(receiver) +
				Float.toString(value) + sequence
				);
	}
	// signs all the data we dont wish to be tampered with
	public void generateSignature(PrivateKey privateKey) {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(receiver) + Float.toString(value);
		signature = StringUtil.applyECDSASig(privateKey, data);
	}
	// verifies the data we signed hasnt been tampered with
	public boolean verifySignature() {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(receiver) + Float.toString(value);
		return StringUtil.verifyECDSASig(sender, data, signature);
	}
	// Returns true if new transaction could be created
	public boolean processTransaction() {
		
		if (verifySignature() == false) {
			System.out.println("#Transaction Signature failed to verify");
			return false;
		}
		
		// gather transaction inputs (Make sure they are unspent):
		for (TransactionInput i : inputs) {
			i.UTXO = TestChain.UTXOs.get(i.transactionOutputId);
		}
		// check if transaction is valid:
		if (getInputsValue() < TestChain.minimumTransaction) {
			System.out.println("#Transaction Inputs to small" + getInputsValue());
			return false;
		}
		//generate transaction outputs:
		float leftOver = getInputsValue() - value;
		transactionId = calculateHash();
		outputs.add(new TransactionOutput( this.receiver, value, transactionId));
		outputs.add(new TransactionOutput( this.sender, leftOver, transactionId));
		
		//add outputs to Unspent list
		for( TransactionOutput o : outputs) {
			TestChain.UTXOs.put(o.id, o);
		}
		
		//remove transaction inputs from UTXO lists as spent
		for( TransactionInput i : inputs) {
			if(i.UTXO == null) continue;
			TestChain.UTXOs.remove(i.UTXO.id);
		}
		
		return true;
	}
	// returns sum of inputs(UTXOs) values
	public float getInputsValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	// returns sum of outputs:
	public float getOutputsValue() {
		
		return 0;
	}
	
}
