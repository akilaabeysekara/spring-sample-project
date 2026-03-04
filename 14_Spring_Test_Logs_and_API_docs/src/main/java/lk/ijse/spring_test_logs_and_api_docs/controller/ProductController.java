package lk.ijse.spring_test_logs_and_api_docs.controller;

import lk.ijse.spring_test_logs_and_api_docs.entity.Product;
import lk.ijse.spring_test_logs_and_api_docs.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/product")
@Slf4j
public class ProductController {
    private final ProductService productService;
    @PostMapping("save")
    public Product save(@RequestBody Product product) {
        log.info("Saving method called in ProductController");
        log.debug("Saving product: {}", product.toString());
        log.warn("Product endpoint reached the maximum limit");
        log.trace("Entering save method with product details - tracing execution flow");
        log.error("Error occurred during saving product");
        return productService.save(product);
    }

    @GetMapping("get-all")
    public List<Product> findAll() {
        return productService.findAll();
    }
}