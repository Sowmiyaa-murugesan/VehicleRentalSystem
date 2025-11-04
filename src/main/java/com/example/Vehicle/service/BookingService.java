package com.example.Vehicle.service;

import com.example.Vehicle.model.Booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookingService {

    private static final String URL = "jdbc:mysql://localhost:3306/vehicle";
    private static final String USER = "root";
    private static final String PASSWORD = "Sowmii567@";

    public void bookVehicle(int customerId, int vehicleId, String bookingDate) throws Exception {
        String query = "INSERT INTO booking (customer_id, vehicle_id, booking_date) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, customerId);
            pst.setInt(2, vehicleId);
            pst.setString(3, bookingDate);

            pst.executeUpdate();
        }
    }

    public Booking createBooking(Booking b) {
        return b;
    }
}