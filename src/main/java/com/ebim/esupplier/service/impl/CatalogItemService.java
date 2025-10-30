
package com.ebim.esupplier.service.impl;

import com.ebim.esupplier.domain.CatalogItem;
import com.ebim.esupplier.repository.CatalogItemRepository;
import com.ebim.esupplier.service.ICatalogItemService;
import com.ebim.esupplier.web.dto.CatalogItemDTO;
import com.ebim.esupplier.web.mapper.CatalogItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatalogItemService implements ICatalogItemService {
    private final CatalogItemRepository repo;
    private final CatalogItemMapper mapper;

    public CatalogItemService(CatalogItemRepository repo, CatalogItemMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogItemDTO getcatalogItem(String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("CatalogItem not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public CatalogItemDTO savecatalogItem(CatalogItemDTO catalogItemDTO) {
        var entity = mapper.toEntity(catalogItemDTO);
        // Relationship fix if needed handled by mapper
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public CatalogItemDTO updatcatalogItem(CatalogItemDTO catalogItemDTO, String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("CatalogItem not found"));
        mapper.updateFromDTO(catalogItemDTO, entity);
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void deletecatalogItem(String id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("CatalogItem not found");
        repo.deleteById(id);
    }
}
