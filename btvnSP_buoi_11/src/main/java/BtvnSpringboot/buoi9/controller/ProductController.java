package BtvnSpringboot.buoi9.controller;

import BtvnSpringboot.buoi9.model.Product;
import BtvnSpringboot.buoi9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getIdProducts(@PathVariable int id) {
        Product product = productService.getIdProducts(id);
        if (product.getId() == id) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name-starts/{prefix}")
    public ResponseEntity<List<Product>> getPrefixProducts(@PathVariable String prefix) {
        List<Product> result = new ArrayList<>();
        for (Product product : productService.getPrefixProducts(prefix)) {
            if (product.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/price/{min}/{max}")
    public ResponseEntity<List<Product>> getPriceProducts(@PathVariable int min, @PathVariable int max) {
        List<Product> result = new ArrayList<>();
        for (Product product : productService.getPriceProducts(min, max)) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/brand/{brand}")
    ResponseEntity<List<Product>> getBrandProducts(@PathVariable String brand) {
        List<Product> result = new ArrayList<>();
        for (Product product : productService.getBrandProducts(brand)) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/brand/{brand}/max-price")
    public ResponseEntity<Product> getMaxPriceProducts(@PathVariable String brand) {
        Product product = productService.getMaxPriceProducts(brand);
        return ResponseEntity.ok(product);
    }
}
