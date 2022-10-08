package Repos;

import Model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    @DisplayName("getProduct should return matching product by ID ")
    public void getProductById(){
        //GIVEN
        List<Product> products = new ArrayList<>(List.of(
                new Product("1","apfel"),
                new Product("2","banane")));

        ProductRepo productRepo = new ProductRepo(products);

        //WHEN
        Optional <Product> actual = productRepo.getProduct("1");
        Product expected = products.get(0);
        //THEN
        assertEquals(expected,actual.get());
    }


}