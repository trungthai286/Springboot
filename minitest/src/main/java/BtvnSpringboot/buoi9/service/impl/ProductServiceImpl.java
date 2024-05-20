package BtvnSpringboot.buoi9.service.impl;

import BtvnSpringboot.buoi9.dao.ProductDAO;
import BtvnSpringboot.buoi9.database.ProductDB;
import BtvnSpringboot.buoi9.model.Product;
import BtvnSpringboot.buoi9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return productDAO.findAllProducts();
    }

    @Override
    public Product getIdProducts(int id) {
        return productDAO.findIdProducts(id);
    }

    @Override
    public List<Product> searchProductsByKeyword(String keyword) {
//        return ProductDB.products.stream()
//                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
//                        product.getDescription().toLowerCase().contains(keyword.toLowerCase()))
//                .collect(Collectors.toList());
        return productDAO.searchProducts(keyword);
    }


}
