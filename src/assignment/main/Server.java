/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.main;

import assignment.att.AttBlock;
import assignment.att.AttBlockchain;
import assignment.att.AttTransaction;
import assignment.function.LocationClass;
import assignment.ds.MySignature;
import assignment.function.AttendanceClass;
import assignment.function.EmployeeClass;
import assignment.loc.LocBlock;
import assignment.loc.LocBlockchain;
import assignment.loc.LocTransaction;
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
    
    // Store at Blockchain
    public static boolean addEmployeeLocation(ArrayList<LocationClass> locList){
        if (!(new File(LocBlockchain.CHAIN_FILE)).exists()){
            new File("master").mkdir();
            LocBlockchain.genesis();
        }
        try{
            LocTransaction transList = new LocTransaction();
            for (LocationClass loc : locList){
                transList.add(loc);
            }
            String prevhash = LocBlockchain.get().getLast().getHeader().getCurrentHash();
            int previndex = LocBlockchain.get().getLast().getHeader().getIndex();
            LocBlock b = new LocBlock(prevhash,previndex+1);
            b.setTransaction(transList);
            transList.setMerkleRoot();

            LocBlockchain.nextBlock(b);
            LocBlockchain.distribute(); 
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    // Store at Blockchain
    public static boolean addEmployeeAttendance(ArrayList<AttendanceClass> attList){
        if (!(new File(AttBlockchain.CHAIN_FILE)).exists()){
            new File("master").mkdir();
            AttBlockchain.genesis();
        }
        try{
            AttTransaction attendance = new AttTransaction();
            for (AttendanceClass att : attList){
                attendance.add(att);
            }
            String prevhash = AttBlockchain.get().getLast().getHeader().getCurrentHash();
            int previndex = AttBlockchain.get().getLast().getHeader().getIndex();
            AttBlock b = new AttBlock(prevhash,previndex+1);
            b.setTransaction(attendance);
            attendance.setMerkleRoot();

            AttBlockchain.nextBlock(b);
            AttBlockchain.distribute(); 
            return true;
        } catch (Exception e){
            e.printStackTrace();
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
    
    public void addEmployee(String name , String ic_passport , double rate){
         String sql = "INSERT INTO Employee(name,hourly_rate,ic_passport) VALUES(?,?,?)";
         try (Connection conn = this.connect();
               PreparedStatement ps = conn.prepareStatement(sql)) {
              
               ps.setString(1,name);
               ps.setDouble(2,rate);
               ps.setString(3,ic_passport);
               ps.executeUpdate();
               
          } catch (SQLException e) {
              System.out.println(e.getMessage());
        }
    }

    public List<EmployeeClass> getEmployee() {
         String sql = "SELECT * FROM Employee";
         List<EmployeeClass> res  = new ArrayList<>();
         try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while(rs.next()){
                 EmployeeClass temp = new EmployeeClass(rs.getString("name"), rs.getString("ic_passport"), rs.getDouble("hourly_rate"));
                 res.add(temp);
             }
         }catch (Exception e){
             
         }
         return res;
    }
}
