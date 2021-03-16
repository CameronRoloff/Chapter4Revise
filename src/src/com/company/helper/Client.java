package com.company.helper;
import java.util.Scanner;
public class Client {
    private Scanner sc  ;
    private int clientId;
    private String firstName;
    private String lastName;
    private String companyName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Client(int clientId_){
        clientId = clientId_;
    }
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void promptClientData(){
        sc = new Scanner(System.in);
        System.out.println("Creating new Client in Database...");

        System.out.print("Enter Name: ");
        this.setFirstName(sc.nextLine());

        System.out.print("Enter Last Name: ");
        this.setLastName(sc.nextLine());

        System.out.print("Enter Company Name: ");
        this.setCompanyName(sc.nextLine());

        System.out.print("Enter Address: ");
        this.setAddress(sc.nextLine());

        System.out.print("Enter City: ");
        this.setCity(sc.nextLine());

        System.out.print("Enter State: ");
        this.setState(sc.nextLine());

        System.out.print("Enter Zip: ");
        this.setZip(sc.nextLine());

        System.out.print("Enter Phone: ");
        this.setPhone(sc.nextLine());
        //sc.close();
    }
}
