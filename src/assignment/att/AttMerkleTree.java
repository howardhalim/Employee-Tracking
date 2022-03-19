/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.att;

/**
 *
 * @author Steven-
 */
import assignment.loc.*;
import assignment.crypto.Hasher;
import assignment.function.AttendanceClass;
import java.util.ArrayList;
import java.util.List;

public class AttMerkleTree {
    private List<AttendanceClass> tranxLst;
    private String root = "0";

    public String getRoot() {
        return root;
    }

    /**
     * @implNote
     * Set the transaction list to the LocMerkleTree object.
     *
     * @param tranxLst
     */
    private AttMerkleTree(List<AttendanceClass> tranxLst) {
        super();
        this.tranxLst = tranxLst;
    }
    /**
     * Design pattern: Singleton
     */
    private static AttMerkleTree instance;
    public static AttMerkleTree getInstance(List<AttendanceClass> tranxLst ) {
        if( instance == null ) {
            return new AttMerkleTree(tranxLst);
        }
        return instance;
    }

    public void build() {

        List<String> tempLst = new ArrayList<>();

        for (AttendanceClass tranx : this.tranxLst) {
            tempLst.add(String.valueOf(tranx));
        }

        List<String> hashes = genTranxHashLst( tempLst );
        while(  hashes.size() != 1 ) {
            hashes = genTranxHashLst( hashes );
        }
        this.root = String.valueOf(hashes.get(0));
    }

    private List<String> genTranxHashLst(List<String> tranxLst) {
        List<String> hashLst = new ArrayList<>();
        int i = 0;
        while( i < tranxLst.size() ) {

            String left = String.valueOf(tranxLst.get(i));
            i++;

            String right = "";
            if( i != tranxLst.size() ) right = String.valueOf(tranxLst.get(i));

            String hash = Hasher.hash(left.concat(right), "SHA-256");
            hashLst.add(hash);
            i++;
        }
        return hashLst;
    }
}
