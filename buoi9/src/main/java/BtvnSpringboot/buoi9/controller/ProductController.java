package BtvnSpringboot.buoi9.controller;

import BtvnSpringboot.buoi9.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> products;

    public ProductController() {
        products = new ArrayList<>();
        products.add(new Product(01, "iphone 15", "newIphone", 900, "Apple"));
        products.add(new Product(02, "Samsung note 14", "newSam", 900, "Samsung"));
        products.add(new Product(03, "Xiaomi 14 pro", "newXiaomi", 650, "Xiaomi"));
        products.add(new Product(04, "Huwei P60", "newHuwei", 800, "Huwei"));
        products.add(new Product(05, "Oppo Reno 6", "newOppo", 750, "Oppo"));
        products.add(new Product(06, "Redmi note 10 pro", "newRedmi", 450, "Xiaomi"));

    }
    @GetMapping("/products") //hhtp:// localhost:8082/products
    public List<Product>getAllProducts(){
        return products;
    }
}
