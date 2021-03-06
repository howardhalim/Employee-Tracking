/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.main;


import assignment.att.AttBlock;
import assignment.att.AttBlockchain;
import assignment.att.AttTransaction;
import assignment.crypto.Crypto;
import assignment.crypto.Symmetric;
import assignment.ds.MySignature;
import assignment.function.AttendanceClass;
import assignment.function.EmployeeClass;
import assignment.function.GatewayClass;
import assignment.function.LocationClass;
import assignment.keycreator.SecretKey;
import assignment.loc.LocBlock;
import assignment.loc.LocBlockchain;
import assignment.loc.LocTransaction;
import assignment.screen.AttendanceView;
import java.io.File;
import java.security.Key;
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
    static Key myKey = SecretKey.create();
     static  Crypto crypto = new Symmetric("AES");
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
    
    public boolean checkUsername(String username) throws Exception{
        String sql = "SELECT * FROM Admin";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                String user = rs.getString("username");
                String user_decrypt = crypto.decrypt(user, myKey);
                System.out.println(user_decrypt + " " + username);
                if(user_decrypt.equals(username)){
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
        
    }
    
    public void registerAccount(String sign, String username) throws Exception{
        String sql = "INSERT INTO Admin(signature, username) VALUES(?,?)";
          
         try (Connection conn = this.connect();
               PreparedStatement ps = conn.prepareStatement(sql)) {
               
               String username_encrypted = crypto.encrypt(username,myKey);
               System.out.println(username_encrypted);
               ps.setString(1,sign);
               ps.setString(2,username_encrypted);
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
    
    public void addEmployee(String name , String ic_passport , double rate, String beacon){
         String sql = "INSERT INTO Employee(name,hourly_rate,ic_passport,beacon_id) VALUES(?,?,?,?)";
         try (Connection conn = this.connect();
               PreparedStatement ps = conn.prepareStatement(sql)) {
               
               ps.setString(1,name);
               ps.setDouble(2,rate);
               ps.setString(3,ic_passport);
               ps.setString(4,beacon);
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
                 EmployeeClass temp = new EmployeeClass(rs.getString("name"), rs.getString("ic_passport"), rs.getDouble("hourly_rate"), rs.getString("beacon_id"));
                 res.add(temp);
             }
         }catch (Exception e){
             
         }
         return res;
    }
    
    public List<LocationClass> getLocation(){
        List<LocBlock> allData = LocBlockchain.get();
        List<LocationClass> loclist = new ArrayList<>();
        System.out.println(allData);

        for(LocBlock s : allData){
            int idx = s.getHeader().getIndex();
            if(idx!=0){
                LocTransaction temp = s.getTransaction();
                System.out.println("QQ" + temp);
                for(int i = 0 ;i< temp.getDataLst().size();i++){
                    System.out.println(temp.getDataLst().get(i));
                    loclist.add(temp.getDataLst().get(i));
                }
            }
        }
        return loclist;
    }
    
    public boolean checkGateway (String gatewayid){
        
        String sql = "SELECT * FROM Gateway";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while(rs.next()){
                 String loc = rs.getString("gateway_id");
                 if(loc.equals(gatewayid)){
                     return false;
                 }
             }
         }catch (Exception e){
             
         }
        
        return true;
    }
    
    public void addGateway(String gateway_id, String location){
        String sql = "INSERT INTO Gateway(gateway_id, location) VALUES(?,?)";
        try (Connection conn = this.connect();
               PreparedStatement ps = conn.prepareStatement(sql)) {
              
               ps.setString(1,gateway_id);
               ps.setString(2,location);
               
               ps.executeUpdate();
               
          } catch (SQLException e) {
              System.out.println(e.getMessage());
        }
    }
    public List<GatewayClass> getGateway(){
        String sql = "SELECT * FROM Gateway";
         List<GatewayClass> res  = new ArrayList<>();
         try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while(rs.next()){
                 String id = rs.getString("gateway_id");
                 String temp = rs.getString("location");
                 GatewayClass te = new GatewayClass(id,temp);
                 res.add(te);
             }
         }catch (Exception e){
             
         }
         return res;
    }
    
    public void deleleGateway(String gateway_id){
        String sql = "DELETE FROM Gateway WHERE gateway_id = ?";
         try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(sql)){
               ps.setString(1, gateway_id);
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
    
    public void editEmployee(String name , String ic_passport , double rate , int id, String beacon){
         String sql = "UPDATE Employee SET name = ? , "
                + "ic_passport = ?, "
                + "hourly_rate = ?, "
                + "beacon_id = ? "
                + "WHERE employee_id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setString(2, ic_passport);
            pstmt.setDouble(3, rate);
            pstmt.setString(4, beacon);
            
            pstmt.setInt(5, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getGatewayId(String GatewaySelected) {
        String sql = "SELECT * FROM Gateway";
         try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while(rs.next()){
                 if(rs.getString("gateway_id").equals(GatewaySelected)){
                     return rs.getString("gateway_id");
                 }
             }
         }catch (Exception e){
             
         }
         return null;
    }

    public String getGatewayName(String gatewayId) {
        String sql = "SELECT * FROM Gateway";
         try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while(rs.next()){
                 if(rs.getString("gateway_id").equals(gatewayId)){
                     return rs.getString("location");
                 }
             }
         }catch (Exception e){
             
         }
         return null;
    }
    public List<AttendanceClass> getAttendance(){
       
        List<AttBlock> allData = AttBlockchain.get();
        List<AttendanceClass> attList = new ArrayList<>();

        for(AttBlock s : allData){
            int idx = s.getHeader().getIndex();
            if(idx!=0){
                AttTransaction temp = s.getTransaction();
                for(int i = 0 ;i< temp.getDataLst().size();i++){
                    attList.add(temp.getDataLst().get(i));
                }
            }
        }
        return attList;
        
    }
    
}
