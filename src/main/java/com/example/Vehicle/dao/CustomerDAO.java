package com.example.Vehicle.dao;

import com.example.Vehicle.model.Customer;
import com.example.Vehicle.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public Customer create(Customer c) throws Exception {
        String sql = "INSERT INTO customer (name,email,phone) VALUES (?,?,?)";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, c.getName());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getPhone());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            c.setCustomerId(rs.getInt(1));
        }
        return c;
    }
    public List<Customer> getAll() throws Exception {
        String sql = "SELECT * FROM customer";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Customer> list = new ArrayList<>();
        while (rs.next()) {
            Customer c = new Customer();
            c.setCustomerId(rs.getInt("customer_id"));
            c.setName(rs.getString("name"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
            list.add(c);

        }
        rs.close();
        ps.close();
        conn.close();
        return list;
  }
}
