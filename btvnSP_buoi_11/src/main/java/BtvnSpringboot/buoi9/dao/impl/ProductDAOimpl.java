package BtvnSpringboot.buoi9.dao.impl;

import BtvnSpringboot.buoi9.dao.ProductDAO;
import BtvnSpringboot.buoi9.database.ProductDB;
import BtvnSpringboot.buoi9.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class ProductDAOimpl implements ProductDAO {

    @Override
    public List<Product> findAllProducts() {
        return ProductDB.products;
    }

    @Override
    public Product findIdProducts(int id) {
        for (Product product : ProductDB.products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findPrefixProducts(String Prefix) {
        List<Product> result = new ArrayList<>();
        for (Product product : ProductDB.products) {
            if (product.getName().toLowerCase().startsWith(Prefix.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> findPriceProducts(int min, int max) {
        List<Product> result = new ArrayList<>();
        for (Product product : ProductDB.products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> findBrandProducts(String brand) {
        List<Product> result = new ArrayList<>();
        for (Product product : ProductDB.products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Product findMaxPriceProducts(String brand) {
        ProductDB.products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        for (Product product : ProductDB.products) {
            if (product.getBrand().toLowerCase().equals(brand.toLowerCase())) {
                return product;
            }
        }
        return null;
    }
}
