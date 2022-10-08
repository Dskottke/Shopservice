package Repos;

import Model.Order;
import Model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    @DisplayName("getOrder should return the Order by id ")
    void getOrderBy() {
        //GIVEN
        List<Product> products = new ArrayList<>(
                List.of(new Product("1","testProduct1"),
                        new Product("2","testProduct2")));

        Order testOrder = new Order("1",products);

        Map<String,Order> testOrders = new HashMap<>(Map.of(testOrder.getId(),testOrder));

        OrderRepo testOrderRepo = new OrderRepo(testOrders);
        //WHEN
        Order actual = testOrderRepo.getOrder("1");
        Order expected =testOrder;
        //THEN
        assertEquals(expected,actual);
    }

    @Test
    void addOrder() {
    }
}