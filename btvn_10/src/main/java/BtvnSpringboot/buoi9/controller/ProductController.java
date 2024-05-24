package BtvnSpringboot.buoi9.controller;

import BtvnSpringboot.buoi9.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products;

    public ProductController() {
        products = new ArrayList<>();
        products.add(new Product(1, "iphone 15", "newIphone", 1100, "Apple"));
        products.add(new Product(2, "iphone 14", "Iphone 14 series", 1000, "Apple"));
        products.add(new Product(3, "iphone 13", "Iphone 13 series", 900, "Apple"));
        products.add(new Product(4, "Samsung S14 Ultra", "newSam", 900, "Samsung"));
        products.add(new Product(5, "Xiaomi 14 pro", "newXiaomi", 650, "Xiaomi"));
        products.add(new Product(6, "Huwei P60", "newHuwei", 800, "Huwei"));
        products.add(new Product(7, "Oppo Reno 6", "newOppo", 750, "Oppo"));
        products.add(new Product(8, "Redmi note 10 pro", "newRedmi", 450, "Xiaomi"));
    }

    @GetMapping  // hhtp://localhost:8085/products
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }

    /*1. Lấy thông tin chi tiết của một sản phẩm
        API: GET /products/{id}
        Mô tả: Trả về chi tiết của sản phẩm dựa trên id được cung cấp.*/

    @GetMapping("/{id}")
    public ResponseEntity<Product> getIdProducts(@PathVariable int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /*2. Lấy sản phẩm với tên bắt đầu bằng prefix nào đó
    API: GET /products/name-starts/{prefix}
    Mô tả: Trả về danh sách sản phẩm có tên bắt đầu bằng nào đó.*/

    @GetMapping("/name-starts/{prefix}")
    public ResponseEntity<List<Product>> getPrefixProducts(@PathVariable String prefix) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result);
    }

    /*3. Lọc sản phẩm theo khoảng giá
    API: GET /products/price/{min}/{max}
    Mô tả: Trả về danh sách sản phẩm có giá nằm trong khoảng từ min đến max.*/

    @GetMapping("/price/{min}/{max}")
    public ResponseEntity<List<Product>> getPriceProducts(@PathVariable int min, @PathVariable int max) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result);
    }

    /*4. Lấy sản phẩm theo thương hiệu
    API: GET /products/brand/{brand}
    Mô tả: Trả về danh sách sản phẩm thuộc thương hiệu được chỉ định.*/

    @GetMapping("/brand/{brand}")
    ResponseEntity<List<Product>> getBrandProducts(@PathVariable String brand) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result);
    }

    /*5. Lấy sản phẩm có giá cao nhất
    API: GET /products/brand/{brand}/max-price
    Mô tả: Trả về sản phẩm có giá cao nhất theo brand được chỉ định.*/

    @GetMapping("/brand/{brand}/max-price")
    public ResponseEntity<Product> getMaxPriceProducts(@PathVariable String brand) {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
