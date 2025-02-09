package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
}
