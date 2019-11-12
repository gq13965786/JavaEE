package com.datan.core;

import java.security.*;
import java.util.ArrayList;

public class Transaction {
	
	public String transactionId;
	public PublicKey sender;
	public PublicKey receiver;
	public float value;
	public byte[] signature;
	
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
}
