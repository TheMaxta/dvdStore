package com.company;

import java.io.Serializable;

public class User implements Serializable {
    String first_name;
    String last_name;

    public User(String f_name, String l_name){
        this.first_name = f_name;
        this.last_name = l_name;
    }



    //user has name and wallet

}
