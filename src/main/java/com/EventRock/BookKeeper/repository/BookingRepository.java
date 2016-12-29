package com.EventRock.BookKeeper.repository;

import com.EventRock.BookKeeper.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Long> {
}
