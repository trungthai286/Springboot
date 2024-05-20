package BtvnSpringboot.buoi9.dao;

import BtvnSpringboot.buoi9.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAllProducts();

    //1. Lấy thông tin chi tiết của một sản phẩm
    Product findIdProducts(int id);

    List<Product> searchProducts(String keyword);
}
