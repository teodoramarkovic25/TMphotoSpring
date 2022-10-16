package com.photography.apptmphoto.controller.service;


import com.photography.apptmphoto.entity.service.Service;
import com.photography.apptmphoto.entity.user.User;
import com.photography.apptmphoto.service.usluge.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class ServiceController {

    @Autowired
    private ServiceCrud serviceCrud;

    @GetMapping(path="/services")
    public String getAllServices(Model model) {
        List<Service> services = serviceCrud.getAllServices();
        model.addAttribute("ponude", services);
        return "services";
    }

   /* @GetMapping("/addService")
    public String showAddProductForm(Model model) {
        Service service = new Service();
        model.addAttribute("service", service);
        return "add_service";
    }


    @PostMapping("/saveService")
    public String saveProduct(@ModelAttribute("service") Service service) {
        serviceCrud.saveService(service);
        return "redirect:/services";
    }

    */


}
