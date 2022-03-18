/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.crypto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven-
 */
public class Transaction implements Serializable {

    private final int SIZE = 10;

    /**
     * we will come back to implement merkleRoot function in following wks
     *
     * 	Now, default value given.
     */
    private String merkleRoot = "to-be-generated-then";

    /**
     * you may use array alternatively collection api
     */
    private List<String> dataLst;

    public Transaction() {
        dataLst = new ArrayList<>( SIZE );
    }

    /**
     * + add( String ) : void
     */
    public void add( String tranx ) {
        dataLst.add(tranx);
    }

    public void setMerkleRoot(){
        // MerkleTree mt = MerkleTree.getInstance(dataLst);
        // mt.build();

        // String rootHash = mt.getRoot();
        // merkleRoot = rootHash;
    }

    @Override
    public String toString() {
        return "Transaction [dataLst=" + dataLst + "]";
    }
}
