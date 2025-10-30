
package com.ebim.esupplier.service.impl;

import com.ebim.esupplier.domain.SunatValidation;
import com.ebim.esupplier.repository.SunatValidationRepository;
import com.ebim.esupplier.service.ISunatValidationService;
import com.ebim.esupplier.web.dto.SunatValidationDTO;
import com.ebim.esupplier.web.mapper.SunatValidationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SunatValidationService implements ISunatValidationService {
    private final SunatValidationRepository repo;
    private final SunatValidationMapper mapper;

    public SunatValidationService(SunatValidationRepository repo, SunatValidationMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public SunatValidationDTO getsunatValidation(Integer id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("SunatValidation not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public SunatValidationDTO savesunatValidation(SunatValidationDTO sunatValidationDTO) {
        var entity = mapper.toEntity(sunatValidationDTO);
        // Relationship fix if needed handled by mapper
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public SunatValidationDTO updatsunatValidation(SunatValidationDTO sunatValidationDTO, Integer id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("SunatValidation not found"));
        mapper.updateFromDTO(sunatValidationDTO, entity);
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void deletesunatValidation(Integer id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("SunatValidation not found");
        repo.deleteById(id);
    }
}
