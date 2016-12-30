package com.EventRock.BookKeeper.dto;

import com.EventRock.BookKeeper.model.Event;

import javax.validation.constraints.NotNull;

/**
 * Created by peerapat on 30/12/2016.
 */
public class BookingDTO {

    @NotNull
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
