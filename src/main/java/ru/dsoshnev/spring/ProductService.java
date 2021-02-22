package ru.dsoshnev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ProductService {

    private ProductRepositoryImpl productRepository;

    @Autowired
    @Qualifier("productInMemoryRepository")
    public void setProductRepository(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long Id) {
        return productRepository.findById(Id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Iterable<Product> findAllById(Iterable<Long> iterable) {
        return productRepository.findAllById(iterable);
    }

    public long calculateCount() {
        return productRepository.count();
    }

    public double calculateAverageCost() {
        if(calculateCount() > 0) {
            return (productRepository.getProducts()
                    .stream()
                    .mapToDouble(Product::getCost)
                    .average()
                    .getAsDouble());
        } else {
            return 0D;
        }
    }
}
