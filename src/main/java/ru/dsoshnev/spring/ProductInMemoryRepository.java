package ru.dsoshnev.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class ProductInMemoryRepository extends ProductRepositoryImpl {

    @PostConstruct
    public void init() {
        products = new ArrayList<Product>();
        products.add(new Product(1L,"product1",10D));
        products.add(new Product(2L,"product2",20D));
        products.add(new Product(3L,"product3",30D));
    }

}
