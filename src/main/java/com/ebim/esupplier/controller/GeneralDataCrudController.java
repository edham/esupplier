
package com.ebim.esupplier.controller;

import com.ebim.esupplier.service.IGeneralDataService;
import com.ebim.esupplier.web.dto.GeneralDataDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/generalData")
public class GeneralDataCrudController {
    private final IGeneralDataService service;
    public GeneralDataCrudController(IGeneralDataService service) { this.service = service; }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<GeneralDataDTO> getgeneralData(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(service.getgeneralData(id));
    }

    // POST (sin valor)
    @PostMapping
    public ResponseEntity<GeneralDataDTO> addgeneralData(@Valid @RequestBody GeneralDataDTO body) {
        return ResponseEntity.ok(service.savegeneralData(body));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updategeneralData(@PathVariable @NotNull Integer id,
                                              @Valid @RequestBody GeneralDataDTO body) {
        service.updatgeneralData(body, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /{id} (según especificación, recibe también DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletegeneralData(@PathVariable @NotNull Integer id,
                                              @Valid @RequestBody(required = false) GeneralDataDTO body) {
        service.deletegeneralData(id);
        return ResponseEntity.noContent().build();
    }
}
