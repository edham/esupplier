
package com.ebim.esupplier.controller;

import com.ebim.esupplier.service.ICatalogItemService;
import com.ebim.esupplier.web.dto.CatalogItemDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalogItem")
public class CatalogItemCrudController {
    private final ICatalogItemService service;
    public CatalogItemCrudController(ICatalogItemService service) { this.service = service; }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<CatalogItemDTO> getcatalogItem(@PathVariable @NotNull String id) {
        return ResponseEntity.ok(service.getcatalogItem(id));
    }

    // POST (sin valor)
    @PostMapping
    public ResponseEntity<CatalogItemDTO> addcatalogItem(@Valid @RequestBody CatalogItemDTO body) {
        return ResponseEntity.ok(service.savecatalogItem(body));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatecatalogItem(@PathVariable @NotNull String id,
                                              @Valid @RequestBody CatalogItemDTO body) {
        service.updatcatalogItem(body, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /{id} (según especificación, recibe también DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecatalogItem(@PathVariable @NotNull String id,
                                              @Valid @RequestBody(required = false) CatalogItemDTO body) {
        service.deletecatalogItem(id);
        return ResponseEntity.noContent().build();
    }
}
