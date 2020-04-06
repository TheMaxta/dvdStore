package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class DvdDriver {
    public static void main(String[] args) {

        // *************** | File I/o  | ********************
        readFile reader = new readFile();
        writeFile writer = new writeFile();
        ArrayList instanceArray;
        //****************************************


        Scanner input = new Scanner(System.in);
        DvdStore client;
        String passwordEntered = "";
        String realPassword = "1234";
        String search;
        String client_response = "";
        boolean isManager = false;
        int search_index;
        String first,last;

        System.out.println("User(true) or Manager(false)?");
        boolean response = input.nextBoolean();
        if (response){
            System.out.println("Welcome User!");

        }else{
            while (!passwordEntered.equals("q")) {
                System.out.println("Manager Selected");
                System.out.println("Please enter password for manager: ");
                passwordEntered = input.next();
                if (passwordEntered.equals(realPassword)) {
                    System.out.println("Welcome manager!");
                    isManager = true;
                    break;
                } else {
                    System.out.println("Wrong password! Type q to quit. ");
                }
            }
        }

        client = new DvdStore(isManager);

        // *************** | Read from file and set store vals  | ********************

        reader.readArray();
        instanceArray = reader.returnUserArray();
        client.fetchData(instanceArray);

        //****************************************


        first = client.getFirstName();
        last = client.getLastName();

        if (isManager){
            client.addManager(first,last);
        }
        else {
            client.addUser(first, last);
        }

        client.addStdComputers(2);


        while(!(client_response.equals("q") || client_response.equals("Q")))
        {
            client.displayOptions();
            client_response = input.next();
            client.selectAction(client_response);
        }


        //when program closes
        // *************** | get Updated data from Store, and write to File  | ********************

        instanceArray = client.returnData();
        writer.getArray(instanceArray);
        writer.writeArray();

        //********************************************************************************

    }
}
