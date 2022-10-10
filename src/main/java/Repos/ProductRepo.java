package Repos;

import Model.Product;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductRepo {

    //DECLARATION
    private List<Product> products;

    //CONSTRUCTOR
    public ProductRepo(List<Product> productList) {

        this.products = productList;
    }
    public ProductRepo() {
        this.products = products;
    }

    //METHODS
    public List<Product> listProducts() {
        return products;
    }

    public Optional<Product> getProduct(String id) {
        Optional optional = Optional.ofNullable(products.contains(id));

        if (optional.isPresent()) {
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    return Optional.of(product);
                }
            }
        }
        return Optional.empty();
    }

}
