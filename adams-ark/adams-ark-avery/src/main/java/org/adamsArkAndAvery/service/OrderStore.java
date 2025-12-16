package org.adamsArkAndAvery.service;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.adamsArkAndAvery.model.Order;

@ManagedBean(name = "orderStore")
@ApplicationScoped
public class OrderStore {
	private List<Order> orderList = new ArrayList<>();
	
	public void addOrder(Order order) {
        orderList.add(order);
        System.out.println("Order added for: " + order.getBooking().getPetName());
    }

    public List<Order> getAllOrders() {
        return orderList;
    }
}
