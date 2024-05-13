package BtvnSpringboot.buoi9.service;

import BtvnSpringboot.buoi9.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    //1. Lấy thông tin chi tiết của một sản phẩm
    Product getIdProducts(int id);

    //2. Lấy sản phẩm với tên bắt đầu bằng prefix nào đó
    List<Product> getPrefixProducts(String Prefix);

    //3. Lọc sản phẩm theo khoảng giá
    List<Product> getPriceProducts(int min, int max);

    //4. Lấy sản phẩm theo thương hiệu
    List<Product> getBrandProducts(String brand);

    //5. Lấy sản phẩm có giá cao nhất theo brand
    Product getMaxPriceProducts(String brand);

}
