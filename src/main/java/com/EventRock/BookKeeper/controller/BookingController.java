package com.EventRock.BookKeeper.controller;

import com.EventRock.BookKeeper.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/bookings")
@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    
}
