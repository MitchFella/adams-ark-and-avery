package org.adamsArkAndAvery.web;

import org.adamsArkAndAvery.model.Service;
import org.adamsArkAndAvery.service.serviceService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "serviceBean")
@ViewScoped
public class ServiceBean implements Serializable {

    private List<Service> allServices;
    private serviceService serviceService;

    public ServiceBean() {
        serviceService = new serviceService();
        allServices = serviceService.getAllAvailableServices();
    }

    public List<Service> getAllServices() {
        return allServices;
    }

    public void setAllServices(List<Service> allServices) {
        this.allServices = allServices;
    }
}