package Shop;

import Model.Product;
import Repos.OrderRepo;
import Repos.ProductRepo;

import java.util.List;
import java.util.Optional;

public class ShopService {
   private final OrderRepo orderRepo;
   private final ProductRepo productRepo;

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }
    public Product getProduct(String id){
       Optional<Product> chooseableProduct = productRepo.getProduct(id);

       if(chooseableProduct.isPresent()){
           return chooseableProduct.get();
       }
       else{
           throw new NoProductFoundException();
       }
    }


}
