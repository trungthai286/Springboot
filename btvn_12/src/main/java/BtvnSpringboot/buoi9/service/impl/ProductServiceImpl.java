package BtvnSpringboot.buoi9.service.impl;

import BtvnSpringboot.buoi9.dao.ProductDAO;
import BtvnSpringboot.buoi9.model.Product;
import BtvnSpringboot.buoi9.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Product> getPrefixProducts(String Prefix) {
        return productDAO.findPrefixProducts(Prefix);
    }

    @Override
    public List<Product> getPriceProducts(int min, int max) {
        return productDAO.findPriceProducts(min, max);
    }

    @Override
    public List<Product> getBrandProducts(String brand) {
        return productDAO.findBrandProducts(brand);
    }

    @Override
    public Product getMaxPriceProducts(String brand) {
        return productDAO.findMaxPriceProducts(brand);
    }
}
