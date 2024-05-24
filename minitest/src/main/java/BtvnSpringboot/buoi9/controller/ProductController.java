package BtvnSpringboot.buoi9.controller;

import BtvnSpringboot.buoi9.PageResponseImpl;
import BtvnSpringboot.buoi9.model.PageResponse;
import BtvnSpringboot.buoi9.model.Product;
import BtvnSpringboot.buoi9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public String getAll(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "getHome";
    }

    @GetMapping("/products")
    public String getProductList(Model model,
                                 @RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "5") int pageSize) {
        PageResponse<Product> pageData = new PageResponseImpl<>(productService.getAllProducts(), page, pageSize);
        model.addAttribute("pageData", pageData);
        return "product-list";
    }

    @GetMapping("/products/{id}")
    public String getIdProducts(@PathVariable int id, Model model) {
        Product product = productService.getIdProducts(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "getId";
        }
        return null;
    }

    @GetMapping("/products/search")
    public String searchProducts(@RequestParam String keyword, Model model) {
        List<Product> products = productService.searchProductsByKeyword(keyword);
        if (products != null && !products.isEmpty()) {
            model.addAttribute("products", products);
            return "searchIdProduct";
        }
        model.addAttribute("message", "Không tìm thấy sản phẩm phù hợp");
        return "searchIdProduct";
    }

}
