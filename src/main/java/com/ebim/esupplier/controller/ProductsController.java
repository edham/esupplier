
package com.ebim.esupplier.controller;

import com.ebim.esupplier.domain.Product;
import com.ebim.esupplier.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductsController extends BaseCrudController<Product, String> {
    public ProductsController(ProductRepository repo) { super(repo); }
}
