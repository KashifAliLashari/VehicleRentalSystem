/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Motorcycle extends Vehicle {
    boolean hasKickStart;
    int engineDisplacement;
    
 public Motorcycle(boolean hasKickStart, int engineDisplacement, Vehicle vehicles) {
        super(vehicles.vehicleID, vehicles.company, vehicles.model,vehicles.year, vehicles.rentalRate);

     this.hasKickStart = hasKickStart;
        this.engineDisplacement = engineDisplacement;
    }    
}
