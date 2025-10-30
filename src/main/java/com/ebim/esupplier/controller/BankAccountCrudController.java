
package com.ebim.esupplier.controller;

import com.ebim.esupplier.service.IBankAccountService;
import com.ebim.esupplier.web.dto.BankAccountDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bankAccount")
public class BankAccountCrudController {
    private final IBankAccountService service;
    public BankAccountCrudController(IBankAccountService service) { this.service = service; }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<BankAccountDTO> getbankAccount(@PathVariable @NotNull String id) {
        return ResponseEntity.ok(service.getbankAccount(id));
    }

    // POST (sin valor)
    @PostMapping
    public ResponseEntity<BankAccountDTO> addbankAccount(@Valid @RequestBody BankAccountDTO body) {
        return ResponseEntity.ok(service.savebankAccount(body));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatebankAccount(@PathVariable @NotNull String id,
                                              @Valid @RequestBody BankAccountDTO body) {
        service.updatbankAccount(body, id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /{id} (según especificación, recibe también DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletebankAccount(@PathVariable @NotNull String id,
                                              @Valid @RequestBody(required = false) BankAccountDTO body) {
        service.deletebankAccount(id);
        return ResponseEntity.noContent().build();
    }
}
