package com.photography.apptmphoto.service.reservation;


import com.photography.apptmphoto.entity.reservation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationItemService reservationItemService;

    @Autowired
    private ReservationItemRepository reservationItemRepository;

    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public ReservationItem saveReservationItem(Reservation reservation, com.photography.apptmphoto.entity.service.Service service){
        ReservationItemKey reservationItemKey = new ReservationItemKey();
        reservationItemKey.setReservationId(reservation.getReservationId());
        reservationItemKey.setServiceId(service.getServiceId());
        ReservationItem reservationItem = new ReservationItem();
        reservationItem.setId(reservationItemKey);
        reservationItem.setReservation(reservation);
        reservationItem.setService(service);
        return reservationItemRepository.save(reservationItem);
    }
}
