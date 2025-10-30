
package com.ebim.esupplier.controller;

import com.ebim.esupplier.service.ILocationService;
import com.ebim.esupplier.web.dto.LocationDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class LocationCrudController {
    private final ILocationService service;
    public LocationCrudController(ILocationService service) { this.service = service; }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getlocation(@PathVariable @NotNull String id) {
        return ResponseEntity.ok(service.getlocation(id));
    }

    // POST (sin valor)
    @PostMapping
    public ResponseEntity<LocationDTO> addlocation(@Valid @RequestBody LocationDTO body) {
        return ResponseEntity.ok(service.savelocation(body));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatelocation(@PathVariable @NotNull String id,
                                              @Valid @RequestBody LocationDTO body) {
        service.updatlocation(body, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /{id} (según especificación, recibe también DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletelocation(@PathVariable @NotNull String id,
                                              @Valid @RequestBody(required = false) LocationDTO body) {
        service.deletelocation(id);
        return ResponseEntity.noContent().build();
    }
}
