import Model.Order;
import Model.Product;
import Repos.OrderRepo;
import Repos.ProductRepo;
import Shop.ShopService;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

                Product product = new Product("1","apfel");
                Order order = new Order("1",List.of(product));
                ProductRepo productRepo = new ProductRepo(List.of(product));
                OrderRepo orderRepo = new OrderRepo(Map.of(order.getId(), order));
                ShopService shopService = new ShopService(orderRepo,productRepo);


        System.out.println(shopService.listProduct());


    }


}
