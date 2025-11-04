package com.example.Vehicle.service;

import com.example.Vehicle.model.Vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class VehicleService {

    private static final String URL = "jdbc:mysql://localhost:3306/vehicle";
    private static final String USER = "root";
    private static final String PASSWORD = "Sowmii567@";

    public void addVehicle(String plateNo, String model, int batteryPercent) throws Exception {
        String query = "INSERT INTO vehicle (plate_no, model, battery_percent) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, plateNo);
            pst.setString(2, model);
            pst.setInt(3, batteryPercent);

            pst.executeUpdate();
        }
    }

    public Vehicle createVehicle(Vehicle v) {
        return v;
    }
}

