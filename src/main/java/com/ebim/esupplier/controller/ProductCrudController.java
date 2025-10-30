
package com.ebim.esupplier.controller;

import com.ebim.esupplier.service.IProductService;
import com.ebim.esupplier.web.dto.ProductDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductCrudController {
    private final IProductService service;
    public ProductCrudController(IProductService service) { this.service = service; }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getproduct(@PathVariable @NotNull String id) {
        return ResponseEntity.ok(service.getproduct(id));
    }

    // POST (sin valor)
    @PostMapping
    public ResponseEntity<ProductDTO> addproduct(@Valid @RequestBody ProductDTO body) {
        return ResponseEntity.ok(service.saveproduct(body));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateproduct(@PathVariable @NotNull String id,
                                              @Valid @RequestBody ProductDTO body) {
        service.updatproduct(body, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /{id} (según especificación, recibe también DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteproduct(@PathVariable @NotNull String id,
                                              @Valid @RequestBody(required = false) ProductDTO body) {
        service.deleteproduct(id);
        return ResponseEntity.noContent().build();
    }
}
