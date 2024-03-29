package com.datan.core;

import java.util.ArrayList;
import java.util.Date;

import com.datan.util.StringUtil;

// simply refer to info from blockexplorer.com
public class Block {
	
	public String hash;
	public String previousHash;
	public String merkleRoot;
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	public long timeStamp;
	public int nonce;
	
	//Block Constructor.
	public Block(String previousHash) {
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256(
				this.previousHash +
				Long.toString(this.timeStamp) +
				Integer.toString(nonce) +
				merkleRoot
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		merkleRoot = StringUtil.getMerkleRoot(transactions);
		String target = StringUtil.getDifficultyString(difficulty); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	// add transactions to this block
	public boolean addTransaction(Transaction transaction) {
		//process transaction and check if valid, unless block is genesis block then ignore.
		if( transaction == null) return false;
		if((previousHash != "0")) {
			if((transaction.processTransaction() != true)) {
				System.out.println("Transaction failed to process. Discarded.");
				return false;
			}
		}
		transactions.add(transaction);
		System.out.println("Transaction Successfully added to Block");
		return true;
	}
}




