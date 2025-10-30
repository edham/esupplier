
package com.ebim.esupplier.service.impl;

import com.ebim.esupplier.domain.Product;
import com.ebim.esupplier.repository.ProductRepository;
import com.ebim.esupplier.service.IProductService;
import com.ebim.esupplier.web.dto.ProductDTO;
import com.ebim.esupplier.web.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService implements IProductService {
    private final ProductRepository repo;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repo, ProductMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getproduct(String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public ProductDTO saveproduct(ProductDTO productDTO) {
        var entity = mapper.toEntity(productDTO);
        // Relationship fix if needed handled by mapper
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public ProductDTO updatproduct(ProductDTO productDTO, String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        mapper.updateFromDTO(productDTO, entity);
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void deleteproduct(String id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("Product not found");
        repo.deleteById(id);
    }
}
