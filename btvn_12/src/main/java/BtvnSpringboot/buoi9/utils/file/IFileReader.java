package BtvnSpringboot.buoi9.utils.file;

import BtvnSpringboot.buoi9.model.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String filePath);
}
