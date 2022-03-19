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
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

public class AttBlockchain {

    //master-binary-file
    public static final String CHAIN_FILE = "master/attendance.bin";
    //data-structure
    private static LinkedList<AttBlock> DB = new LinkedList<>();
    //ledger-file
    private static final String LEDGER_FILE = "attendance.txt";

    public static void genesis() {
        AttBlock genesis = new AttBlock("0", 0);
        DB.add(genesis);
        AttBlockchain.persist();
        AttBlockchain.distribute();
    }

    public static void nextBlock(AttBlock newBlock) {
        DB = get();
        DB.add(newBlock);
        AttBlockchain.persist();
    }

    // read the chain from master-file
    public static LinkedList<AttBlock> get() {
        try(
            FileInputStream fin = new FileInputStream( CHAIN_FILE );
            ObjectInputStream in = new ObjectInputStream( fin );
        ) {
            return (LinkedList<AttBlock>)in.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    // write the chain to master-file
    public static void persist() {
        try(
                FileOutputStream fout = new FileOutputStream( CHAIN_FILE );
                ObjectOutputStream out = new ObjectOutputStream( fout );
        ) {
            out.writeObject( DB );
            System.out.println( ">> Master file updated!" );
        } catch (Exception e) {
        }
    }

    // print/export the chain to ledger-file
    public static void distribute() {
        // convert the chain to the textform using Gson API
        String chain = new GsonBuilder().setPrettyPrinting().create().toJson(DB);
        System.out.println( chain );
        try {
            Files.write(Paths.get(LEDGER_FILE), chain.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block

        }
    }
}