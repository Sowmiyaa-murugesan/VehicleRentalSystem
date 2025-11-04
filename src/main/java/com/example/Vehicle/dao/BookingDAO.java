package com.example.Vehicle.dao;

import com.example.Vehicle.model.Booking;
import com.example.Vehicle.util.DBConnection;

import java.sql.*;

public class BookingDAO {

    public Booking create(Booking b) throws Exception {
        String sql = "INSERT INTO booking (customer_id,vehicle_id,booking_date) VALUES (?,?,?)";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, b.getCustomerId());
        ps.setInt(2, b.getVehicleId());
        ps.setString(3, b.getBookingDate());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            b.setBookingId(rs.getInt(1));
        }
        return b;
 }
}
