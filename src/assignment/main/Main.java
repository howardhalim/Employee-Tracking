/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.main;

import assignment.ds.MySignature;
import assignment.function.EmployeeClass;
import assignment.function.LocationClass;
import assignment.loc.LocBlock;
import assignment.loc.LocBlockchain;
import assignment.loc.LocTransaction;
import assignment.screen.MainPage;
import assignment.screen.RegisterPage;
import java.io.FileWriter;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author howard
 */
public class Main {
   public static MainPage main = new MainPage();
   public static List<EmployeeClass> EmployeeList;
   public static List<String> GatewayList;
    public static void main(String[] args) throws Exception {
        Server x = new Server();
        EmployeeList = x.getEmployee();
        GatewayList = x.getGateway();
        System.out.println(GatewayList);
        assignment.screen.LoginPage res = new assignment.screen.LoginPage();
        res.setVisible(true);
        
        System.out.println(LocBlockchain.get());
        
        System.out.println("gg\n" + LocBlockchain.get());
        LinkedList<LocBlock> allData = LocBlockchain.get();
        for(LocBlock s : allData){
            System.out.println("s\n"+ s);
            LocTransaction g = s.getTransaction();
            System.out.println("g\n"+ g);
            if(g!=null){
                ArrayList<LocationClass> ss = g.getDataLst();
                System.out.println("ss\n"+ ss);
            }

        }

//        MySignature mysig = new MySignature();
//        byte[] publicBytes = Base64.decodeBase64("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCR5hlWzDSvNzsW6xKl3trTbczPNekq2Bx4CeOSjxh++HqMPnd14bwBWWiIQ5VkURyn+x60BxGp6WpHjN/0aiPLqZV1OfB2GOrUUTbbtXe8av7mUOZjLj39kNw01kpB7tQSutuJKgOhfogCQt++75rFHTFEH4L1+cv8RcRpAFYmlwIDAQAB");
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey pub = keyFactory.generatePublic(keySpec);
//        System.out.println(mysig.verify("Howard12345", "fpl5ZzBBhvh3w9WPdWx2rh3CC5ijQma6XrVtYf4Q3nQRXsg7K76LjwiQb8hgYuTmv0eDB4C/VFpiEOEikOR2PDrix/Z4C8ndUYnbntui2insYnfE8YdIg+4bqy4ge1PBnzXAmssLJF3RitO2qCDClvAyHar43yrg8YintY999cc=", pub));
//        
//        String projectPath = System.getProperty("user.dir");
//        FileWriter wr = new FileWriter(projectPath+"\\PublicKey.txt",true);
//        wr.write(System.getProperty( "line.separator" ));
//        wr.write("TEST");
//        wr.close();
    
    }
}
