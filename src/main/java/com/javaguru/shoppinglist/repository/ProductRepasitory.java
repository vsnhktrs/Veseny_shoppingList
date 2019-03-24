package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import java.util.Optional;

public interface ProductRepasitory {

    Long add(Product product);

    Optional<Product> findby(Long id);

}
