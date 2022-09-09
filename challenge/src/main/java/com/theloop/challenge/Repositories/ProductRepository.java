package com.theloop.challenge.Repositories;

import com.theloop.challenge.Models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
