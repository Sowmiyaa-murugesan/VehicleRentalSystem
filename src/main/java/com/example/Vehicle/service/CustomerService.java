package com.example.Vehicle.service;

import com.example.Vehicle.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CustomerService {

    private static final String URL = "jdbc:mysql://localhost:3306/vehicle";
    private static final String USER = "root";
    private static final String PASSWORD = "Sowmii567@";

    public void addCustomer(String name, String email, String phone) throws Exception {
        String query = "INSERT INTO customer (name, email, phone) VALUES (?, ?, ?)";


        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, phone);

            pst.executeUpdate();
        }
    }

    public Customer createCustomer(Customer c) {
        return c;
    }
}