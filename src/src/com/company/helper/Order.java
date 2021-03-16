package com.company.helper;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.helper.CookieCutters;

public class Order {
    private Scanner sc = new Scanner(System.in);
    private int orderId;
    private int clientId;
    private ArrayList<Integer> features = new ArrayList<>();
    private CookieCutter cookieCutter;
    private CookieCutters cookieCutterTable;

    public Order(int orderId_ ,CookieCutters cookieCutterTable_){
        orderId = orderId_;
        cookieCutterTable = cookieCutterTable_;
    }

    public CookieCutters getCookieCutterTable() {
        return cookieCutterTable;
    }

    public void setCookieCutterTable(CookieCutters cookieCutterTable) {
        this.cookieCutterTable = cookieCutterTable;
    }

    public CookieCutter getCookieCutter() {
        return cookieCutter;
    }

    public void setCookieCutter(CookieCutter cc) {
        this.cookieCutter = cc;
    }

    public ArrayList<Integer> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Integer> features) {
        this.features = features;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int calculateTotal(){
        if(this.getCookieCutter() == null) return 0;

        int total = 0;

        total += this.getCookieCutter().getBasePrice();

        for(int cost : this.getFeatures()) {
            total += this.getCookieCutter().getFeaturePrice(cost);
        }
        return total;
    }

    /**
    *   Gets the design the user wants.
    *   It searches for a valid design in the cookie cutter table, parses user input, and saves to the order
    *   once the input is a valid cookie cutter.
     *
     **/
    public void promptDesign(){
        if(this.cookieCutterTable == null) System.out.println("Please add a cookie cutter to the order before using this function.");

        //ask for what design of cookie cutter the person wants.
        System.out.println("What design would you like to set your Cookie Cutter as?");

        while(this.getCookieCutter() == null) {
            //recieve input
            String design = sc.nextLine();

            //finds the cookie cutter.
            CookieCutter selectedCookieCutter = this.cookieCutterTable.getCookieCutterByDesign(design);

            //if the design is found then add the cookiecutter design. if not send an error and continue.
            if(selectedCookieCutter != null)
                this.setCookieCutter(selectedCookieCutter);
            else {
                System.out.println();
                System.out.println("Please input a valid Cookie cutter design.");
            }
        }
        System.out.println();
    }

    /**
     * Shows the current total price of the order.
     */
    public void showCurrentPrice(){
        System.out.printf("Your current total for the order is: %d", this.calculateTotal());
        System.out.println();
        System.out.println();
    }

    /**
     * Prompts the user with what features to add to the Cookie Cutter.
     * If the user selects a feature, they can decide to add or not more features.
     *
     */
    public void promptFeatures(){
        boolean continueReading  = true;
        int feature ;
        int line  = this.cookieCutterTable.getCookieCutterByDesign(this.getCookieCutter().getDesign()).getFeaturePrices().length;

        //validates that the option is chosen for features
        while(continueReading) {

            //parses the option the user selected. Checking if it's a number or not.
            try{
                System.out.print("Select an Option:");
                feature = Integer.parseInt(sc.nextLine());
            }
            catch(Exception e){
                System.out.println("Please input a number");
                continue;
            }

            //if it's not in the range ask for another number in the range.
            if( feature < 1 || feature > line) {
                System.out.println("Please select a valid option.");
                continue;
            } else {
                //if the option is valid then :
                this.features.add(feature);
                continueReading = false;
            }
            System.out.println();
        }

    }

    public void printInvoice(){
        //print the total bill
        System.out.printf("Final Order Bill - Client ID: %s - Order Id: %s%n",String.format("%5s", this.getClientId()).replace(' ', '0'), this.getOrderId());
        System.out.println("--------------------------------------------------");
        System.out.printf("Design %s - %d%n", this.getCookieCutter().getDesign() ,this.getCookieCutter().getBasePrice());

        for(int featureNumber : features) {
            System.out.printf("Feature %d - %d$%n",featureNumber, this.getCookieCutter().getFeaturePrice(featureNumber));
        }

        System.out.println("        -----------");
        System.out.println("           "+this.calculateTotal()+"$");
        System.out.println("-------------------");

        System.out.println();

    }

}
