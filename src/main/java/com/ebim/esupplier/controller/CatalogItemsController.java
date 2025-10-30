
package com.ebim.esupplier.controller;

import com.ebim.esupplier.domain.CatalogItem;
import com.ebim.esupplier.repository.CatalogItemRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog-items")
public class CatalogItemsController extends BaseCrudController<CatalogItem, String> {
    public CatalogItemsController(CatalogItemRepository repo) { super(repo); }
}
