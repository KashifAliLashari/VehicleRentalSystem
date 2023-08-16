/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import main.Vehicle;

public class Car extends Vehicle{
    VechicleRentalSystem obj = new VechicleRentalSystem();
       
    int numberOfDoors;
    boolean hasAC;
    Vehicle vehicles;

    public Car(int numberOfDoors, boolean hasAC, Vehicle vehicles) {
        super(vehicles.vehicleID, vehicles.company, vehicles.model,vehicles.year, vehicles.rentalRate);
        this.numberOfDoors = numberOfDoors;
        this.hasAC = hasAC;
        this.vehicles = vehicles;
    }
   
}
