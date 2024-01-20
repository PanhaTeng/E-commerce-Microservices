package com.panha.productservice.controllers;
import com.panha.productservice.models.Product;
import com.panha.productservice.models.dto.ProductOutFace;
import com.panha.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;
    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id){
        return productService.findById(id);
    }
    @GetMapping
    public List<Product> list(){
        return productService.list();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product updateProduct( @RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping
    public Product deleteProduct(@RequestBody Product product) {
       return productService.delete(product);
    }

    @GetMapping("/with-order/{productId}")
    public ProductOutFace findByProductOuFaceId(@PathVariable("productId") Integer id){
        return productService.findProductOutFaceById(id);
    }

}
