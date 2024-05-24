package BtvnSpringboot.buoi9.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private String brand;


}
