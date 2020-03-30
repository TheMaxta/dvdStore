package com.company;

public class Manager extends User {

    public String password;
    public double profit;
    public double sales;

    public Manager(String f_name, String l_name) {
        super(f_name, l_name);
    }

    public void setPassword(String new_password){
        this.password = new_password;
    }



    //manager has name, and infinite wallet

}
