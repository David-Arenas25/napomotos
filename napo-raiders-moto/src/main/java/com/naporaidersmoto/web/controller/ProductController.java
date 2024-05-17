package com.naporaidersmoto.web.controller;

import com.naporaidersmoto.domain.Product;
import com.naporaidersmoto.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation("Get all products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getByName(@PathVariable("name") String productName) {
        if (productService.getByName(productName).isPresent()) {
            return ResponseEntity.of(productService.getByName(productName));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("id/{id}")
    @ApiOperation("Search product by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "product not found")
    })
    public ResponseEntity<Product> getByProductId(@ApiParam(value =  "The id of the product", required = true, example = "7")@PathVariable("id") int productId) {
        return ResponseEntity.of(productService.getByProductId(productId));
    }

    @GetMapping("/quantity/{quantity}")
    public ResponseEntity<List<Product>> findByQuantity( @PathVariable("quantity") int quantity) {
        return ResponseEntity.of(productService.findByQuantity(quantity));
    }

    @GetMapping("/{price}")
    public ResponseEntity<List<Product>> findByPrice(@PathVariable("price") double price) {
        return ResponseEntity.of(productService.findByPrice(price));
    }

    @GetMapping("/sale/{sale}")
    public ResponseEntity<List<Product>> findBySaleId(@PathVariable("sale") int saleID) {
        return ResponseEntity.of(productService.findBySaleId(saleID));
    }

    @GetMapping("/supplier/{supplier}")
    public ResponseEntity<List<Product>> findBySupplierId(@PathVariable("supplier") int supplierId) {
        return ResponseEntity.of(productService.findBySupplierId(supplierId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
