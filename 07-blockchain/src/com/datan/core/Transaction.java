package com.datan.core;

import java.security.*;
import java.util.ArrayList;
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
}
