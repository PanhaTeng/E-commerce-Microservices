package com.panha.productservice.services;
import com.panha.productservice.clients.OrderClient;
import com.panha.productservice.models.Product;
import com.panha.productservice.models.dto.ProductOutFace;
import com.panha.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private  OrderClient orderClient;
    public Product save(Product product){
        return productRepository.save(product);
    }
    public Product findById(Integer id){
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> list(){
        return productRepository.findAll();
    }
    public Product update(Product product){
        var productInDb = productRepository.findById(product.getId()).orElse(null);
        productInDb.setId(product.getId());
        productInDb.setName(product.getName());
        productInDb.setPrice(product.getPrice());
        productInDb.setIsActive(product.getIsActive());
        productInDb.setOrderId(product.getOrderId());
        return productRepository.save(productInDb);
    }
    public Product delete(Product product){
        productRepository.deleteById(product.getId());
        return product;
    }
    public ProductOutFace findProductOutFaceById(Integer id){
        var product = productRepository.findById(id).orElse(null);
        var order = orderClient.findById(product.getOrderId());
        return ProductOutFace.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .isActive(product.getIsActive())
                .orderId(product.getOrderId())
                .order(order)
                .build();
    }

}
