/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.main;

import assignment.screen.MainPage;
import assignment.screen.RegisterPage;

/**
 *
 * @author howard
 */
public class Main {
   public static MainPage main = new MainPage();
    public static void main(String[] args) {
        assignment.screen.LoginPage res = new assignment.screen.LoginPage();
        res.setVisible(true);
    }
}
