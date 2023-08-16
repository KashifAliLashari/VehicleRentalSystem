/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Vehicle{
    String vehicleID, company, model;
    int year;
    double rentalRate;
    boolean available;
    
    public Vehicle(String vehicleID, String company, String model, int year, double rentalRate){
        this.vehicleID = vehicleID;
        this.company = company;
        this.model = model;
        this.year = year;
        this.rentalRate = rentalRate;
        this.available= true;
    }

    public Vehicle() {
    }
    
    
    
    public String getVehicleID(){
        return vehicleID;
    }
    
    public String getMake(){
        return company;
    }
    
    public String getModel(){
        return model;
    }
    
    public boolean isAvailable(){
        return available;
    }
    
    public void setAvailability(boolean available) {
            this.available = available;
    }
    
}
