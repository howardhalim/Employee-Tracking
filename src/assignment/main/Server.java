/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.main;

import assignment.crypto.Blockchain;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven-
 */
public class Server {
    // Connect SQLite Database
    public static Connection connect(){
        Connection con = null;
        try
        {
            String projectPath = System.getProperty("user.dir");
            //change to appropriate directory
            String url = "jdbc:sqlite:" + projectPath + "\\Database.db";
            con = DriverManager.getConnection(url);
        }
        catch (SQLException s)
        {
            System.out.println(s.getMessage());
        }
        return con;
    }

    public List<List<String>> getEmployeeData(){
        String query = "SELECT * FROM Employee";
        List<List<String>> data = new ArrayList<>();
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){

            // loop through the result set
            while (rs.next()) {
                String id = rs.getString("employee_id");
                String name = rs.getString("name");
                String user = rs.getString("username");
                String pass = rs.getString("password");

                List<String> temp = new ArrayList<>();
                temp.add(id);
                temp.add(name);
                temp.add(user);
                temp.add(pass);
                data.add(temp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        return data;
    }
    
    // Blockchain
    public static boolean addEmployeeLocation(String employee, String gateway, String detectedTime, String scanTime){
        String chainFile = "master/Location.bin";
        String ledgerFile = "Location.txt";
        Blockchain chain = new Blockchain(chainFile, ledgerFile);
        if (!(new File(chain.CHAIN_FILE)).exists()){
            new File("master").mkdir();
            Blockchain.genesis();
        } else {
//            String tranx1 = "alice|bob|rm10";
//            String tranx2 = "alice|bob|rm20";
//
//            Transaction tranxLst = new Transaction();
//            tranxLst.add(tranx1);
//            tranxLst.add(tranx2);
//
//            String prevhash = Blockchain.get().getLast().getHeader().getCurrentHash();
//            int previndex = Blockchain.get().getLast().getHeader().getIndex();
//            Block b = new Block(prevhash, previndex+1);
//            b.setTransaction(tranxLst);
//
//
//            Blockchain.nextBlock(b);
//            Blockchain.distribute();
//            new Transaction();
        }
        return false;
    }
}
