
package com.ebim.esupplier.controller;

import com.ebim.esupplier.service.ISunatValidationService;
import com.ebim.esupplier.web.dto.SunatValidationDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sunatValidation")
public class SunatValidationCrudController {
    private final ISunatValidationService service;
    public SunatValidationCrudController(ISunatValidationService service) { this.service = service; }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<SunatValidationDTO> getsunatValidation(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(service.getsunatValidation(id));
    }

    // POST (sin valor)
    @PostMapping
    public ResponseEntity<SunatValidationDTO> addsunatValidation(@Valid @RequestBody SunatValidationDTO body) {
        return ResponseEntity.ok(service.savesunatValidation(body));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatesunatValidation(@PathVariable @NotNull Integer id,
                                              @Valid @RequestBody SunatValidationDTO body) {
        service.updatsunatValidation(body, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /{id} (según especificación, recibe también DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletesunatValidation(@PathVariable @NotNull Integer id,
                                              @Valid @RequestBody(required = false) SunatValidationDTO body) {
        service.deletesunatValidation(id);
        return ResponseEntity.noContent().build();
    }
}
