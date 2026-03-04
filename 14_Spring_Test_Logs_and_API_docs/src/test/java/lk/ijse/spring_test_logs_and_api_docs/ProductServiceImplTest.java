package lk.ijse.spring_test_logs_and_api_docs;

import lk.ijse.spring_test_logs_and_api_docs.entity.Product;
import lk.ijse.spring_test_logs_and_api_docs.repo.ProductRepo;
import lk.ijse.spring_test_logs_and_api_docs.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    private Product product;

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        product = Product.builder().id(1).name("test-name").dec("test-dec").build();
    }

    @Test
    public void saveProduct() {
        //arrange
        when(productRepo.save(any(Product.class))).thenReturn(product);
        //act
        Product savedProduct = productService.save(product);
        //assert
        assertNotNull(savedProduct);
        assertEquals(1, savedProduct.getId());
        assertEquals("test-name", savedProduct.getName());
        assertEquals("test-dec", savedProduct.getDec());
    }
}