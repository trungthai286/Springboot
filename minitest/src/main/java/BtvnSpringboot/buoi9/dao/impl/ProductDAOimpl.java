package BtvnSpringboot.buoi9.dao.impl;

import BtvnSpringboot.buoi9.dao.ProductDAO;
import BtvnSpringboot.buoi9.database.ProductDB;
import BtvnSpringboot.buoi9.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductDAOimpl implements ProductDAO {

    @Override
    public List<Product> findAllProducts() {
        return ProductDB.products;
    }

    @Override
    public Product findIdProducts(int id) {
        return ProductDB.products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return ProductDB.products.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        product.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

}
