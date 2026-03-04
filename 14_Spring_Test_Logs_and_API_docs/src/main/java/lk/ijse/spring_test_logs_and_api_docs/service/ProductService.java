package lk.ijse.spring_test_logs_and_api_docs.service;


import lk.ijse.spring_test_logs_and_api_docs.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
}
