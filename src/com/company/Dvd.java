package com.company;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

public class Dvd implements Serializable {
    public String movie_title;
    public String release_date;
    public String lead_actor;
    public int rating;
    public int price;


    public Dvd(String movie, String date,String actor){
        this.movie_title = movie;
        this.release_date = date;
        this.lead_actor = actor;
    }

    public String getTitle(){
        return (this.movie_title);
    }

    public String getRelease_date(){
        return this.release_date;
    }

    public String getLead_actor(){
        return this.lead_actor;
    }

    public void setTitle(String new_title){
        this.movie_title = new_title;
    }

    public void setRelease_date(String new_date){
        this.release_date = new_date;
    }

    public void setActor(String new_actor){
        this.lead_actor = new_actor;
    }

}
