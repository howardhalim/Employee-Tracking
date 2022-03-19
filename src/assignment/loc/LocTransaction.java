/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.loc;

/**
 *
 * @author Steven-
 */
import assignment.main.LocationObj;
import java.io.Serializable;
import java.util.ArrayList;

public class LocTransaction implements Serializable {

    private final int SIZE = 10;

    private String merkleRoot;

    private ArrayList<LocationObj> dataLst;

    public LocTransaction() {
        dataLst = new ArrayList<>( SIZE );
    }


    public void add( LocationObj tranx ) {
        dataLst.add(tranx);
    }

    public void setMerkleRoot(){
        LocMerkleTree mt = LocMerkleTree.getInstance(dataLst);
        mt.build();

        String rootHash = mt.getRoot();
        merkleRoot = rootHash;
    }

    @Override
    public String toString() {
        return "LocTransaction [dataLst=" + dataLst + "]";
    }
}
