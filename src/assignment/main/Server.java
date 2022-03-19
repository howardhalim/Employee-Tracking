/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.main;


import assignment.ds.MySignature;
import assignment.function.EmployeeClass;
import assignment.function.LocationClass;
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
    
    public boolean checkGateway (String location){
        
        String sql = "SELECT * FROM Gateway";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while(rs.next()){
                 String loc = rs.getString("location");
                 if(loc.equals(location)){
                     return false;
                 }
             }
         }catch (Exception e){
             
         }
        
        return true;
    }
    
    public void addGateway(String location){
        String sql = "INSERT INTO Gateway(location) VALUES(?)";
        try (Connection conn = this.connect();
               PreparedStatement ps = conn.prepareStatement(sql)) {
              
               ps.setString(1,location);
               
               ps.executeUpdate();
               
          } catch (SQLException e) {
              System.out.println(e.getMessage());
        }
    }
    public List<String> getGateway(){
        String sql = "SELECT * FROM Gateway";
         List<String> res  = new ArrayList<>();
         try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while(rs.next()){
                 String temp = rs.getString("location");
                 res.add(temp);
             }
         }catch (Exception e){
             
         }
         return res;
    }
    
    public void deleleGateway(String location){
        String sql = "DELETE FROM Gateway WHERE location = ?";
         try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(sql)){
               ps.setString(1, location);
               ps.executeUpdate();
               
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteEmployee(EmployeeClass emp){
        String sql = "DELETE FROM Employee WHERE (name,ic_passport)  = (?,?)";
         try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(sql)){
               ps.setString(1, emp.getName());
               ps.setString(2, emp.getIc_passport());
               ps.executeUpdate();
               
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public int getEmployeeId(EmployeeClass emp) {
         String sql = "SELECT * FROM Employee";
         
         try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while(rs.next()){
                 if(rs.getString("name").equals(emp.getName()) && rs.getString("ic_passport").equals(emp.getIc_passport())){
                     return rs.getInt("employee_id");
                 }
             }
         }catch (Exception e){
             
         }
         return -1;
    }
    
    public void editEmployee(String name , String ic_passport , double rate , int id){
         String sql = "UPDATE Employee SET name = ? , "
                + "ic_passport = ?, "
                + "hourly_rate = ? "
                + "WHERE employee_id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setString(2, ic_passport);
            pstmt.setDouble(3, rate);
            
            
            pstmt.setInt(4, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
