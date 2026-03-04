package lk.ijse.spring_test_logs_and_api_docs.service;

import lk.ijse.spring_test_logs_and_api_docs.entity.Product;
import lk.ijse.spring_test_logs_and_api_docs.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
