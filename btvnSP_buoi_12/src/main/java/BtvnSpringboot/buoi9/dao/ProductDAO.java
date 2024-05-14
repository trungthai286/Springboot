package BtvnSpringboot.buoi9.dao;

import BtvnSpringboot.buoi9.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAllProducts();

    //1. Lấy thông tin chi tiết của một sản phẩm
    Product findIdProducts(int id);

    //2. Lấy sản phẩm với tên bắt đầu bằng prefix nào đó
    List<Product> findPrefixProducts(String Prefix);

    //3. Lọc sản phẩm theo khoảng giá
    List<Product> findPriceProducts(int min, int max);

    //4. Lấy sản phẩm theo thương hiệu
    List<Product> findBrandProducts(String brand);

    //5. Lấy sản phẩm có giá cao nhất theo brand
    Product findMaxPriceProducts(String brand);

}
