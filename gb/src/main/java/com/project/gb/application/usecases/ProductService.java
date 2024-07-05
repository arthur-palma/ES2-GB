package com.project.gb.application.usecases;

import com.project.gb.application.dto.ProductDTO;
import com.project.gb.application.mappers.ProductMapper;
import com.project.gb.application.port.ProductRepository;
import com.project.gb.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.project.gb.application.mappers.ProductMapper.mapToDTO;
import static com.project.gb.application.mappers.ProductMapper.toEntity;


@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<ProductDTO> getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.map(p -> ResponseEntity.ok(mapToDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> dtos = products.stream()
                .map(ProductMapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<ProductDTO> saveProduct(ProductDTO productDTO) {
        Product product = toEntity(productDTO);

        Product savedProduct = productRepository.save(product);
        ProductDTO dto = mapToDTO(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    public ResponseEntity<Void> deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
