/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.crypto;

import java.sql.Connection;
import java.sql.DriverManager;
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
            //change to appropriate directory
            String url = "jdbc:sqlite:E:\\Lecture\\0_Assignment\\Year 3\\BCD\\Employee-Tracking\\Database.db";
            con = DriverManager.getConnection(url);
        }
        catch (SQLException s)
        {
            System.out.println(s.getMessage());
        }
        return con;
    }

    public List<List<String>> getEmployeeData(){
        String sql = "SELECT * FROM Employee";
        List<List<String>> data = new ArrayList<>();
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){

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
    
}
