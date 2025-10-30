
package com.ebim.esupplier.service.impl;

import com.ebim.esupplier.domain.GeneralData;
import com.ebim.esupplier.repository.GeneralDataRepository;
import com.ebim.esupplier.service.IGeneralDataService;
import com.ebim.esupplier.web.dto.GeneralDataDTO;
import com.ebim.esupplier.web.mapper.GeneralDataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GeneralDataService implements IGeneralDataService {
    private final GeneralDataRepository repo;
    private final GeneralDataMapper mapper;

    public GeneralDataService(GeneralDataRepository repo, GeneralDataMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public GeneralDataDTO getgeneralData(Integer id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("GeneralData not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public GeneralDataDTO savegeneralData(GeneralDataDTO generalDataDTO) {
        var entity = mapper.toEntity(generalDataDTO);
        // Relationship fix if needed handled by mapper
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public GeneralDataDTO updatgeneralData(GeneralDataDTO generalDataDTO, Integer id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("GeneralData not found"));
        mapper.updateFromDTO(generalDataDTO, entity);
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void deletegeneralData(Integer id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("GeneralData not found");
        repo.deleteById(id);
    }
}
