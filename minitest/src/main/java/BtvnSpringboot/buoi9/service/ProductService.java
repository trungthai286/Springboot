package BtvnSpringboot.buoi9.service;

import BtvnSpringboot.buoi9.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    //1. Lấy thông tin chi tiết của một sản phẩm
    Product getIdProducts(int id);

    List<Product> searchProductsByKeyword(String keyword);

}
