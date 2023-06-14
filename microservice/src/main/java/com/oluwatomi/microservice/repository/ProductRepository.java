package com.oluwatomi.microservice.repository;

import com.oluwatomi.microservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
