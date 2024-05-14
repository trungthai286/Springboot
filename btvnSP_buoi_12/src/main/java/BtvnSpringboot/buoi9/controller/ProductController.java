package BtvnSpringboot.buoi9.controller;

import BtvnSpringboot.buoi9.model.Product;
import BtvnSpringboot.buoi9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //    @GetMapping()
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> products = productService.getAllProducts();
//        return new ResponseEntity<>(products, HttpStatus.CREATED);
//    }
    @GetMapping()
    public String getAll(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "getAll";
    }

    //    @GetMapping("/{id}")
//    public ResponseEntity<Product> getIdProducts(@PathVariable int id) {
//        Product product = productService.getIdProducts(id);
//        if (product.getId() == id) {
//            return new ResponseEntity<>(product, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    @GetMapping("/{id}")
    public String getIdProducts(@PathVariable int id, Model model) {
        Product product = productService.getIdProducts(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "getId";
        }
        return null;
    }

    //    @GetMapping("/name-starts/{prefix}")
//    public ResponseEntity<List<Product>> getPrefixProducts(@PathVariable String prefix) {
//        List<Product> result = productService.getPrefixProducts(prefix);
//        return ResponseEntity.ok(result);
//    }
    @GetMapping("/name-starts/{prefix}")
    public String getPrefixProducts(@PathVariable String prefix, Model model) {
        List<Product> products = productService.getPrefixProducts(prefix);
        model.addAttribute("products", products);
        return "getPrefix";
    }

    //    @GetMapping("/price/{min}/{max}")
//    public ResponseEntity<List<Product>> getPriceProducts(@PathVariable int min, @PathVariable int max) {
//        List<Product> result = productService.getPriceProducts(min, max);
//        return ResponseEntity.ok(result);
//    }
    @GetMapping("/price/{min}/{max}")
    public String getPriceProducts(@PathVariable int min, @PathVariable int max, Model model) {
        List<Product> products = productService.getPriceProducts(min, max);
        model.addAttribute("products", products);
        return "getMinMax";
    }

    //    @GetMapping("/brand/{brand}")
//    public ResponseEntity<List<Product>> getBrandProducts(@PathVariable String brand) {
//        List<Product> result = productService.getBrandProducts(brand);
//        return ResponseEntity.ok(result);
//    }
    @GetMapping("/brand/{brand}")
    public String getBrandProducts(@PathVariable String brand, Model model) {
        List<Product> products = productService.getBrandProducts(brand);
        model.addAttribute("products", products);
        return "getBrand";
    }

    //    @GetMapping("/brand/{brand}/max-price")
//    public ResponseEntity<Product> getMaxPriceProducts(@PathVariable String brand) {
//        Product product = productService.getMaxPriceProducts(brand);
//        return ResponseEntity.ok(product);
//    }
    @GetMapping("/brand/{brand}/max-price")
    public String getMaxPriceProducts(@PathVariable String brand, Model model) {
        Product product = productService.getMaxPriceProducts(brand);
        model.addAttribute("product", product);
        return "getMaxPrice";
    }
}
