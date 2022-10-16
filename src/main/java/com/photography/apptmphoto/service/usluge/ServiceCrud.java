package com.photography.apptmphoto.service.usluge;



import com.photography.apptmphoto.entity.service.Service;
import com.photography.apptmphoto.entity.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class ServiceCrud {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }

    public org.springframework.stereotype.Service getById(long id){
        return (org.springframework.stereotype.Service) serviceRepository.findById(id).orElse(null);
    }

    public void saveService(com.photography.apptmphoto.entity.service.Service service){
        serviceRepository.save(service);
    }
}