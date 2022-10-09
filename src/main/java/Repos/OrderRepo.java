package Repos;

import Model.Order;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderRepo {

    private final Map<String, Order> orders;

    public OrderRepo(Map<String, Order> orders) {
        this.orders = orders;
    }

    public OrderRepo() {
        orders = new HashMap<>();
    }

    public Order getOrder(String id) {

        for (Map.Entry<String, Order> iterator : orders.entrySet()) {
            if (iterator.getKey().equals(id)) {
                return iterator.getValue();
            }
        }
        throw new IllegalArgumentException("no match with id");
    }

    public Order addOrder(Order order){
        orders.put(order.getId(),order);
        return order;
    }




}
