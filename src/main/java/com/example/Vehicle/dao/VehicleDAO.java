package com.example.Vehicle.dao;

import com.example.Vehicle.model.Vehicle;
import com.example.Vehicle.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    public Vehicle create(Vehicle v) throws Exception {
        String sql = "INSERT INTO vehicle (model,plate_no,battery_percent) VALUES (?,?,?)";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, v.getModel());
        ps.setString(2, v.getPlateNo());
        ps.setInt(3, v.getBatteryPercent());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            v.setVehicleId(rs.getInt(1));
        }
        return v;
    }

    public List<Vehicle> getAll() throws Exception {
        String sql = "SELECT * FROM vehicle";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Vehicle> list = new ArrayList<>();
        while (rs.next()) {
            Vehicle v = new Vehicle();
            v.setVehicleId(rs.getInt("vehicle_id"));
            v.setModel(rs.getString("model"));
            v.setPlateNo(rs.getString("plate_no"));
            v.setBatteryPercent(rs.getInt("battery_percent"));
            list.add(v);
        }
        return list;
 }
}
