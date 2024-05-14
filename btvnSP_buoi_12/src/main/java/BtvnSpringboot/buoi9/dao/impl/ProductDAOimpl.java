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

    //    @Override
//    public Product findIdProducts(int id) {
//        for (Product product : ProductDB.products) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
//        return null;
//    }
    @Override
    public Product findIdProducts(int id) {
        return ProductDB.products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //    @Override
//    public List<Product> findPrefixProducts(String Prefix) {
//        List<Product> result = new ArrayList<>();
//        for (Product product : ProductDB.products) {
//            if (product.getName().toLowerCase().startsWith(Prefix.toLowerCase())) {
//                result.add(product);
//            }
//        }
//        return result;
//    }
    @Override
    public List<Product> findPrefixProducts(String Prefix) {
        return ProductDB.products.stream()
                .filter(product -> product.getName().toLowerCase().startsWith(Prefix.toLowerCase()))
                .toList();
    }

    //    @Override
//    public List<Product> findPriceProducts(int min, int max) {
//        List<Product> result = new ArrayList<>();
//        for (Product product : ProductDB.products) {
//            if (product.getPrice() >= min && product.getPrice() <= max) {
//                result.add(product);
//            }
//        }
//        return result;
//    }

    @Override
    public List<Product> findPriceProducts(int min, int max) {
        return ProductDB.products.stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                .toList();
    }
    //    @Override
//    public List<Product> findBrandProducts(String brand) {
//        List<Product> result = new ArrayList<>();
//        for (Product product : ProductDB.products) {
//            if (product.getBrand().equalsIgnoreCase(brand)) {
//                result.add(product);
//            }
//        }
//        return result;
//    }

    @Override
    public List<Product> findBrandProducts(String brand) {
        List<Product> result = ProductDB.products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .toList();
        return result;
    }

    //        @Override
//    public Product findMaxPriceProducts(String brand) {
//        ProductDB.products.sort(new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return o2.getPrice() - o1.getPrice();
//            }
//        });
//        for (Product product : ProductDB.products) {
//            if (product.getBrand().equalsIgnoreCase(brand)) {
//                return product;
//            }
//        }
//        return null;
//    }

    @Override
    public Product findMaxPriceProducts(String brand) {

        return ProductDB.products.stream()
                .sorted((o1, o2) -> o2.getPrice() - o1.getPrice())
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .findFirst()
                .orElse(null);
    }
}
