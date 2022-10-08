package Shop;

import Model.Order;
import Model.Product;
import Repos.OrderRepo;
import Repos.ProductRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    @DisplayName("shopservice getProduct should match with productRepo getProduct")
    void getProductbyId(){
        //GIVEN
        List<Product> productList = new ArrayList<>(
                List.of(new Product("1","testProduct1"),
                        new Product("2","testProduct2")));

        ProductRepo productRepo = new ProductRepo(productList);
        Order testOrder = new Order("1",productList);

        Map<String,Order> ordersMap = new HashMap<>(Map.of(testOrder.getId(),testOrder));
        OrderRepo testOrderRepo = new OrderRepo(ordersMap);

        ShopService shopService = new ShopService(testOrderRepo,productRepo);

        //WHEN
        Product actual = shopService.getProduct("1");
        Product expected =productRepo.getProduct("1").get();

        //THEN
        assertEquals(expected,actual);

    }

}