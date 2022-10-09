package Shop;

import Model.Order;
import Model.Product;
import Repos.OrderRepo;
import Repos.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShopService {
    //DECLARATION
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    //CONSTRUCTOR
    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }
    //METHODS
    public Product getProduct(String id) {
        Optional<Product> product = productRepo.getProduct(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new NoProductFoundException();
        }
    }

    public List<Product> listProduct() {
        return productRepo.listProducts();
    }

    public Order orderProducts(List<String> productKeys) {

        List<Product> productsToOrder = new ArrayList<>();

        for (String key : productKeys) {

            Product product = getProduct(key);
            productsToOrder.add(product);

        }

        String id = UUID.randomUUID().toString();

        return orderRepo.addOrder(new Order(id, productsToOrder));
    }


}
