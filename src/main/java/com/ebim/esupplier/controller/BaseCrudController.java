
package com.ebim.esupplier.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseCrudController<T, ID> {
    protected final JpaRepository<T, ID> repo;
    protected BaseCrudController(JpaRepository<T, ID> repo) { this.repo = repo; }

    @GetMapping
    public List<T> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        return repo.findAll(PageRequest.of(page, size)).getContent();
    }

    @GetMapping("{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        Optional<T> t = repo.findById(id);
        return t.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public T create(@RequestBody T body) { return repo.save(body); }

    @PutMapping("{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T body) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repo.save(body));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
