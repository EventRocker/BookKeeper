package com.EventRock.BookKeeper.controller;

import com.EventRock.BookKeeper.dto.BookingDTO;
import com.EventRock.BookKeeper.model.Booking;
import com.EventRock.BookKeeper.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/bookings")
@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "",
            method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> index(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        List<Booking> bookings = bookingRepository.findAll();

        return bookings;
    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Booking create(@Valid @RequestBody BookingDTO request) {

        Booking booking = new Booking();

        booking.setReference("5555");
        booking.setEvent(request.getEvent());

        return bookingRepository.save(booking);
    }

}
