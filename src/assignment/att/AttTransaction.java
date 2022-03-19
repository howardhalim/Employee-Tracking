/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.att;

/**
 *
 * @author Steven-
 */
import assignment.function.AttendanceClass;
import assignment.loc.*;
import java.io.Serializable;
import java.util.ArrayList;

public class AttTransaction implements Serializable {

    private String merkleRoot;

    private ArrayList<AttendanceClass> dataLst;

    public AttTransaction() {
        dataLst = new ArrayList<>( );
    }

    public ArrayList<AttendanceClass> getDataLst() {
        return dataLst;
    }

    public void add( AttendanceClass tranx ) {
        dataLst.add(tranx);
    }

    public void setMerkleRoot(){
        AttMerkleTree mt = AttMerkleTree.getInstance(dataLst);
        mt.build();

        String rootHash = mt.getRoot();
        merkleRoot = rootHash;
    }

    @Override
    public String toString() {
        return "AttTransaction [dataLst=" + dataLst + "]";
    }
}
