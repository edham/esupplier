
package com.ebim.esupplier.controller;

import com.ebim.esupplier.service.IContactService;
import com.ebim.esupplier.web.dto.ContactDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactCrudController {
    private final IContactService service;
    public ContactCrudController(IContactService service) { this.service = service; }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getcontact(@PathVariable @NotNull String id) {
        return ResponseEntity.ok(service.getcontact(id));
    }

    // POST (sin valor)
    @PostMapping
    public ResponseEntity<ContactDTO> addcontact(@Valid @RequestBody ContactDTO body) {
        return ResponseEntity.ok(service.savecontact(body));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatecontact(@PathVariable @NotNull String id,
                                              @Valid @RequestBody ContactDTO body) {
        service.updatcontact(body, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /{id} (según especificación, recibe también DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecontact(@PathVariable @NotNull String id,
                                              @Valid @RequestBody(required = false) ContactDTO body) {
        service.deletecontact(id);
        return ResponseEntity.noContent().build();
    }
}
