package com.company;

import java.util.Date;

public class Block {
    // Instant Field
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    // Constructor
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    // Method
    public String calculateHash(){
        String str = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data;
        String hashNr = StringUtil.applySha256(str);
        return hashNr;
    }

    public void mineBlock(int difficulty){
        // Initiate target to only zeros (instead of null) String of length difficulty.
        String target = new String(new char[difficulty]).replace('\0', '0');

        // Calculates hash until the first 0->difficulty starting numbers are equals to zero.
        while(!this.hash.substring(0, difficulty).equals(target)){
            this.nonce++;
            this.hash = calculateHash();
        }
        System.out.println("Block Mined!! : " + this.hash);
    }

}
