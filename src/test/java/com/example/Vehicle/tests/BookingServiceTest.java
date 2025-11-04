package com.example.Vehicle.tests;

import com.example.Vehicle.model.Booking;
import com.example.Vehicle.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookingServiceTest {

    @Test
    public void testCreateBooking() throws Exception {
        BookingService bs = new BookingService();

        Booking b = new Booking();
        b.setCustomerId(1);
        b.setVehicleId(1);
        b.setBookingDate("2025-01-01");

        Booking saved = bs.createBooking(b);
        Assertions.assertTrue(saved.getBookingId() > 0);
    }
}
