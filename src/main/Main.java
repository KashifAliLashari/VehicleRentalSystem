/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import java.util.ArrayList;
import main.Car;
import main.Customer;
import main.Motorcycle;
import main.Vehicle;
import java.util.Scanner;

class VechicleRentalSystem {
    
//    ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object

    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    int numberOfVehicles=0;
    
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
        numberOfVehicles++;
    }
    
    public void displayAvailableVehicles(){
        System.out.println("List of Avaialable Vehciles:");
        for(int i=0; i < numberOfVehicles; i++){
            Vehicle v = vehicles.get(i);
            System.out.println(v.vehicleID +" - " + v.company +" " + v.model);
        }
        System.out.println();
    }
    
    public void rentVehicle(Customer customer, String vehicleID, int rentalPeriod) {
        Vehicle foundVehicle = findVehicleByID(vehicleID);
        if (foundVehicle != null)
        {
            customer.rentVehicle(foundVehicle);
            numberOfVehicles--;
            System.out.println("Vehicle rented successfully ");
        }
        
        else {
            System.out.println("Vehicle not available for rent.");
        }
    }
//    public void returnVehicle(Customer customer, String vehicleID){
//        Vehicle foundVehicle = findVehicleByID(vehicleID);
//        if (foundVehicle != null && !foundVehicle.isAvailable()) {
//            customer.returnVehicle(foundVehicle);
//            System.out.println("Vehicle returned successfully");
//        } else {
//            System.out.println("Invalid vehicle ID or vehicle not rented.");
//        }
//    }    
   
    public Vehicle findVehicleByID(String vehicleID){
        Vehicle obj = null;
        for (int i = 0; i < numberOfVehicles; i++) {
            Vehicle v = vehicles.get(i);
            if (v.getVehicleID().equals(vehicleID)) {
                obj =  vehicles.get(i);
            }
            else
            System.out.println("Vehicle not found with this ID: " + vehicleID);

        }
        return obj;
    }
    
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        VechicleRentalSystem obj = new VechicleRentalSystem();
        Customer customer = new Customer();
        
        int input;        
       do{
            System.out.println("Vehicle Rental System Menu:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Available Vehicles");
            System.out.println("3. Create Customer");
            System.out.println("4. View List of Customers");
            System.out.println("5. Rent Vehicle");
            System.out.println("6. Return Vehicle");
            System.out.println("7. Search Vehicle by ID");
            System.out.println("8. Exit");
            
            System.out.print("Enter Your Choice:");
            input = in.nextInt();
            System.out.println();
            
            if(input == 1){
                in.nextLine(); 
                    System.out.print("Enter Vechile Type (Car/Motorcyle):");
                    String vType = in.nextLine();
                    if(vType.equals("Car"))
                    {
                        System.out.print("Enter vehcile ID:");
                        String vID = in.nextLine();
                        System.out.print("Enter make:");
                        String make = in.nextLine();
                        System.out.print("Enter model:");
                        String model = in.nextLine();
                        System.out.print("Does the car have air conditioning:");
                        String option = in.nextLine();
                        System.out.print("Enter year:");
                        int year = in.nextInt();
                        System.out.print("Enter rental rate per day:");
                        int rentalRate = in.nextInt();
                        System.out.print("Enter the number of doors:");
                        int numberOfDoors = in.nextInt();                                
                            
                        boolean hasAC = Boolean.parseBoolean(option);
                        Vehicle vehicles = new Vehicle(vID, make, model, year, rentalRate);
                        Car car = new Car(numberOfDoors, hasAC, vehicles); 
                        
                        obj.addVehicle(car);
                        vehicles.setAvailability(true);
                        System.out.println("Car added to the list of available vehicles.");
                        System.out.println();
                    }
                    else if(vType.equals("Motorcycle")){
                        System.out.print("Enter vehcile ID:");
                        String vID = in.nextLine();
                        System.out.print("Enter make:");
                        String make = in.nextLine();
                        System.out.print("Enter model:");
                        String model = in.nextLine();
                        System.out.print("Enter year:");
                        int year = in.nextInt();
                        System.out.print("Enter rental rate per day:");
                        int rentalRate = in.nextInt();
                        in.nextLine();
                        System.out.print("Does the motorcycle have a kick start? (true/false):");
                        String option = in.nextLine();
                        System.out.print("Enter engine displacement:");
                        int engine = in.nextInt();                                
                        boolean kickStart = Boolean.parseBoolean(option);
                        
                        Vehicle vehicles = new Vehicle(vID, make, model, year, rentalRate);
                        Motorcycle motor = new Motorcycle(kickStart,engine, vehicles); 
                        
                        obj.addVehicle(motor);
                        vehicles.setAvailability(true);
                        System.out.println("Motorcycle added to the list of available vehicles.");
                        System.out.println();
                    }
            }
            
            else if(input == 2){
                obj.displayAvailableVehicles();
            } 
            
            else if(input == 3){
                in.nextLine();
                System.out.print("Enter customer ID:");
                String cID = in.nextLine();
                System.out.print("Enter name:");
                String customerName = in.nextLine();
                customer = new Customer(cID, customerName);
                System.out.println("Customer created successfully");
                System.out.println();
            }
            
            else if(input == 4){
                System.out.println("List of Customers:");
                
                System.out.println(customer.getCustomerID() + " - " + customer.getName());              

                System.out.println();
            }
            
            else if(input == 5){
                obj.displayAvailableVehicles(); 
                in.nextLine();
                System.out.print("Enter customer ID:");
                String cID = in.nextLine();
                System.out.print("Enter vehicle ID to rent:");
                String vID = in.nextLine();
                System.out.print("Enter rental period (in days):");
                int rentDays = in.nextInt();
                if (!customer.getCustomerID().equals(cID)){
                    System.out.print("Customer not Found!\n");
                    continue;
                }
                       
                obj.rentVehicle(customer, vID, rentDays);
                obj.vehicles.remove(obj.findVehicleByID(vID));
            }
            
            else if(input == 6){
                in.nextLine();
                System.out.println("List of Customers:");
                System.out.println(customer.getCustomerID() + " - " + customer.getName());              
                System.out.print("Enter customer ID:");
                String cID = in.nextLine();
                System.out.print("Enter vehicle ID to return:");
                String vID = in.nextLine();
                if (!customer.getCustomerID().equals(cID)){
                    System.out.print("Customer not Found!\n");
                    continue;
                }
                obj.addVehicle(customer.returnVehicle(obj.findVehicleByID(vID)));
                
                System.out.println("Vehicle returned successfully");
            }
            
            
            
            
    }while(input != 8);

    }
    
}
