package com.photography.apptmphoto.entity.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {
    List<ReservationItem>  findReservationItemsByReservation(Reservation reservation);
}
