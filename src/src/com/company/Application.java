package com.company;

import com.company.helper.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    Scanner sc = new Scanner(System.in);
    CookieCutters cookieCutterTable = new CookieCutters();
    Orders orders = new Orders();
    Clients clients = new Clients();
    public Application(){

        // Declare the hardcoded price table.
        cookieCutterTable.addCookieCutter("Nature",300,new int[]{10,15,20,25,30});
        cookieCutterTable.addCookieCutter("Tech",350,new int[]{20,30,40,50,60});
        cookieCutterTable.addCookieCutter("Business",375,new int[]{30,40,50,60,70});
        cookieCutterTable.addCookieCutter("Music",400,new int[]{85,95,110,130,210});
        cookieCutterTable.addCookieCutter("Naughty",500,new int[]{100,200,300,400,500});

        do{
            // Welcomes the user
            printWelcome();

            // Creates an order Id;
            Order newOrder = new Order(orders.getSize() + 1, cookieCutterTable);

            // Show design menu
            designMenu(cookieCutterTable);

            // Prompt the user to enter the design
            newOrder.promptDesign();

            //show the price after the user enters the design
            newOrder.showCurrentPrice();


            // Prompt the user to enter the features.
            do {
                // Show feature menu
                featureMenu(newOrder.getCookieCutter());
                newOrder.promptFeatures();
            }
            while(promptYoN("Would you like to add more Features"));

            // Show the price after the user enters the features
            newOrder.showCurrentPrice();


            // Creates a new client
            Client newClient = new Client(clients.getSize() + 1);

            // Adds the client to the order.
            newOrder.setClientId(newClient.getClientId());

            // Prompts the form for the new client to input their data.
            newClient.promptClientData();

            // Shows the invoice for the client.
            newOrder.printInvoice();

            //idk if i should put at the end or after creating the client and order
            // Adds client and then adds the created order.
            clients.addClient(newClient);
            orders.addOrder(newOrder);
        }
        while(promptYoN("Would you like to continue the application"));
    }

    /**
     * Prints the normal welcome message for the professor.
     */
    public void printWelcome(){
        System.out.println("-------------------------------------");
        System.out.println("Welcome to the Cookie Cutter program.");
        System.out.println("-------------------------------------");
        System.out.println("Made by - Cam The best programmer");
        System.out.println();
    }

    /**
     * Displays the menu for the cookie cutter designs, each price included.
     * @param cookieCutterTable
     */
    public void designMenu(CookieCutters cookieCutterTable){
        ArrayList<CookieCutter> cookieCutters = cookieCutterTable.getCookieCutters();
        System.out.println("Please select a design to buy: ");
        System.out.println();
        System.out.println("Name        Price");
        System.out.println("------------------");
        for(CookieCutter c: cookieCutters){
            System.out.printf("%-10s | %d$%n",c.getDesign(),c.getBasePrice());
        }
        System.out.println();
    }

    /**
     * Shows the menu of the different features and it's prices of the current selected cookiecutter to buy.
     * @param currentCookieCutter the selected cookie cutter for this order.
     */
    public void featureMenu(CookieCutter currentCookieCutter){
        int[] featureCosts = currentCookieCutter.getFeaturePrices();

        int line = 1;
        int featureNumber = 1;
        for(int cost: featureCosts)
        {//1. Feature 1 Price:
            System.out.printf("%d. Feature %d Price: %d$%n",line, featureNumber , cost);
            line += 1;
            featureNumber += 1;
        }

        //shows features on screen
        System.out.printf("What feature would you like to choose for the cookie cutter? (1-%d)%n",featureCosts.length);
        System.out.println();
    }

    /**
     * Checks for user input depending on the question
     * @return returns a boolean
     */
    public boolean promptYoN(String question){
        System.out.println(String.format("%s? (y/n)",question));
        String response = "";
        while(!(response.contains("y")  || response.contains("n"))){
            response = sc.nextLine();

            if (response.contains("y")) {
                return true;
            } else if (response.contains("n")) {
                return false;
            }
            else{
                System.out.println(String.format("%s? (y/n)",question));
            }

            if(!(response.contains("y")  || response.contains("n")))
                System.out.println("(y/n)?");
            else
                return response.contains("y");
            System.out.println();
        }
        return false;
    }
}
