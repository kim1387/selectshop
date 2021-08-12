package com.example.selectshop.controller;


import com.example.selectshop.models.Product;
import com.example.selectshop.dto.ProductMypriceRequestDto;
import com.example.selectshop.models.ProductRepository;
import com.example.selectshop.dto.ProductRequestDto;
import com.example.selectshop.service.ProductService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"REST API CONTROLLER"})
@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // 신규 상품 등록 -> 원하는 상품 등록하면 DB에 해당 친구 저장해야함
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        productRepository.save(product);
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.update(id, requestDto);
    }
}