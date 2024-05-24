package BtvnSpringboot.buoi9.database;

import BtvnSpringboot.buoi9.utils.file.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class initDB implements CommandLineRunner {
    @Autowired
    private IFileReader fileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Khoi tao du lieu ban dau cho ung dung");
        ProductDB.products = fileReader.readFile("products.json");
        System.out.println("So luong Product = " + ProductDB.products.size());
    }
}
