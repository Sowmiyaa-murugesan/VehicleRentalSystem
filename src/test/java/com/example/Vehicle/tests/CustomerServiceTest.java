package com.example.Vehicle.tests;

import com.example.Vehicle.model.Customer;
import com.example.Vehicle.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerServiceTest {

    @Test
    public void testCreateCustomer() throws Exception {
        CustomerService cs = new CustomerService();
        Customer c = new Customer();
        c.setName("TestUser");
        c.setEmail("testuser@gmail.com");
        c.setPhone("1111111111");

        Customer saved = cs.createCustomer(c);
        Assertions.assertTrue(saved.getCustomerId() > 0);
    }
}