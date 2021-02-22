package ru.dsoshnev.spring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    protected List<Product> products;

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public <S extends Product> S save(S s) {
        Optional<Product> product = findById(s.getId());
        if(product.isEmpty()) {
            products.add(s);
        } else {
            product.get().setTitle(s.getTitle());
            product.get().setCost(s.getCost());
        }
        return s;
    }


    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        for (Product product : products) {
            if(product.getId() == aLong) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        for (Product product : products) {
            if(product.getId() == aLong) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Iterable<Product> findAllById(Iterable<Long> iterable) {
        List<Product> list = new ArrayList<Product>();
        for (Long aLong : iterable) {
            Optional<Product> product = findById(aLong);
            if(!product.isEmpty()) {
                list.add(product.get());
            }
        }
        return list;
    }

    @Override
    public long count() {
        return products.size();
    }

    @Override
    public void deleteById(Long aLong) {
        for (Product product : products) {
            if(product.getId() == aLong) {
                products.remove(product);
                return;
            }
        }
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {

    }

    @Override
    public void deleteAll() {
        products.clear();
    }
}
