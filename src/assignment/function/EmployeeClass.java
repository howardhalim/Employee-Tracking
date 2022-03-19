/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.function;

/**
 *
 * @author howard
 */
public class EmployeeClass {
    String name;
    String ic_passport;
    double hourly_rate;

    public EmployeeClass(String name, String ic_passport, double hourly_rate) {
        this.name = name;
        this.ic_passport = ic_passport;
        this.hourly_rate = hourly_rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc_passport() {
        return ic_passport;
    }

    public void setIc_passport(String ic_passport) {
        this.ic_passport = ic_passport;
    }

    public double getHourly_rate() {
        return hourly_rate;
    }

    public void setHourly_rate(double hourly_rate) {
        this.hourly_rate = hourly_rate;
    }
    
}
