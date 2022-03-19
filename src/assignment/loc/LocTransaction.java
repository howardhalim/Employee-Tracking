/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.loc;

/**
 *
 * @author Steven-
 */

import assignment.function.LocationClass;
import java.io.Serializable;
import java.util.ArrayList;

public class LocTransaction implements Serializable {

    private String merkleRoot;

    private ArrayList<LocationClass> dataLst;

    public LocTransaction() {
        dataLst = new ArrayList<>( );
    }

    public ArrayList<LocationClass> getDataLst() {
        return dataLst;
    }


    public void add( LocationClass tranx ) {
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
