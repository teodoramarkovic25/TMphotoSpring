package com.photography.apptmphoto.controller.reservation;


import com.photography.apptmphoto.entity.reservation.ReservationItem;
import com.photography.apptmphoto.service.reservation.ReservationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReservationItemController {

    @Autowired
    private ReservationItemService reservationItemService;

    @GetMapping("/reservationItems")
    public String allReservationItems(Model model){
        List<ReservationItem> orderItems = reservationItemService.showAllReservationItems();
        model.addAttribute("reservation", reservationItemService);
        return "reservation_item";
    }
}
