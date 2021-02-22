package ru.dsoshnev.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class ProductDBRepository extends ProductRepositoryImpl {

    @PostConstruct
    public void init() {
        products = new ArrayList<Product>();
    }

}
