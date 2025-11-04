package com.example.Vehicle.tests;

import com.example.Vehicle.model.Vehicle;
import com.example.Vehicle.service.VehicleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleServiceTest {

    @Test
    public void testCreateVehicle() throws Exception {
        VehicleService vs = new VehicleService();
        Vehicle v = new Vehicle();
        v.setModel("MG ZS EV");
        v.setPlateNo("TS08XY0001");
        v.setBatteryPercent(85);

        Vehicle saved = vs.createVehicle(v);
        Assertions.assertTrue(saved.getVehicleId() > 0);
    }
}