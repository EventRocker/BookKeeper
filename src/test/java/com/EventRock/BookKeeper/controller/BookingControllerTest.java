package com.EventRock.BookKeeper.controller;

import com.EventRock.BookKeeper.dto.BookingDTO;
import com.EventRock.BookKeeper.model.Booking;
import com.EventRock.BookKeeper.model.Event;
import com.EventRock.BookKeeper.repository.BookingRepository;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingController bookingController= new BookingController();;
    private BookingDTO bookingDTO;
    private Booking booking1;
    private Booking booking2;

    @Before
    public void setUp() throws Exception {

        booking1 = new Booking();
        booking1.setId(1L);
        booking1.setReference("111");
        booking2 = new Booking();
        booking2.setId(2L);
        booking2.setReference("111");

        List<Booking> bookingArrayList = new ArrayList<>();
        bookingArrayList.add(booking1);
        bookingArrayList.add(booking2);

        when(bookingRepository.findAll()).thenReturn(bookingArrayList);

        bookingDTO = new BookingDTO();
        bookingDTO.setEvent(new Event());
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking1);
    }

    @Test
    public void index_whenNoParam_ShouldReturnListOfBooking() throws Exception {
        List<Booking> reposeBody = bookingController.index("");

        assertThat(reposeBody, (Matcher) hasItems(booking1));
    }

    @Test
    public void create_whenSuccess_shouldReturnBooking() throws Exception {
        Booking responseBody = bookingController.create(bookingDTO);

        assertThat(responseBody, is(booking1));
    }
}