package com.photography.apptmphoto.entity.service;


import com.photography.apptmphoto.entity.reservation.ReservationItem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service", schema = "tmphotospring")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Long serviceId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "price")
    private Double price;

    @Basic(optional = true)
    @Column(name = "description")
    private String description;


@OneToMany (mappedBy = "reservation")
private List<ReservationItem> reservationItemList;

    public Service() {

    }


    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReservationItem> getReservationItemList() {
        return reservationItemList;
    }

    public void setReservationItemList(List<ReservationItem> reservationItemList) {
        this.reservationItemList = reservationItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        return serviceId != null ? serviceId.equals(service.serviceId) : service.serviceId == null;
    }

    @Override
    public int hashCode() {
        return serviceId != null ? serviceId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                '}';
    }
}
