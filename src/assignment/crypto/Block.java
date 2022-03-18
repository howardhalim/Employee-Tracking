/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.crypto;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;

public class Block implements Serializable{
    private Header header;
    private Transaction tranx;

    public Block(String previousHash, int index){
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

    public Transaction getTransaction() {
        return tranx;
    }

    //setter
    public void setTransaction(Transaction tranx) {
        this.tranx = tranx;
    }

    @Override
    public String toString() {
        return "Block{" +
                "header=" + header +
                ", tranx=" + tranx +
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
