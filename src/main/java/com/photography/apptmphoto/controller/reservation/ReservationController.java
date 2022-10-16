package com.photography.apptmphoto.controller.reservation;


import com.photography.apptmphoto.entity.reservation.Reservation;
import com.photography.apptmphoto.entity.reservation.ReservationItem;
import com.photography.apptmphoto.entity.service.Service;
import com.photography.apptmphoto.service.reservation.ReservationItemService;
import com.photography.apptmphoto.service.reservation.ReservationService;
import com.photography.apptmphoto.service.usluge.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationItemService reservationItemService;

    @Autowired
    private ServiceCrud serviceCrud;

    @GetMapping("/reservation")
    public String showAddReservationForm(Model model){
        List<Service> products = serviceCrud.getAllServices();
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        model.addAttribute("services", serviceCrud);
        return "reservation_service";
    }

    @GetMapping(path="/zakazitetermin")
    public String getAllServices(Model model) {

        return "zakazitermin";
    }

    @PostMapping("/saveReservaton")
    public String saveReservation(Model model, @ModelAttribute("reservation") Reservation reservation, HttpServletRequest request){
        String ponuda = request.getParameter("ponude");
        long serviceId = Long.parseLong(ponuda);
      Service service = (Service) serviceCrud.getById(serviceId);
        if (reservation.getReservationId() == null){
            reservation = reservationService.saveReservation(reservation);
        }
        reservationService.saveReservationItem(reservation, service);
        List<ReservationItem> reservationItems = reservationItemService.findReservationItemsByReservation(reservation);
        model.addAttribute("reservationItems", reservationItems);
        model.addAttribute("reservation", reservation);
        List<Service> services = serviceCrud.getAllServices();
        model.addAttribute("services", services);
        return "reservation_service";
    }
}
