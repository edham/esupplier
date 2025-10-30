
package com.ebim.esupplier.controller;

import com.ebim.esupplier.service.IBusinessPartnerService;
import com.ebim.esupplier.web.dto.BusinessPartnerDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/businessPartner")
public class BusinessPartnerCrudController {
    private final IBusinessPartnerService service;
    public BusinessPartnerCrudController(IBusinessPartnerService service) { this.service = service; }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<BusinessPartnerDTO> getbusinessPartner(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(service.getbusinessPartner(id));
    }

    // POST (sin valor)
    @PostMapping
    public ResponseEntity<BusinessPartnerDTO> addbusinessPartner(@Valid @RequestBody BusinessPartnerDTO body) {
        return ResponseEntity.ok(service.savebusinessPartner(body));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatebusinessPartner(@PathVariable @NotNull Integer id,
                                              @Valid @RequestBody BusinessPartnerDTO body) {
        service.updatbusinessPartner(body, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /{id} (según especificación, recibe también DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletebusinessPartner(@PathVariable @NotNull Integer id,
                                              @Valid @RequestBody(required = false) BusinessPartnerDTO body) {
        service.deletebusinessPartner(id);
        return ResponseEntity.noContent().build();
    }
}
