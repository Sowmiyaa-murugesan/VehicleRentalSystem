package com.example.Vehicle;

import com.example.Vehicle.service.CustomerService;
import com.example.Vehicle.service.VehicleService;
import com.example.Vehicle.service.BookingService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Vehicle Rental System Started ===");
        Scanner scanner = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        BookingService bookingService = new BookingService();

        try {

            System.out.println("\nEnter Customer Details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            customerService.addCustomer(name, email, phone);
            System.out.println(" Customer added successfully!");


            System.out.println("\nEnter Vehicle Details:");
            System.out.print("Vehicle Number: ");
            String vehicleNumber = scanner.nextLine();

            System.out.print("Vehicle Model: ");
            String model = scanner.nextLine();

            System.out.print("Battery Percentage: ");
            int battery = Integer.parseInt(scanner.nextLine());

            vehicleService.addVehicle(vehicleNumber, model, battery);
            System.out.println(" Vehicle added successfully!");


            System.out.println("\nEnter Booking Details:");
            System.out.print("Customer ID: ");
            int customerId = Integer.parseInt(scanner.nextLine());

            System.out.print("Vehicle ID: ");
            int vehicleId = Integer.parseInt(scanner.nextLine());

            System.out.print("Booking Date (yyyy-mm-dd): ");
            String date = scanner.nextLine();

            bookingService.bookVehicle(customerId, vehicleId, date);
            System.out.println(" Booking created successfully!");

            System.out.println("\n=== All operations completed successfully! ===");

        } catch (Exception e) {
            System.out.println("⚠️ ERROR: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
