package com.company.helper;

import java.util.ArrayList;

public class Orders {
    ArrayList<Order> Orders = new ArrayList<>();

    public void addOrder(Order order){
        this.Orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    public Order getOrder(int orderId) {
        for(int i = 0; i < Orders.size(); i++) {
            if (Orders.get(i).getOrderId() == orderId) {
                return Orders.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        return Orders.size();
    }

}
