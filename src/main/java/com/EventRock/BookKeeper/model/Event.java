package com.EventRock.BookKeeper.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalTime;

@Embeddable
public class Event {

    @Column(length = 64, name = "event_name")
    private String name;

    @Column(length = 255, name = "event_description")
    private String description;

    @Column(length = 255, name = "event_place")
    private String place;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "event_start_time")
    private LocalTime startTime;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "event_end_time")
    private LocalTime endTime;
}
