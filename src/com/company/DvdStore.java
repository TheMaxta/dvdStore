package com.company;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;


public class DvdStore {

    ArrayList<Dvd> stock = new ArrayList<>();
    Enum current_user;
    boolean isManager;
    Scanner input = new Scanner(System.in);
    String search_word;
    int rID;
    //if manager is true, allow for additional functionality inside of store class
    public DvdStore(boolean isManager){
        this.isManager=isManager;
    }

    public void addManager(String f, String l){
        Manager current_user = new Manager(f,l);
    }

    public void addUser(String f, String l){
        User current_user = new User(f,l);
    }

    public void addStdComputers(int num){
        for (int i = 0; i < num; i++) {
            stock.add(new Dvd("Jaws3DD", "01/22/2019", "john"));
        }
    }

    public void addDvd(){
        String title;
        String date;
        String actor;

        System.out.println("Please enter movie title: ");
        title = input.nextLine();
        System.out.println("Please enter movie date: ");
        date = input.nextLine();
        System.out.println("Please enter movie actor: ");
        actor = input.nextLine();
        stock.add(new Dvd(title, date, actor));
    }

    public void displayAllDvds(){

        if (stock.size() <= 0){ System.out.println("There are no movies in database.");}

        for (int i = 0; i < stock.size(); i++) {
            System.out.println("Movie number: "+(i+1));
            System.out.println("title: " + stock.get(i).getTitle());
            System.out.println("Release: " + stock.get(i).getRelease_date());
            System.out.println("Lead: " + stock.get(i).getLead_actor());
            System.out.println("---------------------------------------");

        }

    }

    public int findDvd(String search_title){
        int index= 0;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getTitle().equals(search_title)){
                index = i;
            }
        }
        if (index == 0){
            System.out.println("Movie not found in database!");
        }
        return index;
    }

    public void displayDvd(int index){
        System.out.println(stock.get(index));
    }

    public void removeDvd(int index){
        if (isManager){
            stock.remove(index);
        }
        else{
            System.out.println("Only a manager can remove DVDs.");
        }
    }

    public void accountSettingsMenu() {

        //is there a way to declare current_user as either a manager or user.
        //this line will only run after the add manager or add user methods have been run, but we cannot user current_user b/c compiler error
        System.out.println("1) Change first name: ");
        System.out.println("2) Change last name: ");
        if (isManager) {
            System.out.println("3) Set Profit Numbers: ");
            System.out.println("4) Set Sales Numbers: ");
        }
    }

    public void removeAllDvds(){
        if (isManager){
            stock.clear();
        }
        else {
            System.out.println("Only a manager can do this!");
        }
    }
    public void selectAction(String response){
        //removeAllDvds();
        //conditional that runs display, print, and remove based on response
        switch(response) {
            case "1":
                System.out.println("Enter title");
                search_word = input.nextLine();
                findDvd(search_word);
                break;
            case "2":
                //check stock

                break;
            case "3":
                //remove movie
                rID = input.nextInt();
                removeDvd(rID);
                break;
            case "4":
                //remove all
                removeAllDvds();
                break;
            case "5":
                displayAllDvds();
                break;
            case "6":
                addDvd();
                break;
            case "7":
                accountSettingsMenu();
                break;
            default:
                // code block
        }
    }
    public void displayOptions(){
        System.out.println("1) Find a movie");
        System.out.println("2) Check if a movie is in stock");
        System.out.println("3) Remove a movie");
        System.out.println("4) Remove all movies");
        System.out.println("5) display all movies");
        System.out.println("6) add a movie");
        System.out.println("7) Account setup");
    }

    public String getFirstName(){
        String name;
        System.out.println("Please input your first name: ");
        name = input.nextLine();
        return name;
    }
    public String getLastName(){
        String name;
        System.out.println("Please input your last name: ");
        name = input.nextLine();
        return name;
    }

}
