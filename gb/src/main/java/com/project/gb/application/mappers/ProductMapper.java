package com.project.gb.application.mappers;

import com.project.gb.application.dto.ProductDTO;
import com.project.gb.domain.entity.Product;

public class ProductMapper {

    public static ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductName(product.getProductName());
        dto.setSupplierID(product.getSupplierID());
        dto.setCategoryID(product.getCategoryID());
        dto.setQuantityPerUnit(product.getQuantityPerUnit());
        dto.setUnitPrice(product.getUnitPrice());
        dto.setUnitsInStock(product.getUnitsInStock());
        dto.setUnitsOnOrder(product.getUnitsOnOrder());
        dto.setReorderLevel(product.getReorderLevel());
        dto.setDiscontinued(product.getDiscontinued());
        return dto;
    }

    public static Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setSupplierID(dto.getSupplierID());
        product.setCategoryID(dto.getCategoryID());
        product.setQuantityPerUnit(dto.getQuantityPerUnit());
        product.setUnitPrice(dto.getUnitPrice());
        product.setUnitsInStock(dto.getUnitsInStock());
        product.setUnitsOnOrder(dto.getUnitsOnOrder());
        product.setReorderLevel(dto.getReorderLevel());
        product.setDiscontinued(dto.getDiscontinued());
        return product;
    }
}
