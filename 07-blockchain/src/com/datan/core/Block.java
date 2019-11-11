package com.datan.core;

import java.util.Date;

import com.datan.util.StringUtil;

public class Block {
	
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	
	//Block Constructor.
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	private String calculateHash() {
		String calculatedhash = StringUtil.applySha256(
				this.previousHash +
				Long.toString(this.timeStamp) +
				this.data
				);
		return calculatedhash;
	}
}




