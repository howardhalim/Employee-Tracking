/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.main;

import assignment.crypto.Blockchain;
import assignment.ds.MySignature;
import java.io.File;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Steven-
 */
public class Server {
    // Connect SQLite Database
    static String projectPath = System.getProperty("user.dir");
    public static Connection connect(){
        Connection con = null;
        try
        {
            
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
    
    public boolean checkUsername(String username){
        String sql = "SELECT * FROM Admin";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                String user = rs.getString("username");
                if(user.equals(username)){
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
        
    }
    
    public void registerAccount(String sign, String username){
        String sql = "INSERT INTO Admin(signature, username) VALUES(?,?)";
          
         try (Connection conn = this.connect();
               PreparedStatement ps = conn.prepareStatement(sql)) {
              
               ps.setString(1,sign);
               ps.setString(2,username);
               ps.executeUpdate();
             
          } catch (SQLException e) {
              System.out.println(e.getMessage());
              
        }
    }
    
    public boolean verification(String verif) throws Exception{
         String sql = "SELECT * FROM Admin";
           try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
             
            // loop through the result set
            
                    
                while (rs.next()) {
                    String signature = rs.getString("signature");
                    MySignature mysig = new MySignature();
                    File f = new File(projectPath+"\\PublicKey.txt");
                    Scanner read = new Scanner(f);
                    while(read.hasNext()){
                    
                        byte[] publicBytes = Base64.decodeBase64(read.next());
                        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
                        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                        PublicKey pubKey = keyFactory.generatePublic(keySpec);
                        
                        if(mysig.verify(verif, signature,pubKey)){
                            return true;
                        }
                }
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
          
        
        return false;
    }
}
