package com.photography.apptmphoto.entity.reservation;


import com.photography.apptmphoto.entity.service.Service;

import javax.persistence.*;

@Entity
@Table(name = "reservation_items")
public class ReservationItem {

    @EmbeddedId
    private ReservationItemKey id;

    @ManyToOne
    @MapsId("reservationId")
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Service service;

    public ReservationItemKey getId() {
        return id;
    }

    public void setId(ReservationItemKey id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString(){
        return reservation + " " + service;
    }
}

