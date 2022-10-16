package com.photography.apptmphoto.service.reservation;


import com.photography.apptmphoto.entity.reservation.Reservation;
import com.photography.apptmphoto.entity.reservation.ReservationItem;
import com.photography.apptmphoto.entity.reservation.ReservationItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationItemService {

    @Autowired
    private ReservationItemRepository reservationItemRepository;

    public List<ReservationItem> findReservationItemsByReservation(Reservation reservation){
        return reservationItemRepository.findReservationItemsByReservation(reservation);
    }

    public List<ReservationItem> showAllReservationItems(){
        return reservationItemRepository.findAll();
    }
}
