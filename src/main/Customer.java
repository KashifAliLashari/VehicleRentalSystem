/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;

public class Customer {
    String customerID;
    String name;
    //Vehicle[] rentedVehicles;
    ArrayList<Vehicle> rentedVehicles = new ArrayList<>(); // Set initial capacity to 5

    int numberOfRentedVehicles=0;
    
    
    public Customer(String customerID, String name){
        this.customerID = customerID;
        this.name = name;
    }

    public Customer() {
    }
    
    
    
    
    
    String getCustomerID(){
        return customerID;
    }
    
    String getName(){
        return name;
    }
    
    void rentVehicle(Vehicle vehicle){
                rentedVehicles.add(vehicle);
                numberOfRentedVehicles++; 
    }
    
    
    Vehicle returnVehicle(Vehicle vehicle) {
       if (rentedVehicles.contains(vehicle)){
           rentedVehicles.remove(vehicle);
           numberOfRentedVehicles--;
           
           return vehicle;
       }
           return null;
    }
    
    void displayRentedVehicles(){
        for (int i=0; i < numberOfRentedVehicles; i++)
        {
            System.out.println(rentedVehicles.get(i));
        }
    }
 
    
}
