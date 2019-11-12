package com.datan.core;

import java.security.PublicKey;

import com.datan.util.StringUtil;

public class TransactionOutput {
	public String id;
	public PublicKey receiver;
	public float value;
	public String parentTransactionId;
	
	// Constructor
	public TransactionOutput(PublicKey receiver, float value, String parentTransactionId) {
		this.receiver = receiver;
		this.value = value;
		this.parentTransactionId = parentTransactionId;
		this.id = StringUtil.applySha256(StringUtil.getStringFromKey(receiver) + Float.toString(value) + parentTransactionId);
	}
	
	// Check if coin belongs to you
	public boolean isMine(PublicKey publicKey) {
		return (publicKey == receiver);
	}
	
}
