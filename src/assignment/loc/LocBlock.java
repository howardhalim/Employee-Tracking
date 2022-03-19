/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.loc;

import assignment.crypto.Hasher;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Steven-
 */
public class LocBlock implements Serializable{
    private Header header;
    private LocTransaction transaction;

    public LocBlock(String previousHash, int index){
        header = new Header();
        header.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
        header.setPreviousHash(previousHash);
        byte[] blockByte = this.getBytes();
        String blockHash = Hasher.hash(blockByte, "SHA-256");
        header.setCurrentHash(blockHash);
        header.setIndex(index);
    }


    private byte[] getBytes(){
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(baos);)
        {
            out.writeObject(this);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //getter
    public Header getHeader() {
        return header;
    }

    public LocTransaction getTransaction() {
        return transaction;
    }

    //setter
    public void setTransaction(LocTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "LocBlock{" +
                "header=" + header +
                ", transaction=" + transaction +
                '}';
    }

    // composition relationship
    public class Header implements Serializable {
        private int index;
        private String currentHash, previousHash;
        private long timestamp;

        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }

        public String getCurrentHash() {
            return currentHash;
        }
        public void setCurrentHash(String currentHash) {
            this.currentHash = currentHash;
        }

        public String getPreviousHash() {
            return previousHash;
        }
        public void setPreviousHash(String previousHash) {
            this.previousHash = previousHash;
        }

        public long getTimestamp() {
            return timestamp;
        }
        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return "Header{" +
                    "index=" + index +
                    ", currentHash='" + currentHash + '\'' +
                    ", previousHash='" + previousHash + '\'' +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }
}
